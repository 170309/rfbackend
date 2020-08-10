package com.rfrongfei.onehammer.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.rfrongfei.onehammer.base.util.RedisHelper;
import com.rfrongfei.onehammer.base.util.RedisKeyHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

@Service
@Slf4j
public class SmsCodeService {

    @Autowired
    private RedisHelper redisHelper;

    public boolean sendSmsCode(String phone,String smsCode){
        try {
            String host = "https://cxkjsms.market.alicloudapi.com";
            String path = "/chuangxinsms/dxjk";
            String method = "POST";
            String appCode = "bc4d864611ee46d4a9164e390fe87dba";
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", "APPCODE " + appCode);
            Map<String, String> query = new HashMap<>();
            query.put("content", "【菜必达配送】您的验证码是" + smsCode + "，请勿将验证码泄露给他人，有效期"+(smsCodeExpire/60)+"分钟。");
            query.put("mobile", phone);
            Map<String, String> body = new HashMap<>();
            HttpResponse httpResponse = HttpUtils.doPost(host, path, method, headers, query, body);
            InputStream content = httpResponse.getEntity().getContent();
            List<String> strings1 = IOUtils.readLines(content, "UTF-8");
            if (JSON.parseObject(strings1.get(0)).get("ReturnStatus").equals("Success")) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getSmsCode(String phone, Integer userType) {
        String smsCodeKey = RedisKeyHelper.smsCode(phone, userType);
        String smsCode = redisHelper.get(smsCodeKey, String.class);
        return Optional.ofNullable(smsCode).orElse(null);
    }

    @Value("${smsCode.expire:180}")
    private Integer smsCodeExpire;

    public boolean setSmsCode(String phone, Integer userType, String value) {
        String smsCodeKey = RedisKeyHelper.smsCode(phone, userType);
        return redisHelper.set(smsCodeKey, value, smsCodeExpire);
    }

    public void clearSmsCode(String phone, Integer userType) {
        String smsCodeKey = RedisKeyHelper.smsCode(phone, userType);
        if (redisHelper.hasKey(smsCodeKey)) {
            redisHelper.del(smsCodeKey);
        }
    }

    public String getMsgCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());
        }
        return code.toString();
    }

    private static class HttpUtils {
        @SuppressWarnings("deprecation")
        private static HttpClient wrapClient(String host) {
            HttpClient httpClient = new DefaultHttpClient();
            if (host.startsWith("https://")) {
                sslClient(httpClient);
            }

            return httpClient;
        }

        private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
            StringBuilder sbUrl = new StringBuilder();
            sbUrl.append(host);
            if (!org.apache.commons.lang.StringUtils.isBlank(path)) {
                sbUrl.append(path);
            }
            if (null != querys) {
                StringBuilder sbQuery = new StringBuilder();
                for (Map.Entry<String, String> query : querys.entrySet()) {
                    if (0 < sbQuery.length()) {
                        sbQuery.append("&");
                    }
                    if (org.apache.commons.lang.StringUtils.isBlank(query.getKey()) && !org.apache.commons.lang.StringUtils.isBlank(query.getValue())) {
                        sbQuery.append(query.getValue());
                    }
                    if (!org.apache.commons.lang.StringUtils.isBlank(query.getKey())) {
                        sbQuery.append(query.getKey());
                        if (!org.apache.commons.lang.StringUtils.isBlank(query.getValue())) {
                            sbQuery.append("=");
                            sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                        }
                    }
                }
                if (0 < sbQuery.length()) {
                    sbUrl.append("?").append(sbQuery);
                }
            }

            return sbUrl.toString();
        }

        @SuppressWarnings("deprecation")
        private static void sslClient(HttpClient httpClient) {
            try {
                SSLContext ctx = SSLContext.getInstance("TLS");
                X509TrustManager tm = new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] xcs, String str) {
                    }

                    public void checkServerTrusted(X509Certificate[] xcs, String str) {
                    }
                };
                ctx.init(null, new TrustManager[]{tm}, null);
                SSLSocketFactory ssf = new SSLSocketFactory(ctx);
                ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                ClientConnectionManager ccm = httpClient.getConnectionManager();
                SchemeRegistry registry = ccm.getSchemeRegistry();
                registry.register(new Scheme("https", 443, ssf));
            } catch (KeyManagementException | NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
        }

        /**
         * post form
         *
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @param bodys
         * @return
         * @throws Exception
         */
        public static HttpResponse doPost(String host, String path, String method,
                                          Map<String, String> headers,
                                          Map<String, String> querys,
                                          Map<String, String> bodys) {
            try {
                HttpClient httpClient = wrapClient(host);
                HttpPost request = new HttpPost(buildUrl(host, path, querys));
                for (Map.Entry<String, String> e : headers.entrySet()) {
                    request.addHeader(e.getKey(), e.getValue());
                }
                if (bodys != null) {
                    List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
                    for (String key : bodys.keySet()) {
                        nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
                    }
                    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
                    formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
                    request.setEntity(formEntity);
                }
                return httpClient.execute(request);
            } catch (IOException e) {
                log.error("请求发送验证码接口失败:{}", querys.get("mobile"));
            }
            return null;
        }
    }
}
