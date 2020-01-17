package com.HZ.MyLife.entity;

/**
 * 角色类
 * Created by xsjdn on 2019/12/20.
 */
public class Role {
    private int roleId;
    private String roleName;

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
