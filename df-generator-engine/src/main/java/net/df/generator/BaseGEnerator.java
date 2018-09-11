package net.df.generator;

public abstract class BaseGEnerator implements Generator{
    private Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getBasePackage(){
        return this.configuration.getBasePackage();
    }

    public String getModuleName(){
        return this.configuration.getModuleName();
    }
    public String getModelClass(){
        return this.getBasePackage() + "." + this.getModuleName() + ".model."
                + this.configuration.getModelClassName();
    }

    public String getServiceClass(){
        return this.getBasePackage() + "." + this.getModuleName() + ".model."
                + this.configuration.getService().getServiceClassName();
    }

    public String getControllerClass(){
        return this.getBasePackage()+ "." + this.getModuleName() + ".model."
                + this.configuration.getController().getControllerClassName();
    }
}
