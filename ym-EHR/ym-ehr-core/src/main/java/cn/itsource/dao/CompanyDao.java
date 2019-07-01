package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Company;
import cn.itsource.model.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CompanyDao extends BaseMapper<Company> {
    @Update("update ehr_company set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

    /*根据公司名字查询公司*/
    @Select("select * from ehr_company e where e.name = #{name} ")
    public Company queryCompanyByName(String name);

    /*模糊查询+分页*/
    public List<Company> queryPageListByParams(Company company);
}