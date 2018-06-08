package com.yoyo.entity;
public class SysRole {
    private Long id;//主键id
    private String name;//角色名
    private Integer seq;//排序号
    private String description;//简介
    private Integer status;//状态
    
    private String[] resourceIds;
    public SysRole() {
        super();
    }
    public SysRole(Long id,String name,Integer seq,String description,Integer status) {
        super();
        this.id = id;
        this.name = name;
        this.seq = seq;
        this.description = description;
        this.status = status;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
	public String[] getResourceIds() {
		return resourceIds;
	}
	
	public void setResourceIds(String[] resourceIds) {
		this.resourceIds = resourceIds;
	}
    
}
