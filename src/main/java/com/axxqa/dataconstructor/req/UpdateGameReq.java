package com.axxqa.dataconstructor.req;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/9.
 * @version 1.0
 */
@Data
public class UpdateGameReq {
    /**
     * subject : 3
     * schoolSection : 1
     * name : 新互动题-Data_副本
     * id : 1515
     */

    private int subject;
    private int schoolSection;
    private String name;
    private String id;

}
