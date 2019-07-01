package cn.itsource.dto;

import cn.itsource.model.Compensation;
import cn.itsource.model.Emp;
import cn.itsource.model.Socialsecurity;

public class Compensationdto extends Compensation{
    /**
     * 员工
     */
    private Emp emp;
    /**
     * 社保
     */
    private Socialsecurity socialsecurity;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Socialsecurity getSocialsecurity() {
        return socialsecurity;
    }

    public void setSocialsecurity(Socialsecurity socialsecurity) {
        this.socialsecurity = socialsecurity;
    }

    @Override
    public String toString() {
        return "Compensationdto{" +
                "emp=" + emp +
                ", socialsecurity=" + socialsecurity +
                "} " + super.toString();
    }
}
