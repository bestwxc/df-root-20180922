package net.df.base.server;

import net.df.base.constants.ResultType;
import java.util.List;

/**
 * 多结果集
 * @param <T>
 */
public class MultiResult<T> extends Result<T>{

    private Integer pageNo = 1;
    private Integer pageSize = 100;

    public MultiResult(){
        super(ResultType.LIST);
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setResultList(List<T> list){
        super.setResult(list);
    }

    public List<T> getResultList(){
        return (List<T>) super.getResult();
    }
}
