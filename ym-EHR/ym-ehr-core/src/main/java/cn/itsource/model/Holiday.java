package cn.itsource.model;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import java.sql.JDBCType;
import java.util.Date;
import javax.persistence.*;

@Table(name = "ehr_holiday")
public class Holiday {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 节日名称
     */
    private String name;

    /**
     * 时间
     */
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date time;

    /**
     * 删除标志(0：删除、1：未删除)
     */
    @Column(name = "logicToDelete")
    private Integer delFlag;

    /**
     * 节日祝福语
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

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
     * 获取节日名称
     *
     * @return name - 节日名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置节日名称
     *
     * @param name 节日名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取时间
     *
     * @return time - 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", delFlag=" + delFlag +
                '}';
    }
}