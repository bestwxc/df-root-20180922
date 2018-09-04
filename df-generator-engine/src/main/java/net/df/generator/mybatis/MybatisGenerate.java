package net.df.generator.mybatis;

import net.df.base.exception.DfException;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MybatisGenerate {

    private Logger logger = LoggerFactory.getLogger(MybatisGenerate.class);

    private boolean overwrite = true;

    private Configuration config;

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    public void generator(){
        try {
            List<String> warnings = new ArrayList<String>();
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch (Exception e){
            throw new DfException("调用代码生成抛出异常",e);
        }
    }
}
