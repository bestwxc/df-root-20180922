package net.df.boot.web.utils;

import net.df.base.server.Result;
import net.df.base.utils.FileUtils;
import net.df.base.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * 响应工具类
 */
public class ResponseUtils {
    private static Logger logger = LoggerFactory.getLogger(ResponseUtils.class);
    public static void returnJsonResult(HttpServletResponse response, Result result){
        Writer writer = null;
        Exception exception = null;
        try {
            writer = response.getWriter();
            response.setHeader("Content-Type","application/json;charset=UTF-8");
            writer.write(JsonUtils.writeObjectAsString(result, true));
            writer.flush();
        }catch (IOException e){
            exception = e;
            logger.error("将Result用Json格式写入response失败,result:",result);
        }finally {
            FileUtils.close(writer, exception);
        }
    }
}