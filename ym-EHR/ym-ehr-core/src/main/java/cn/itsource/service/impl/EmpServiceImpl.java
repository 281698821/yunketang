package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.EmpDao;
import cn.itsource.dao.UserDao;
import cn.itsource.model.Dept;
import cn.itsource.model.Compensation;
import cn.itsource.model.Emp;
import cn.itsource.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl extends BaseServiceImpl<Emp> implements EmpService {
    @Autowired
    EmpDao empDao;

    @Override
    public void updateDeletes(String ids) {
        empDao.updateDeletes(ids);
    }

   /* @Override
    public PageInfo<Emp> queryPageListByParams(Integer page, Integer limit, Emp emp) {
        PageHelper.startPage(page, limit);
        List<Emp> emps = empDao.queryPageListByParams(emp);
        // 用PageInfo对结果进行包装
        return new PageInfo<>(emps);
    }*/

    @Override
    public PageInfo<Emp> queryListByPage(Integer pageNum, Integer pageSize, Emp emp) {
        PageHelper.startPage(pageNum,pageSize);
        List<Emp> emps = empDao.querySomeList(emp);
        return new PageInfo<Emp>(emps);
    }

    @Override
    public PageInfo<Emp> queryAllWithOthers(Integer pageNum, Integer pageSize, Emp emp) {
        PageHelper.startPage(pageNum,pageSize);
        List<Emp> emps = empDao.queryAllWithOthers(emp);
        return new PageInfo<Emp>(emps);
    }

    @Override
    public List<Emp> queryAllWithOthers(Emp emp) {
        return empDao.queryAllWithOthers(emp);
    }

    @Override
    public Emp queryByIdWithOther(Integer id) {
        return empDao.queryByIdWithOther(id);
    }
}
