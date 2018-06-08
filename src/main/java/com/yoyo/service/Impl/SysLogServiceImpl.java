package com.yoyo.service.Impl;
import java.util.List;
import com.yoyo.dao.SysLogDao;
import com.yoyo.entity.SysLog;
import com.yoyo.common.Assist;
import com.yoyo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysLogServiceImpl implements SysLogService{
    @Autowired
    private SysLogDao sysLogDao;
    
    public long getSysLogRowCount(Assist assist){
        return sysLogDao.getSysLogRowCount(assist);
    }
    
    public List<SysLog> selectSysLog(Assist assist){
        return sysLogDao.selectSysLog(assist);
    }
    
    public SysLog selectSysLogByObj(SysLog obj){
        return sysLogDao.selectSysLogByObj(obj);
    }
    
    public SysLog selectSysLogById(Long id){
        return sysLogDao.selectSysLogById(id);
    }
    
    public int insertSysLog(SysLog value){
        return sysLogDao.insertSysLog(value);
    }
    
    public int insertNonEmptySysLog(SysLog value){
        return sysLogDao.insertNonEmptySysLog(value);
    }
    
    public int deleteSysLogById(Long id){
        return sysLogDao.deleteSysLogById(id);
    }
    
    public int deleteSysLog(Assist assist){
        return sysLogDao.deleteSysLog(assist);
    }
    
    public int updateSysLogById(SysLog enti){
        return sysLogDao.updateSysLogById(enti);
    }
    
    public int updateSysLog(SysLog value, Assist assist){
        return sysLogDao.updateSysLog(value,assist);
    }
    
    public int updateNonEmptySysLogById(SysLog enti){
        return sysLogDao.updateNonEmptySysLogById(enti);
    }
    
    public int updateNonEmptySysLog(SysLog value, Assist assist){
        return sysLogDao.updateNonEmptySysLog(value,assist);
    }

    public SysLogDao getSysLogDao() {
        return this.sysLogDao;
    }

    public void setSysLogDao(SysLogDao sysLogDao) {
        this.sysLogDao = sysLogDao;
    }

}