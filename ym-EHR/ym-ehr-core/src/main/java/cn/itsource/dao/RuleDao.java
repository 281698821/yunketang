package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Rule;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RuleDao extends BaseMapper<Rule> {
    @Update("update ehr_rule set logictoDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);
}