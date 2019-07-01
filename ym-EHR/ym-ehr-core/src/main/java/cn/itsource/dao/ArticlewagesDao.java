package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.dto.Compensationdto;
import cn.itsource.model.Articlewages;
import cn.itsource.model.Paygrades;
import cn.itsource.model.RewardPunish;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticlewagesDao extends BaseMapper<Articlewages> {

    public void updateDeletes(@Param(value = "ids") String ids);
    public List<Articlewages> findbyname();
    public List<RewardPunish> findRewar(Integer id);
    public Compensationdto findbycompen(Integer id);


}