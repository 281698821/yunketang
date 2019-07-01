package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.RecruitmentdemandDao;
import cn.itsource.dto.RecruitmentdemandDto;
import cn.itsource.model.Recruitmentdemand;
import cn.itsource.query.RecruitmentdemandQuery;
import cn.itsource.service.RecruitmentdemandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecruitmentdemandServiceImpl extends BaseServiceImpl<Recruitmentdemand> implements RecruitmentdemandService {
    @Autowired
    RecruitmentdemandDao recruitmentdemandDao;

    @Override
    public void updateDeletes(String ids) {
        recruitmentdemandDao.updateDeletes(ids);
    }

    public PageInfo<RecruitmentdemandDto> queryListByParam(Integer pageNum, Integer pageSize,RecruitmentdemandQuery recruitmentdemandQuery) {
        PageHelper.startPage(pageNum, pageSize);
        List<RecruitmentdemandDto> recruitmentdemandDtos = recruitmentdemandDao.queryListByParam(recruitmentdemandQuery);
        return new PageInfo<RecruitmentdemandDto>(recruitmentdemandDtos);
    }

    @Override
    public List<RecruitmentdemandDto> queryAll(Integer num) {
        return recruitmentdemandDao.queryAll(num);
    }
}