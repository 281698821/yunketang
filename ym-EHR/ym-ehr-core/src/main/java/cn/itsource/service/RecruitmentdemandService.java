package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.dto.RecruitmentdemandDto;
import cn.itsource.model.Recruitmentdemand;
import cn.itsource.query.RecruitmentdemandQuery;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RecruitmentdemandService extends BaseService<Recruitmentdemand> {
    public void updateDeletes(@Param(value = "ids") String ids);

    PageInfo<RecruitmentdemandDto> queryListByParam(Integer pageNum, Integer pageSize, RecruitmentdemandQuery recruitmentdemandQuery);


    List<RecruitmentdemandDto> queryAll(Integer num);

}