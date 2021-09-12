package com.axxqa.dataconstructor.resp;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
@Data
public class AuditGameResp {

        private int id;
        private String auditResult;
        private String description;
        private int auditId;
        private String auditName;

}
