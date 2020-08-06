package com.itheima.pojo;

import java.util.List;

/**
 *  角色和用户关系,是多对多关系
 *  一个用户包含多个角色
 *  一个角色包含多个用户
 */
public class Role {
    private int rid;
    private String rname;
    private String rdesc;

    private List<User> userList;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                ", userList=" + userList +
                '}';
    }
}
