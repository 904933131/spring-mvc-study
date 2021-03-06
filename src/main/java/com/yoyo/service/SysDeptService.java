package com.yoyo.service;
import java.util.List;
import com.yoyo.entity.SysDept;
import com.yoyo.common.Assist;
public interface SysDeptService{
	/**
	 * 获得SysDept数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getSysDeptRowCount(Assist assist);
	/**
	 * 获得SysDept数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<SysDept> selectSysDept(Assist assist);
	/**
	 * 获得一个SysDept对象,以参数SysDept对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    SysDept selectSysDeptByObj(SysDept obj);
	/**
	 * 通过SysDept的id获得SysDept对象
	 * @param id
	 * @return
	 */
    SysDept selectSysDeptById(Long id);
	/**
	 * 插入SysDept到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertSysDept(SysDept value);
	/**
	 * 插入SysDept中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptySysDept(SysDept value);
	/**
	 * 通过SysDept的id删除SysDept
	 * @param id
	 * @return
	 */
    int deleteSysDeptById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除SysDept
	 * @param assist
	 * @return
	 */
    int deleteSysDept(Assist assist);
	/**
	 * 通过SysDept的id更新SysDept中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateSysDeptById(SysDept enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysDept中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateSysDept(SysDept value,  Assist assist);
	/**
	 * 通过SysDept的id更新SysDept中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptySysDeptById(SysDept enti);
 	/**
	 * 通过辅助工具Assist的条件更新SysDept中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptySysDept(SysDept value, Assist assist);
}