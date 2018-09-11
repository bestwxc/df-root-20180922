package net.df.generator;

import net.df.base.exception.DfException;

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

    public String getServiceClassName(){
        return this.configuration.getService().getServiceClassName();
    }

    public String getServiceClass(){
        return this.getBasePackage() + "." + this.getModuleName() + ".service."
                + this.configuration.getService().getServiceClassName();
    }

    public String getControllerClassName(){
        return this.configuration.getController().getControllerClassName();
    }

    public String getControllerClass(){
        return this.getBasePackage()+ "." + this.getModuleName() + ".controller."
                + this.configuration.getController().getControllerClassName();
    }

    public Class getModelClazz(){
        String modelClass = this.getModelClass();
        try {
            return Class.forName(modelClass);
        } catch (ClassNotFoundException e) {
            throw new DfException("modelClass不存在",e);
        }
    }
}
