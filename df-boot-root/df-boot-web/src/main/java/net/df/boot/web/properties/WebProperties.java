package net.df.boot.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "df.boot.web")
public class WebProperties {
    private boolean openCors;

    private boolean openHttpDebugLog;

    private String securityType;


    public boolean isOpenCors() {
        return openCors;
    }

    public void setOpenCors(boolean openCors) {
        this.openCors = openCors;
    }

    public boolean isOpenHttpDebugLog() {
        return openHttpDebugLog;
    }

    public void setOpenHttpDebugLog(boolean openHttpDebugLog) {
        this.openHttpDebugLog = openHttpDebugLog;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getSecurityType() {
        return securityType;
    }
}
