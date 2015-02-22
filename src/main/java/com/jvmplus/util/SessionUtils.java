package com.jvmplus.util;

import com.jvmplus.vo.User;

/**
 * Created by andy on 2/22/15.
 */
public class SessionUtils {
    public static User getCurrentUser(){
        User user = new User();
        user.setUserId("U000000001");
        user.setUserName("陆晨");
        return user;
    }
}
