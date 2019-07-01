package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Socialsecurity;
import org.springframework.stereotype.Service;


public interface SocialsecurityService extends BaseService<Socialsecurity> {
    public void updateDeletes(String ids);
}
