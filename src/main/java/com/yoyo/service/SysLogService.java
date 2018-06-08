package com.yoyo.service;
import java.util.List;
import com.yoyo.entity.SysLog;
import com.yoyo.common.Assist;
public interface SysLogService{
	/**
	 * 获得SysLog数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getSysLogRowCount(Assist assist);
	/**
	 * 获得SysLog数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<SysLog> selectSysLog(Assist assist);
	/**
	 * 获得一个SysLog对象,以参数SysLog对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    SysLog selectSysLogByObj(SysLog obj);
	/**
	 * 通过SysLog的id获得SysLog对象
	 * @param id
	 * @return
	 */
    SysLog selectSysLogById(Long id);
	/**
	 * 插入SysLog到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysLog(SysLog value);
	/**
	 * 插入SysLog中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptySysLog(SysLog value);
	/**
	 * 通过SysLog的id删除SysLog
	 * @param id
	 * @return
	 */
    int deleteSysLogById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除SysLog
	 * @param assist
	 * @return
	 */
    int deleteSysLog(Assist assist);
	/**
	 * 通过SysLog的id更新SysLog中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateSysLogById(SysLog enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysLog中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateSysLog(SysLog value,  Assist assist);
	/**
	 * 通过SysLog的id更新SysLog中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptySysLogById(SysLog enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysLog中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptySysLog(SysLog value, Assist assist);
}