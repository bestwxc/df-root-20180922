package net.df.base.utils;

import net.df.base.exception.DfException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware{

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        if(applicationContext == null) {
            throw new DfException("容器未初始化，无法获取注入的applicationContext");
        }
        return applicationContext;
    }


    /**
     * 获取Bean对象
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * 获取Bean对象
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> requiredType){
        return getApplicationContext().getBean(requiredType);
    }

    /**
     * 获取Bean对象
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, @Nullable Class<T> requiredType){
        return getApplicationContext().getBean(name,requiredType);
    }
}
