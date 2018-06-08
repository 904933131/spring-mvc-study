package com.yoyo.service.Impl;
import java.util.List;
import com.yoyo.dao.SysDeptDao;
import com.yoyo.entity.SysDept;
import com.yoyo.common.Assist;
import com.yoyo.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysDeptServiceImpl implements SysDeptService{

    @Autowired
    private SysDeptDao sysDeptDao;
    
    public long getSysDeptRowCount(Assist assist){
        return sysDeptDao.getSysDeptRowCount(assist);
    }
    
    public List<SysDept> selectSysDept(Assist assist){
        return sysDeptDao.selectSysDept(assist);
    }
    
    public SysDept selectSysDeptByObj(SysDept obj){
        return sysDeptDao.selectSysDeptByObj(obj);
    }
    
    public SysDept selectSysDeptById(Long id){
        return sysDeptDao.selectSysDeptById(id);
    }
    
    public int insertSysDept(SysDept value){
        return sysDeptDao.insertSysDept(value);
    }
    
    public int insertNonEmptySysDept(SysDept value){
        return sysDeptDao.insertNonEmptySysDept(value);
    }
    
    public int deleteSysDeptById(Long id){
        return sysDeptDao.deleteSysDeptById(id);
    }
    
    public int deleteSysDept(Assist assist){
        return sysDeptDao.deleteSysDept(assist);
    }
    
    public int updateSysDeptById(SysDept enti){
        return sysDeptDao.updateSysDeptById(enti);
    }
    
    public int updateSysDept(SysDept value, Assist assist){
        return sysDeptDao.updateSysDept(value,assist);
    }
    
    public int updateNonEmptySysDeptById(SysDept enti){
        return sysDeptDao.updateNonEmptySysDeptById(enti);
    }
    
    public int updateNonEmptySysDept(SysDept value, Assist assist){
        return sysDeptDao.updateNonEmptySysDept(value,assist);
    }

    public SysDeptDao getSysDeptDao() {
        return this.sysDeptDao;
    }

    public void setSysDeptDao(SysDeptDao sysDeptDao) {
        this.sysDeptDao = sysDeptDao;
    }

}