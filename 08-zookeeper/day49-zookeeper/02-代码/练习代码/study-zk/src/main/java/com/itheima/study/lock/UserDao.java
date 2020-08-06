package com.itheima.study.lock;

/**
 * @author ：zhang
 * @date ：Created in 2019/11/23
 * @description ： 用户dao层
 * @version: 1.0
 */
public class UserDao {
    private int socre = 0;

    /**
     * 模拟读取数据库里用户积分
     *
     * @return
     */
    public int getSocreFromDb() {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return socre;
    }

    public void updateScore(int score) {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.socre = score;
    }
}
