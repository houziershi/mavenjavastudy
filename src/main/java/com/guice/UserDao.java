package com.guice;

import com.google.inject.Singleton;

/**
 * Created by guokun on 2019/1/14.
 * Description: guice原理
 * @param
 * @return
 */
@Singleton
public class UserDao {
    public void say(){
        System.out.println("Dao is saying");
    }
}
