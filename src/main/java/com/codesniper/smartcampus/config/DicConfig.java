package com.codesniper.smartcampus.config;


import java.util.HashMap;
import java.util.Map;

/**
 * 字典表配置
 *
 * @author CodeSniper
 * @since 2022-01-29
 */
public class DicConfig {

    /**
     * 政治面貌
     */
    public static final Map<String,String> POLITICAL_STATUS_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","中共党员");
            put("2","中共预备党员");
            put("3","共青团员");
            put("4","群众");
        }
    };

    public static final Map<String,String> JOB_LEVEL_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","班长");
            put("2","学习委员");
            put("3","体育委员");
            put("4","生活委员");
            put("5","文艺委员");
            put("6","寝室长");
            put("7","无");
        }
    };

    /**
     * 性别
     */
    public static final Map<String,String> GENDER_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","男");
            put("0","女");
        }
    };

    /**
     * 是,否
     */
    public static final Map<String,String> YES_AND_NO_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","是");
            put("0","否");
        }
    };

    /**
     * 健康码颜色
     */
    public static final Map<String,String> HEALTH_CODE_COLOR_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","绿色");
            put("2","黄色");
            put("3","红色");
        }
    };

    public static final Map<String,String> APPROVAL_RESULT_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","批准");
            put("0","驳回");
        }
    };

    public static final Map<String,String> RISK_LEVEL_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","批准");
            put("0","驳回");
        }
    };

    public static final Map<String,String> TRAFFIC_TYPE_MAP = new HashMap<String,String>(){
        private static final long serialVersionUID = 1L;
        {
            put("1","飞机");
            put("2","高铁");
            put("3","汽车");
            put("4","步行");
        }
    };
}
