package com.rfrongfei.onehammer.base.util;

import com.rfrongfei.onehammer.base.exception.OnehammerException;
import com.rfrongfei.onehammer.base.properties.TokenProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

/**
 * @description: jwt生成token
 */
public class JwtTokenHelper {

    public static TokenProperties tokenProperties;

    // 寻找证书文件
    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks"); // 寻找证书文件
    private static PrivateKey privateKey = null;
    private static PublicKey publicKey = null;

    static { // 将证书文件里边的私钥公钥拿出来
        tokenProperties = SpringContextHelper.getBean(TokenProperties.class);
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS"); // java key store 固定常量
            keyStore.load(inputStream, "123456".toCharArray());
            privateKey = (PrivateKey) keyStore.getKey("jwt", "123456".toCharArray()); // jwt 为 命令生成整数文件时的别名
            publicKey = keyStore.getCertificate("jwt").getPublicKey();
        } catch (Exception e) {
            throw new OnehammerException(JwtTokenHelper.class,"static init","初始化JWT证书文件失败");
        }
    }

    /**
     * 生成token
     * @param userId （主体信息）
     * @param claims 自定义身份信息
     * @return String
     */
    public static String generate(String userId, Integer userTpye) {
        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        final HashMap<String, Object> claims = new HashMap<>();
        claims.put("userType",userTpye);
        // 下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() // 这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)          // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setId(Constant.JWT_ID)                  // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)           // iat: jwt的签发时间
                .setIssuer("www.rfrongfei.com")          // issuer：jwt签发人
                .setSubject(userId)        // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(SignatureAlgorithm.HS256, privateKey); // 设置签名使用的签名算法和签名使用的秘钥
        // 设置过期时间
        if (tokenProperties.getExpire() >= 0) {
            long expMillis = nowMillis + tokenProperties.getExpire()*24000*3600; // 15天过期
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    // 是否已过期
    public static boolean isExpiration(String expirationTime){
        return DateUtil.compareDate(DateUtil.getTime(), expirationTime);
    }

    public static String getUserId(String token){
        final Claims tokenBody = getTokenBody(token);
        return tokenBody.getSubject();
    }

    public static Integer getUserType(String token){
        final Claims tokenBody = getTokenBody(token);
        return Integer.parseInt(tokenBody.get("userType").toString());
    }

    public static String flush(String token){
        final Claims tokenBody = getTokenBody(token);
        final String expirationTime = new Timestamp(tokenBody.getExpiration().getTime()).toString();
        if (isExpiration(expirationTime)) {
            return generate(getUserId(token),getUserType(token));
        }
        return token;
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
