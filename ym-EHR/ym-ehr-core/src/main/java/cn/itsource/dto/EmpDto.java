package cn.itsource.dto;

import cn.itsource.model.Dept;
import cn.itsource.model.Emp;
import cn.itsource.model.Paygrades;
import cn.itsource.model.Position;



public class EmpDto extends Emp {

    /**
     * 部门
     */
    private Dept dept;

    /**
     * 薪资等级
     */
    private Paygrades paygrades;

    /**
     * 职位
     */
    private Position position;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Paygrades getPaygrades() {
        return paygrades;
    }

    public void setPaygrades(Paygrades paygrades) {
        this.paygrades = paygrades;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}

