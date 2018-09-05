package net.df.generator.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import net.df.base.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ReflectionUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServiceBaseMybatisGenerator {

    private Logger logger = LoggerFactory.getLogger(ServiceBaseMybatisGenerator.class);
    private String basePackage = "net.df.module";
    private String className;
    private String objectName;
    private String moduleName;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void generate(){
        Writer writer = null;
        String modelClass = basePackage + "." + moduleName + ".model." + className;
        String serviceClass = basePackage + "." + moduleName + ".service." + className + "Service";
        try {
            Class clszz = Class.forName(modelClass);
            LinkedHashMap<String, String> fieldMap = new LinkedHashMap();
            LinkedHashMap<String, String> fieldMap2 = new LinkedHashMap();


            ReflectionUtils.doWithFields(clszz, field -> {
                ReflectionUtils.makeAccessible(field);
                String type = field.getType().getName();
                type = type.substring(type.lastIndexOf(".") + 1,type.length());
                fieldMap.put(field.getName(), type);
                if("id".equals(field.getName()) || "createTime".equals(field.getName()) || "updateTime".equals(field.getName())){

                }else{
                    fieldMap2.put(field.getName(), type);
                }
            });
            Map<String, Object> map = new HashMap();
            map.put("moduleName", moduleName);
            map.put("className", className);
            map.put("objectName", objectName);
            map.put("fieldMap", fieldMap);
            map.put("fieldMap2", fieldMap2);
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
            Resource resource = new ClassPathResource("");
            cfg.setDirectoryForTemplateLoading(resource.getFile());
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template temp = cfg.getTemplate("Service.ftl");
            writer = new FileWriter(new File("src" + File.separator + "main" + File.separator + "java" + File.separator + serviceClass.replaceAll("\\.", File.separator) + ".java"));
            temp.process(map, writer);
        }catch (Exception e){
            logger.error("生成Service出错", e);
        } finally {
            FileUtils.close(writer);
        }
    }
}
