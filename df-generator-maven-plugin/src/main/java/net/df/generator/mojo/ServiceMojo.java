package net.df.generator.mojo;

import net.df.generator.service.ServiceBaseMybatisGenerator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import java.io.File;


@Mojo(name = "service")
public class ServiceMojo extends AbstractMojo {

    private ThreadLocal<ClassLoader> savedClassloader = new ThreadLocal<>();

    @Parameter(property = "df.generator.outputDirectory",
            defaultValue = "${project.build.directory}/generated-sources/df-generator", required = true)
    private File outputDirectory;

    @Parameter(property = "df.generator.configurationFile",
            defaultValue = "${project.basedir}/src/main/resources/dfConfig.xml", required = true)
    private File configurationFile;

    @Parameter(property = "mybatis.generator.verbose", defaultValue = "false")
    private boolean verbose;

    @Parameter(property = "mybatis.generator.overwrite", defaultValue = "false")
    private boolean overwrite;

    @Parameter(property = "mybatis.generator.skip", defaultValue = "false")
    private boolean skip;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            getLog().info("MyBatis generator is skipped.");
            return;
        }

        ServiceBaseMybatisGenerator generator = new ServiceBaseMybatisGenerator();
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
