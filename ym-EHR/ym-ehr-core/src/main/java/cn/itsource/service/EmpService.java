package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface EmpService extends BaseService<Emp> {
    public void updateDeletes(String ids);


    public PageInfo<Emp> queryListByPage(Integer page, Integer limit,Emp emp);

    public PageInfo<Emp> queryAllWithOthers(Integer page, Integer limit,Emp emp);

    public List<Emp> queryAllWithOthers(Emp emp);

    public Emp queryByIdWithOther(Integer id);

  /*  *//*和部门和公司连接查询*//*
    public PageInfo<Emp> queryPageListByParams(Integer page, Integer limit, Emp emp);*/

}
