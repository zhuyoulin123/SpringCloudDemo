package com.zyl.springcloud.util;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description String操作类
 * @create 2020-08-26 20:55
 **/
public class StrUtil {
    /**
     * 判断字符串是否为空 如果为空返回true 如果不为空返回false
     *
     * @param str
     *            传入要判断的字符串
     * @return [true | false]
     */
    public static boolean isNull(String str) {
        if (null == str || str.length() <= 0 || "null".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否不为空,如果不为空返回true 如果为空false
     *
     * @param str
     *            传入要判断的字符串
     * @return [true | false]
     */
    public static boolean isNotNull(String str) {
        if (null == str || str.length() <= 0 || "null".equals(str)) {
            return false;
        }
        return true;
    }

    /**
     * 检测字符串,如果字符串为null的话，将null替换成 ""
     *
     * @param str
     *            要替换的字符串
     * @return ["" | str]
     */
    public static String isCheckNull(String str) {
        if (null == str || str.length() <= 0 || "null".equals(str) || "NULL".equals(str)) {
            return "";
        }
        str = str.replaceAll("NULL", "").replaceAll("null", "");
        return str;
    }
    private StrUtil() {}
}
