package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.dto.RecruitmentdemandDto;
import cn.itsource.model.Recruitmentdemand;
import cn.itsource.query.RecruitmentdemandQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface RecruitmentdemandDao extends BaseMapper<Recruitmentdemand> {
    @Update("update ehr_recruitmentdemand set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

    List<RecruitmentdemandDto> queryListByParam(RecruitmentdemandQuery recruitmentdemandQuery);



    List<RecruitmentdemandDto> queryAll(Integer num);

}