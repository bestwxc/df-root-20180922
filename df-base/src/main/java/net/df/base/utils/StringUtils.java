package net.df.base.utils;

/**
 * 常用的字符串转换类
 */
public class StringUtils {
    /**
     * 类名转对象名
     * @param className
     * @return
     */
    public static String classNameToObjectName(String className){
        return className.substring(0,1).toLowerCase() + className.substring(1, className.length());
    }
}
