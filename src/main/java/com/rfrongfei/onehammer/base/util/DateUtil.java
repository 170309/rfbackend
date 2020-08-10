package com.rfrongfei.onehammer.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description: 时间工具类
 */
public class DateUtil {

    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat simpleTime = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当前时间的YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    /**
     * 获取年月日格式的日期 2019-10-11
     *
     * @return : {@link String}
     */
    public static String getSimpleTime() {
        return simpleTime.format(new Date());
    }

    public static String getSimpleTime(Date time) {
        return simpleTime.format(time);
    }

    public static Date time() {
        return getTime(getTime());
    }


    /**
     * 获取当前时间的YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static Date getTime(String dateStr) {
        try {
            return sdfTime.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("获取yyyy-MM-dd HH:mm:ss格式时间失败");
    }

    /**
     * 日期比较，如果s>=e 返回true 否则返回false
     *
     * @param s
     * @param e
     * @return
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return s.compareTo(e) > 0;
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前时间的后i天
     *
     * @param i
     * @return
     */
    public static String getAddDay(int i) {
        String currentTime = DateUtil.getTime();
        GregorianCalendar gCal = new GregorianCalendar(
                Integer.parseInt(currentTime.substring(0, 4)),
                Integer.parseInt(currentTime.substring(5, 7)) - 1,
                Integer.parseInt(currentTime.substring(8, 10)));
        gCal.add(GregorianCalendar.DATE, i);
        return simpleTime.format(gCal.getTime());
    }

    /**
     * 获取当前时间的后i天
     * 精确到秒
     *
     * @param i
     * @return
     */
    public static String getAddDayTime(int i) {
        Date date = new Date(System.currentTimeMillis() + i * 24 * 60 * 60 * 1000);
        return sdfTime.format(date);
    }

    /**
     * 获取当前时间的+多少秒
     * 精确到秒
     *
     * @param i
     * @return
     */
    public static String getAddDaySecond(int i) {
        Date date = new Date(System.currentTimeMillis() + i * 1000);
        return sdfTime.format(date);
    }

    /**
     * 获取两个时间之间有多少天
     *
     * @param strTime1 :
     * @param strTime2 :
     * @return : {@link Date}
     */
    public static Integer timeDiff(String strTime1, String strTime2) {
        //格式日期格式，在此我用的是"2018-01-24 19:49:50"这种格式
        //可以更改为自己使用的格式，例如：yyyy/MM/dd HH:mm:ss 。。。
        try {
            Date now = sdfTime.parse(strTime1);
            Date date = sdfTime.parse(strTime2);
            long l = now.getTime() - date.getTime();       //获取时间差
            return Math.toIntExact(l / (24 * 60 * 60 * 1000));
        } catch (Exception e) {
            throw new RuntimeException("获取时间差值失败");
        }
    }

    public static Integer timeDiff(String[] strs) {
        return timeDiff(strs[0],strs[1]);
    }
}
