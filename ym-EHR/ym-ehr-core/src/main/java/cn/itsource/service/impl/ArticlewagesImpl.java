package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.ArticlewagesDao;
import cn.itsource.dto.Compensationdto;
import cn.itsource.model.Articlewages;
import cn.itsource.model.Emp;
import cn.itsource.model.Paygrades;
import cn.itsource.model.RewardPunish;
import cn.itsource.service.ArticlewagesService;
import cn.itsource.service.EmpService;
import cn.itsource.service.PaygradesService;
import cn.itsource.service.RewardPunishService;
import cn.itsource.utils.EmailUtills;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticlewagesImpl extends BaseServiceImpl<Articlewages> implements ArticlewagesService {
    @Autowired
    private ArticlewagesDao articlewagesDao;
    @Autowired
    private ArticlewagesService articlewagesService;
    @Autowired
    private PaygradesService paygradesService;
    @Autowired
    private RewardPunishService rewardPunishService;
    @Autowired
    private EmpService empService;
    @Autowired
    private EmailUtills emailUtills;

    @Override
    public void updateDeletes(String ids) {
        articlewagesDao.updateDeletes(ids);
    }

    @Override
    public List<Articlewages> findbyname() {
        return articlewagesDao.findbyname();
    }

    @Override
    public List<RewardPunish> findRewar(Integer id) {

        return articlewagesDao.findRewar(id);
    }

    @Override
    public Compensationdto findbycompen(Integer id) {
        return articlewagesDao.findbycompen(id);
    }

    @Override
    public PageInfo<Articlewages> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Articlewages> list = new ArrayList();
        List<Emp> emps = empService.queryAllList();

        emps.forEach((Emp e) ->{
            //应发工资 基本工资+补贴+员工等级薪资
            Compensationdto findbycompen = articlewagesService.findbycompen(e.getId());
            if(findbycompen!=null) {
                Articlewages articlewages = new Articlewages();
                //拿到员工等级
                Paygrades paygrades = paygradesService.queryById(e.getPaygradesId());
                //编号
                articlewages.setId(e.getId());
                //姓名
                articlewages.setEmpname(e.getName());
                // System.out.println("姓名"+e.getName());

                //应发工资
                articlewages.setShouldsend(findbycompen.getBasicsalary() + findbycompen.getSubsidies() + paygrades.getSalary());
                //System.out.println("应发工资"+articlewages.getShouldsend());
                //投保
                articlewages.setInsured((findbycompen.getSocialsecurity().getPurchaserate())*articlewages.getShouldsend()/100);
                // System.out.println("投保"+articlewages.getInsured());
                //奖惩
                List<RewardPunish> rewar = articlewagesService.findRewar(e.getId());
                if(rewar!=null) {
                    rewar.forEach(c -> {
                        int a = 0;
                        int b = 0;
                        if(c.getJudge()==0){
                            a +=c.getMoney();
                            articlewages.setFine(a);
                        }else{
                            b +=c.getMoney();
                            articlewages.setBonus(b);
                        }
                        if(articlewages.getFine()==null){
                            articlewages.setFine(0);
                        }
                        if(articlewages.getBonus()==null){
                            articlewages.setBonus(0);
                        }
                    });
                }

                articlewages.setRealhair(articlewages.getShouldsend()+articlewages.getFine()-articlewages.getBonus()-articlewages.getInsured());
                // System.out.println("实发工资"+articlewages.getRealhair());
                articlewages.setLogictodelete(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ss");
                String format = simpleDateFormat.format(new Date());
                try {
                    Date parse = simpleDateFormat.parse(format);
                    articlewages.setTime(parse);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                articlewages.setEmpId(e.getId());
                list.add(articlewages);
            }

        });
        return  new PageInfo<Articlewages>(list);
    }




}
