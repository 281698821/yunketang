package cn.itsource.test;

import cn.itsource.model.Company;
import cn.itsource.model.Dept;
import cn.itsource.service.CompanyService;
import cn.itsource.service.DeptService;
import cn.itsource.service.PositionService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CompanyTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private PositionService positionService;

    @Test
    public void testName() throws Exception{
        companyService.queryAllList().forEach(e-> System.out.println(e));
    }

    /*测试部门查询*/
    @Test
    public void testName2() throws Exception{
        deptService.queryAllListWithCompany().forEach(e-> System.out.println(e));
    }

    /*测试根据id获得*/
    @Test
    public void testName3() throws Exception{
        Dept dept = deptService.queryDeptById(1L);
        System.out.println(dept);
    }
    //测试保存

    @Test
    public void testName4() throws Exception{
        Company company = companyService.queryById(1);
        Dept dept1 = new Dept();
        dept1.setCompany(company);
        deptService.insertWithCompany(dept1);
    }

    @Test
    public void testName5() throws Exception{
        positionService.queryAllListWithDept().forEach(e-> System.out.println(e));
    }
}
