package com.yoyo.entity;
public class SysDept {
    private Long id;//主键id
    private String name;//组织名
    private String address;//地址
    private String code;//编号
    private String icon;//图标
    private Long pid;//父级主键
    private Integer seq;//排序
    private java.util.Date createTime;//创建时间
    public SysDept() {
        super();
    }
    public SysDept(Long id,String name,String address,String code,String icon,Long pid,Integer seq,java.util.Date createTime) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.code = code;
        this.icon = icon;
        this.pid = pid;
        this.seq = seq;
        this.createTime = createTime;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getPid() {
        return this.pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

}
