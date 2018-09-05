package net.df.module.${moduleName}.service;

import net.df.base.utils.ValidateUtils;
import net.df.module.${moduleName}.mapper.${className}Mapper;
import net.df.module.${moduleName}.model.${className};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;
import java.util.Date;
import java.util.List;

@Service
public class ${className}Service {

    @Autowired
    private ${className}Mapper ${objectName}Mapper;


    <#assign  keys=fieldMap?keys/>
    <#assign  keys2=fieldMap2?keys/>
    /**
     * 新增
    <#list keys2 as key>
     * @param ${key}
    </#list>
     * @return
     */
    public ${className} add(<#list keys2 as key>${fieldMap2["${key}"]} ${key}<#if keys2?size != (key_index + 1)>,</#if></#list>){
        ${className} ${objectName} = new ${className}();
        setObject(${objectName},<#list keys2 as key>${key}<#if keys2?size != (key_index + 1)>,</#if></#list>);
        Date now = new Date();
        ${objectName}.setCreateTime(now);
        ${objectName}.setUpdateTime(now);
        ${objectName}Mapper.insert(${objectName});
        return ${objectName};
    }


    /**
     * 更新
     * @param id
    <#list keys2 as key>
     * @param ${key}
    </#list>
     * @return
     */
    public ${className} update(Long id, <#list keys2 as key>${fieldMap2["${key}"]} ${key}<#if keys2?size != (key_index + 1)>,</#if></#list>){
        ${className} ${objectName} = ${objectName}Mapper.selectByPrimaryKey(id);
        setObject(${objectName},<#list keys2 as key>${key}<#if keys2?size != (key_index + 1)>,</#if></#list>);
        Date now = new Date();
        ${objectName}.setUpdateTime(now);
        ${objectName}Mapper.updateByPrimaryKey(${objectName});
        return ${objectName};
    }

    /**
     * 查询
    <#list keys as key>
     * @param ${key}
    </#list>
     * @return
     */
    public List<${className}> list(<#list keys as key>${fieldMap["${key}"]} ${key}<#if keys?size != (key_index + 1)>,</#if></#list>){
        Example example = this.getExample(<#list keys as key>${key}<#if keys?size != (key_index + 1)>,</#if></#list>);
        return ${objectName}Mapper.selectByExample(example);
    }

    /**
     * 查询一个
    <#list keys as key>
     * @param ${key}
    </#list>
     * @return
     */
    public ${className} listOne(<#list keys as key>${fieldMap["${key}"]} ${key}<#if keys?size != (key_index + 1)>,</#if></#list>){
        Example example = this.getExample(<#list keys as key>${key}<#if keys?size != (key_index + 1)>,</#if></#list>);
        return ${objectName}Mapper.selectOneByExample(example);
    }


    /**
     * 删除
    <#list keys as key>
     * @param ${key}
    </#list>
     * @return
     */
    public int delete(<#list keys as key>${fieldMap["${key}"]} ${key}<#if keys?size != (key_index + 1)>,</#if></#list>){
        Example example = this.getExample(<#list keys as key>${key}<#if keys?size != (key_index + 1)>,</#if></#list>);
        return ${objectName}Mapper.deleteByExample(example);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Long id){
        return this.delete(<#list keys as key> <#if key_index == 0>id<#else>null</#if><#if keys?size != (key_index + 1)>,</#if></#list>);
    }


    /**
     * 组装更新数据
    <#list keys2 as key>
     * @param ${key}
    </#list>
     * @return
     */
    private void setObject(${className} ${objectName}, <#list keys2 as key>${fieldMap2["${key}"]} ${key}<#if keys2?size != (key_index + 1)>,</#if></#list>){
        <#list keys2 as key>
        if(ValidateUtils.<#if fieldMap2["${key}"] == "String">isNotEmptyString<#else>notNull</#if>(${key})){
            ${objectName}.set${key?cap_first}(${key});
        }
        </#list>
    }

    /**
     * 组装Example
    <#list keys as key>
     * @param ${key}
    </#list>
     * @return
     */
    private Example getExample(<#list keys as key>${fieldMap["${key}"]} ${key}<#if keys?size != (key_index + 1)>,</#if></#list>){
        WeekendSqls<${className}> sqls = WeekendSqls.<${className}>custom();
        <#list keys as key>
        if(ValidateUtils.<#if fieldMap["${key}"] == "String">isNotEmptyString<#else>notNull</#if>(${key})) {
            sqls.andEqualTo(${className}::get${key?cap_first}, ${key});
        }
        </#list>
        Example example = new Example.Builder(${className}.class).where(sqls).build();
        return example;
    }
}
