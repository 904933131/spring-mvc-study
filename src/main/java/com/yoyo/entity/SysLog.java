package com.yoyo.entity;
public class SysLog {
    private Long id;//主键id
    private String loginName;//登陆名
    private String roleName;//角色名
    private String optContent;//内容
    private String clientIp;//客户端ip
    private java.util.Date createTime;//创建时间
    public SysLog() {
        super();
    }
    public SysLog(Long id,String loginName,String roleName,String optContent,String clientIp,java.util.Date createTime) {
        super();
        this.id = id;
        this.loginName = loginName;
        this.roleName = roleName;
        this.optContent = optContent;
        this.clientIp = clientIp;
        this.createTime = createTime;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOptContent() {
        return this.optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

}
