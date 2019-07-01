package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.PositionDao;
import cn.itsource.model.Position;
import cn.itsource.service.PositionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {
    @Autowired

    private PositionDao positionDao;

    @Override
    public void updateDeletes(String ids) {
        positionDao.updateDeletes(ids);
    }

    @Override
    public PageInfo<Position> queryPageListByParams(Integer page, Integer limit, Position position) {
        PageHelper.startPage(page, limit);
        List<Position> positions = positionDao.queryPageListByParams(position);
        // 用PageInfo对结果进行包装
        return new PageInfo<Position>(positions);
    }


    @Override
    public Position queryPositionById(Long id) {
        return positionDao.queryPositionById(id);
    }

    @Override
    public List<Position> queryAllListWithDept() {
        return positionDao.queryAllListWithDept();
    }

    @Override
    public void insertWithDept(Position position) {
        positionDao.insertWithDept(position);
    }

    @Override
    public void updateWithDept(Position position) {
        positionDao.updateWithDept(position);
    }
}
