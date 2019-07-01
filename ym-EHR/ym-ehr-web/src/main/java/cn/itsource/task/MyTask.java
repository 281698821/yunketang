package cn.itsource.task;

import cn.itsource.model.Emp;
import cn.itsource.model.Holiday;
import cn.itsource.service.EmpService;
import cn.itsource.service.HolidayService;
import cn.itsource.service.UserService;
import cn.itsource.utils.EmailUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MyTask {
    @Autowired
    private HolidayService holidayService;
    @Autowired
    private EmailUtills emailUtills;
    @Autowired
    private EmpService empService;
    // 每天上午10:15触发
   // @Scheduled(cron = "0/2 * * * * ? ")        每2秒执行一次
    @Scheduled(cron = "0 15 10 ? * *")
    public void wishes(){
        Holiday holiday = holidayService.queryByTime(new Date());
        System.out.println(holiday);
        if (holiday!=null){
            List<Emp> emps = empService.queryAllList();
            for (Emp emp : emps) {
                emailUtills.sendHtmlMail(emp.getEmail(),holiday.getName()+"快乐",holiday.getContent());
            }
        }

    }
}