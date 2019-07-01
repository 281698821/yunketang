package cn.itsource.dto;

import cn.itsource.model.Emp;
import cn.itsource.model.Recruitmentdemand;

public class RecruitmentdemandDto extends Recruitmentdemand {
    private Emp emp;
    //当前页

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "RecruitmentdemandDto{" +
                "emp=" + emp +
                '}';
    }
}
