package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Applicant;
import cn.itsource.model.Channel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ApplicantDao extends BaseMapper<Applicant> {

    @Update("update ehr_applicant set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

    @Select("SELECT * FROM ehr_applicant WHERE logicToDelete in (#{logicToDelete})")
    List<Applicant> findAll(@Param(value = "logicToDelete") Integer num);
}