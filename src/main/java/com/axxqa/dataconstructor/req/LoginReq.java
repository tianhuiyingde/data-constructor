package com.axxqa.dataconstructor.req;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
@Data
public class LoginReq {
    /**
     * password : RFXC+HHZL4JkrIL/+k6ofejqxTIZoVrbWwPZQffcw6f/4eNJaK81niLcKeIq7giwPOUP9Ch5liMD/V/yyJTS2j4IzGJTMM9JEFaK5gAGb7yws2wmObCXebmLS1Z+R29sd8/Ssqo1ZpmU4/jnDywyh9XkRjG1PvzYcp/jku+b/k0=
     * type : oa
     * username : Hqk+iEoZExD5ffJA44GzaANFlHsvF/5N0KpIai4DMfKUDSdnfWgQ3nvK3x2NsmwfU2fs7kmMNFK5N6ZGiW9YdbCO4EEL9TNVc3NsMapUzBGoBkY+rwAV6rmothMT7mfIUI9Y8Jhnd2sj9f74JtU0UI0zNmriCyjD8SBg3HG/0WA=
     * rememberMe : false
     */

    private String password;
    private String type;
    private String username;
    private boolean rememberMe;


}
