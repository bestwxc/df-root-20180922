package net.df.boot.datasource.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

@ConfigurationProperties(prefix = "df.boot.datasource")
public class MultiDataSourceProperties {
    private boolean enableMultiDataSource;
    private String multiDataSourceType;
    private String defaultDataSourceKey;
    private List<String> multiDataSourceList;

    public boolean isEnableMultiDataSource() {
        return enableMultiDataSource;
    }

    public void setEnableMultiDataSource(boolean enableMultiDataSource) {
        this.enableMultiDataSource = enableMultiDataSource;
    }

    public String getMultiDataSourceType() {
        return multiDataSourceType;
    }

    public void setMultiDataSourceType(String multiDataSourceType) {
        this.multiDataSourceType = multiDataSourceType;
    }

    public String getDefaultDataSourceKey() {
        return defaultDataSourceKey;
    }

    public void setDefaultDataSourceKey(String defaultDataSourceKey) {
        this.defaultDataSourceKey = defaultDataSourceKey;
    }

    public List<String> getMultiDataSourceList() {
        return multiDataSourceList;
    }

    public void setMultiDataSourceList(List<String> multiDataSourceList) {
        this.multiDataSourceList = multiDataSourceList;
    }
}
