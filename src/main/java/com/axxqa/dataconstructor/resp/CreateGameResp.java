package com.axxqa.dataconstructor.resp;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
@Data
public class CreateGameResp {


        /**
         * id : 1243
         * name : 未命名文件
         * url : /1243
         * schoolSection : null
         * subject : null
         * createBy : 81
         */

        private int id;
        private String name;
        private String url;
        private String schoolSection;
        private String subject;
        private int createBy;

}
