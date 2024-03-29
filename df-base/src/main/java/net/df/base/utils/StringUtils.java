package net.df.base.utils;

import java.util.List;

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

    /**
     * 拼接字符串并用指定的符号分隔
     * @param stringList
     * @param split
     * @return
     */
    public static String concat(List<String> stringList, String split){
        StringBuffer stringBuffer = new StringBuffer();
        final String _split = split == null ? "" : split;
        for(int i = 0; i < stringList.size(); i++){
            if(i == 0){
                stringBuffer.append(stringList.get(i));
            }else {
                stringBuffer.append(_split).append(stringList.get(i));
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 拼接字符串
     * @param stringList
     * @return
     */
    public static String concat(List<String> stringList){
        return concat(stringList, null);
    }
}
