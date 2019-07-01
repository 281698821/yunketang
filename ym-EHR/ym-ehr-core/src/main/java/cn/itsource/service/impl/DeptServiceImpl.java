package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.DeptDao;
import cn.itsource.model.Dept;
import cn.itsource.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public void updateDeletes(String ids) {
        deptDao.updateDeletes(ids);
    }

    @Override
    public PageInfo<Dept> queryPageListByParams(Integer page, Integer limit, Dept dept) {
        PageHelper.startPage(page, limit);
        List<Dept> depts = deptDao.queryPageListByParams(dept);
        // 用PageInfo对结果进行包装
       return new PageInfo<>(depts);
    }

    @Override
    public List<Dept> queryAllListWithCompany() {
        return deptDao.queryAllListWithCompany();
    }

    @Override
    public Dept queryDeptById(Long id) {
        return deptDao.queryDeptById(id);
    }

    @Override
    public void insertWithCompany(Dept dept) {
        deptDao.insertWithCompany(dept);
    }

    @Override
    public void updateWithCompany(Dept dept) {
        deptDao.updateWithCompany(dept);
    }

    @Override
    public List<Dept> queryDeptByName(String name) {
        return deptDao.queryDeptByName(name);
    }

    @Override
    public List<Dept> queryAllByDistinct() {
        return deptDao.queryAllByDistinct();
    }
}
