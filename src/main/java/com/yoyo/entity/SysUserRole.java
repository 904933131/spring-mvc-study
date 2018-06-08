package com.yoyo.entity;
public class SysUserRole {
    private String id;//主键id
    private String userId;//用户id
    private String roleId;//角色id
    
    private String userName;//用户id
    private String roleName;//角色id
    
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public SysUserRole() {
        super();
    }
    public SysUserRole(String id,String userId,String roleId) {
        super();
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
