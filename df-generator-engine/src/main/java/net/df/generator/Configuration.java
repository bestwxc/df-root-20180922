package net.df.generator;

/**
 * 配置类
 */
public class Configuration {

    /**
     * 公共包名
     */
    private String basePackage = "net.df.module";

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 实体类名称
     */
    private String modelClass;

    /**
     * Service配置
     */
    private ServiceConfiguration service;

    /**
     * Controller配置
     */
    private ControllerConfiguration controller;

    /**
     * view配置
     */
    private ViewConfiguration view;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModelClass() {
        return modelClass;
    }

    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }

    public ServiceConfiguration getService() {
        return service;
    }

    public void setService(ServiceConfiguration service) {
        this.service = service;
    }

    public ControllerConfiguration getController() {
        return controller;
    }

    public void setController(ControllerConfiguration controller) {
        this.controller = controller;
    }

    public ViewConfiguration getView() {
        return view;
    }

    public void setView(ViewConfiguration view) {
        this.view = view;
    }
}
