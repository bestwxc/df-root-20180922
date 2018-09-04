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

    public ${className} add(<#list keys2 as key>${fieldMap2["${key}"]} ${key},</#list>){
        ${className} ${objectName} = new ${className}();
        setObject(<#list keys2 as key>${key},</#list>);
        Date now = new Date();
        ${objectName}.setCreateTime(now);
        ${objectName}.setUpdateTime(now);
        ${objectName}Mapper.insert(${objectName});
        return ${objectName};
    }


    public ${className} update(Long id, String ${objectName}Code, String ${objectName}Name, Long parent${className}Id){
        ${className} ${objectName} = ${objectName}Mapper.selectByPrimaryKey(id);
        setObject(${objectName}, ${objectName}Code, ${objectName}Name, parent${className}Id);
        Date now = new Date();
        ${objectName}.setUpdateTime(now);
        ${objectName}Mapper.updateByPrimaryKey(${objectName});
        return ${objectName};
    }

    public List<${className}> list(Long id, String ${objectName}Code, String ${objectName}Name, Long parent${className}Id){
        Example example = this.getExample(id, ${objectName}Code, ${objectName}Name, parent${className}Id);
        return ${objectName}Mapper.selectByExample(example);
    }

    public ${className} listOne(Long id, String ${objectName}Code, String ${objectName}Name, Long parent${className}Id){
        Example example = this.getExample(id, ${objectName}Code, ${objectName}Name, parent${className}Id);
        return ${objectName}Mapper.selectOneByExample(example);
    }


    public int delete(Long id, String ${objectName}Code, String ${objectName}Name, Long parent${className}Id){
        Example example = this.getExample(id, ${objectName}Code, ${objectName}Name, parent${className}Id);
        return ${objectName}Mapper.deleteByExample(example);
    }

    public int delete(Long id){
        return this.delete(id, null, null, null);
    }

    private void setObject(${className} ${objectName}, String ${objectName}Code, String ${objectName}Name, Long parent${className}Id){
        if(ValidateUtils.isNotEmptyString(${objectName}Code)){
            ${objectName}.set${className}Code(${objectName}Code);
        }
        if(ValidateUtils.isNotEmptyString(${objectName}Name)){
            ${objectName}.set${className}Name(${objectName}Name);
        }
        if(ValidateUtils.notNull(parent${className}Id)){
            ${objectName}.setParent${className}Id(parent${className}Id);
        }
    }

    private Example getExample(Long id, String ${objectName}Code, String ${objectName}Name, Long parent${className}Id){
        WeekendSqls<${className}> sqls = WeekendSqls.<${className}>custom();
        if(ValidateUtils.notNull(id)){
            sqls.andEqualTo(${className}::getId,id);
        }
        if(ValidateUtils.isNotEmptyString(${objectName}Code)){
            sqls.andEqualTo(${className}::get${className}Code,${objectName}Code);
        }
        if(ValidateUtils.isNotEmptyString(${objectName}Name)){
            sqls.andEqualTo(${className}::get${className}Name,${objectName}Name);
        }
        if(ValidateUtils.notNull(parent${className}Id)){
            sqls.andEqualTo(${className}::getParent${className}Id,parent${className}Id);
        }
        Example example = new Example.Builder(${className}.class).where(sqls).build();
        return example;
    }
}
