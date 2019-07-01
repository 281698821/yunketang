package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyService extends BaseService<Company> {
    public void updateDeletes(String ids);

    //根据名字查询公司
    public Company queryCompanyByName(String name);

    public PageInfo<Company> queryPageListByParams(Integer page, Integer limit, Company company);
}
