package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.dto.Compensationdto;
import cn.itsource.model.Articlewages;
import cn.itsource.model.RewardPunish;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticlewagesService extends BaseService<Articlewages> {
    public void updateDeletes(String ids);
    public List<Articlewages> findbyname();
    public List<RewardPunish> findRewar(Integer id);
    public Compensationdto findbycompen(Integer id);
    // 查询所有
    public PageInfo<Articlewages> queryAll(Integer pageNum, Integer pageSize);


}
