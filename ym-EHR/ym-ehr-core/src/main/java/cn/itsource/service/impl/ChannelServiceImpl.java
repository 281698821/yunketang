package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.ChannelDao;
import cn.itsource.model.Channel;
import cn.itsource.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChannelServiceImpl extends BaseServiceImpl<Channel> implements ChannelService{

    @Autowired
    ChannelDao channelDao;

    @Override
    public void updateDeletes(String ids) {
        channelDao.updateDeletes(ids);
    }

    @Override
    public List<Channel> findAll(Integer num) {
        return channelDao.findAll(num);
    }
}