package com.axxqa.dataconstructor.req;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/9.
 * @version 1.0
 */
@Data
public class AuditContentReq {


    /**
     * description :
     * id : 1542
     * auditStatus : 1
     * path : thy测试233
     * auditResult : 1
     */

    private String description;
    private String id;
    private String auditStatus;
    private String path;
    private int auditResult;


}
