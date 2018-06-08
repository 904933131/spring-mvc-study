package com.yoyo.service.Impl;
import java.util.List;
import com.yoyo.dao.SysUserDao;
import com.yoyo.entity.SysUser;
import com.yoyo.aspect.DataSourceAnnotation;
import com.yoyo.common.Assist;
import com.yoyo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserDao sysUserDao;
    
    @DataSourceAnnotation(value="read")
    public long getSysUserRowCount(Assist assist){
        return sysUserDao.getSysUserRowCount(assist);
    }
    
    @DataSourceAnnotation(value="read")
    public List<SysUser> selectSysUser(Assist assist){
        return sysUserDao.selectSysUser(assist);
    }
    
    public SysUser selectSysUserByObj(SysUser obj){
        return sysUserDao.selectSysUserByObj(obj);
    }
    @DataSourceAnnotation(value="write")
    public SysUser selectSysUserById(Long id){
        return sysUserDao.selectSysUserById(id);
    }
    
    public int insertSysUser(SysUser value){
        return sysUserDao.insertSysUser(value);
    }
    
    public int insertNonEmptySysUser(SysUser value){
        return sysUserDao.insertNonEmptySysUser(value);
    }
    
    public int deleteSysUserById(Long id){
        return sysUserDao.deleteSysUserById(id);
    }
    
    public int deleteSysUser(Assist assist){
        return sysUserDao.deleteSysUser(assist);
    }
    
    public int updateSysUserById(SysUser enti){
        return sysUserDao.updateSysUserById(enti);
    }
    
    public int updateSysUser(SysUser value, Assist assist){
        return sysUserDao.updateSysUser(value,assist);
    }
    
    public int updateNonEmptySysUserById(SysUser enti){
        return sysUserDao.updateNonEmptySysUserById(enti);
    }
    
    public int updateNonEmptySysUser(SysUser value, Assist assist){
        return sysUserDao.updateNonEmptySysUser(value,assist);
    }

    public SysUserDao getSysUserDao() {
        return this.sysUserDao;
    }

    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

	public SysUser existsUserName(String userName) {
		SysUser sysUser = new SysUser();
		sysUser.setLoginName(userName);
		return sysUserDao.selectSysUserByObj(sysUser);
	}

}