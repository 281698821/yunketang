package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Applicant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicantService extends BaseService<Applicant> {
    void updateDeletes(String ids);

    List<Applicant> findAll(@Param(value = "logicToDelete") Integer num);
}