package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.CompanyDao;
import cn.itsource.dao.UserDao;
import cn.itsource.model.Company;
import cn.itsource.model.Dept;
import cn.itsource.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Override
    public void updateDeletes(String ids) {
        companyDao.updateDeletes(ids);
    }

    @Override
    public Company queryCompanyByName(String name) {
        return companyDao.queryCompanyByName(name);
    }

    @Override
    public PageInfo<Company> queryPageListByParams(Integer page, Integer limit,Company company) {
        PageHelper.startPage(page, limit);
        List<Company> companies = companyDao.queryPageListByParams(company);
        // 用PageInfo对结果进行包装
        return new PageInfo<>(companies);
    }
}
