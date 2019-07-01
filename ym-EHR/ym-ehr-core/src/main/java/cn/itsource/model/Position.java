package cn.itsource.model;

import javax.persistence.*;

@Table(name = "ehr_position")
public class Position {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 编号
     */
    private String name;

    /**
     * 备注
     */
    private String mark;

    /**
     * 对应部门
     */
   /* @Column(name = "dept_id")
    private Integer deptId;*/
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    /**
     * 逻辑删除
     */
    @Column(name = "logicToDelete")
    private Integer logictodelete;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取编号
     *
     * @return name - 编号
     */
    public String getName() {
        return name;
    }

    /**
     * 设置编号
     *
     * @param name 编号
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    //获得部门
    public Dept getDept() {
        return dept;
    }
    //设置部门
    public void setDept(Dept dept) {
        this.dept = dept;
    }

    /**
     * 获取逻辑删除
     *
     * @return logicToDelete - 逻辑删除
     */
    public Integer getLogictodelete() {
        return logictodelete;
    }

    /**
     * 设置逻辑删除
     *
     * @param logictodelete 逻辑删除
     */
    public void setLogictodelete(Integer logictodelete) {
        this.logictodelete = logictodelete;
    }
}