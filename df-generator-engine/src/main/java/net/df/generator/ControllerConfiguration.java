package net.df.generator;

import java.util.Map;

/**
 * Controller生成配置
 */
public class ControllerConfiguration {
    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * Controller名称
     */
    private String controllerClass;

    /**
     * 生成查询
     */
    private boolean generateList = true;

    /**
     * 生成新增
     */
    private boolean generateAdd = true;

    /**
     * 生成更新
     */
    private boolean generateUpdate = true;

    /**
     * 生成删除
     */
    private boolean generateDelete = true;

    /**
     * 查询配置
     */
    private Map<String,String> list;

    /**
     * 新增配置
     */
    private Map<String,String> add;

    /**
     * 更新配置
     */
    private Map<String,String> update;

    /**
     * 删除配置
     */
    private Map<String,String> delete;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(String controllerClass) {
        this.controllerClass = controllerClass;
    }

    public boolean isGenerateList() {
        return generateList;
    }

    public void setGenerateList(boolean generateList) {
        this.generateList = generateList;
    }

    public boolean isGenerateAdd() {
        return generateAdd;
    }

    public void setGenerateAdd(boolean generateAdd) {
        this.generateAdd = generateAdd;
    }

    public boolean isGenerateUpdate() {
        return generateUpdate;
    }

    public void setGenerateUpdate(boolean generateUpdate) {
        this.generateUpdate = generateUpdate;
    }

    public boolean isGenerateDelete() {
        return generateDelete;
    }

    public void setGenerateDelete(boolean generateDelete) {
        this.generateDelete = generateDelete;
    }

    public Map<String, String> getList() {
        return list;
    }

    public void setList(Map<String, String> list) {
        this.list = list;
    }

    public Map<String, String> getAdd() {
        return add;
    }

    public void setAdd(Map<String, String> add) {
        this.add = add;
    }

    public Map<String, String> getUpdate() {
        return update;
    }

    public void setUpdate(Map<String, String> update) {
        this.update = update;
    }

    public Map<String, String> getDelete() {
        return delete;
    }

    public void setDelete(Map<String, String> delete) {
        this.delete = delete;
    }
}
