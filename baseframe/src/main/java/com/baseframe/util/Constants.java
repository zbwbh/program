package com.baseframe.util;

/**
 * 全局常量
 * 
 *
 * @author koala
 * @since 2017年7月27日
 */
public class Constants {

    /**
     * 防止错误设置catch连接
     * connectCatch不可以有set方法
     */
    private static boolean connectCatch = true;
    
    public static final String REDIS_SERVER_KEY = "redis_server_key";
    
    public static final String REDIS_SCRIPT = "redis_script";
    
    /**
     * 在redis中的地址信息
     */
    public static final String REGIONS = "redis_regions";
    
    /**
     * 该项目中的用户信息
     */
    public static final String FRAME_SESSION_MEMBER ="frame_session_member";
    
    /**
     * token
     */
    public static final String WEHCAT_COOKIE_TOKEN = "COOKIE_TOKEN";
    
    /**
     * 间隔符 
     */
    public static final String splitStr = "#frame_server";
    
    /**
     * if you are patient, you will know the relationships between the components.
     */
    public static final String BRAND_GROUP_BY_ABC="brand_first_letter_group";
    
    public static boolean isConnectCatch(){
        return connectCatch;
    }
}
