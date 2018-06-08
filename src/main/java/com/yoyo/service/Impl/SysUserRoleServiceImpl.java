package com.yoyo.service.Impl;
import java.util.List;

import com.yoyo.common.Assist;
import com.yoyo.dao.SysUserRoleDao;
import com.yoyo.entity.SysUserRole;
import com.yoyo.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    public long getSysUserRoleRowCount(Assist assist){
        return sysUserRoleDao.getSysUserRoleRowCount(assist);
    }
    
    public List<SysUserRole> selectSysUserRole(Assist assist){
        return sysUserRoleDao.selectSysUserRole(assist);
    }
    
    public SysUserRole selectSysUserRoleByObj(SysUserRole obj){
        return sysUserRoleDao.selectSysUserRoleByObj(obj);
    }
    
    public SysUserRole selectSysUserRoleById(String id){
        return sysUserRoleDao.selectSysUserRoleById(id);
    }
    
    public int insertSysUserRole(SysUserRole value){
        return sysUserRoleDao.insertSysUserRole(value);
    }
    
    public int insertNonEmptySysUserRole(SysUserRole value){
        return sysUserRoleDao.insertNonEmptySysUserRole(value);
    }
    
    public int deleteSysUserRoleById(String id){
        return sysUserRoleDao.deleteSysUserRoleById(id);
    }
    
    public int deleteSysUserRole(Assist assist){
        return sysUserRoleDao.deleteSysUserRole(assist);
    }
    
    public int updateSysUserRoleById(SysUserRole enti){
        return sysUserRoleDao.updateSysUserRoleById(enti);
    }
    
    public int updateSysUserRole(SysUserRole value, Assist assist){
        return sysUserRoleDao.updateSysUserRole(value,assist);
    }
    
    public int updateNonEmptySysUserRoleById(SysUserRole enti){
        return sysUserRoleDao.updateNonEmptySysUserRoleById(enti);
    }
    
    public int updateNonEmptySysUserRole(SysUserRole value, Assist assist){
        return sysUserRoleDao.updateNonEmptySysUserRole(value,assist);
    }

    public SysUserRoleDao getSysUserRoleDao() {
        return this.sysUserRoleDao;
    }

    public void setSysUserRoleDao(SysUserRoleDao sysUserRoleDao) {
        this.sysUserRoleDao = sysUserRoleDao;
    }


}