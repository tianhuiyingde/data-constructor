package com.axxqa.dataconstructor.req;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/9.
 * @version 1.0
 */
@Data
public class CreateGameReq {
    /**
     * name : 未命名文件
     * parentId : 0
     * id : 0
     * isTemplate : 0
     */

    private String name;
    private int parentId;
    private int id;
    private int isTemplate;
    private int templateId;



}
