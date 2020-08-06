package com.itheima.pojo;

/**
 * UserVO对象  Value Object  值对象
 * 存储常用的数据值
 */
public class UserVO {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "user=" + user +
                '}';
    }
}
