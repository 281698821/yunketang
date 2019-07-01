package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Compensation;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface CompensationService extends BaseService<Compensation> {
    void updateDeletes(String ids);
    PageInfo<Compensation> queryListByPage(Integer pageNum, Integer pageSize, String name);
    List<Compensation> findAllList();
    Compensation findById(Integer id);
}
