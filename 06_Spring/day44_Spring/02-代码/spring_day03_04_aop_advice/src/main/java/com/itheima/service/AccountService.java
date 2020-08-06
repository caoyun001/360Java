package com.itheima.service;

public interface AccountService {
    /**
     * 模拟保存操作
     */
    void save();

    /**
     * 模拟更新操作
     * @param i
     */
    void update(int i);

    /**
     * 模拟删除操作
     * @return
     */
    int delete();
}
