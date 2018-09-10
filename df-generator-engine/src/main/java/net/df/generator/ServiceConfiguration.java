package net.df.generator;

/**
 * service生成配置
 */
public class ServiceConfiguration {
    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * Service名称
     */
    private String serviceClass;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }
}
