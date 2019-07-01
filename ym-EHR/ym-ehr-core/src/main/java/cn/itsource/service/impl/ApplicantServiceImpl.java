package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.ApplicantDao;
import cn.itsource.model.Applicant;
import cn.itsource.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApplicantServiceImpl extends BaseServiceImpl<Applicant> implements ApplicantService {

    @Autowired
    ApplicantDao applicantDao;

    @Override
    public void updateDeletes(String ids) {
        applicantDao.updateDeletes(ids);
    }

    @Override
    public List<Applicant> findAll(Integer num) {
        return applicantDao.findAll(num);
    }
}