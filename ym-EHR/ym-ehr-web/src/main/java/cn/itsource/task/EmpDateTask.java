package cn.itsource.task;

import cn.itsource.service.EmpDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmpDateTask {
    @Autowired
    EmpDateService empDateService;
    //每天00:00:00定时同步前一天打卡数据
    @Scheduled(cron = "0 0 0 * * ? ")
    public void updatePlayCardDate(){
        empDateService.updateCardDate(new Date());
    }
}
