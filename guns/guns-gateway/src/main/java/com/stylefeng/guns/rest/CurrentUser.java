package com.stylefeng.guns.rest;

/**
 * ClassName: CurrentUser
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/23  17:02
 */
public class CurrentUser {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static String getCurrentUser() {
        return THREAD_LOCAL.get();
    }

    public static void setCurrentUser(String username) {
        THREAD_LOCAL.set(username);
    }

}
