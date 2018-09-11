package net.df.generator;
import com.fasterxml.jackson.databind.JavaType;
import net.df.base.utils.FileUtils;
import net.df.base.utils.JsonUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

@Mojo(name = "generate")
public class DfMojo extends AbstractMojo {

    private ThreadLocal<ClassLoader> savedClassloader = new ThreadLocal<>();

    @Parameter(property = "df.generator.outputDirectory",
            defaultValue = "${project.build.directory}/generated-sources/df-generator", required = true)
    private File outputDirectory;

    @Parameter(property = "df.generator.configurationFile",
            defaultValue = "${project.basedir}/src/main/resources/dfConfig.json", required = true)
    private File configurationFile;

    @Parameter(property = "df.generator.verbose", defaultValue = "false")
    private boolean verbose;

    @Parameter(property = "df.generator.overwrite", defaultValue = "false")
    private boolean overwrite;

    @Parameter(property = "df.generator.skip", defaultValue = "false")
    private boolean skip;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            getLog().info("generator is skipped.");
            return;
        }
        if(configurationFile == null || !configurationFile.exists()){
            getLog().error("配置文件" + configurationFile.getAbsoluteFile().getAbsolutePath() + "不存在");
            return;
        }
        String jsonConfig = FileUtils.readFile(configurationFile);
        JavaType javaType = JsonUtils.getJavaType(LinkedHashMap.class, String.class, Configuration.class);
        Map<String,Configuration> config = JsonUtils.getObjectFromString(jsonConfig, javaType);
        for(String key : config.keySet()){
            Configuration configuration  = config.get(key);
            BaseBusinessGenerate businessGenerate = new BaseBusinessGenerate(configuration);
            businessGenerate.generate();
            getLog().info(key + "生成成功");
        }
        getLog().info("generate success");
    }
    public File getOutputDirectory() {
        return outputDirectory;
    }
    private void saveClassLoader() {
        savedClassloader.set(Thread.currentThread().getContextClassLoader());
    }
    private void restoreClassLoader() {
        Thread.currentThread().setContextClassLoader(savedClassloader.get());
    }
}