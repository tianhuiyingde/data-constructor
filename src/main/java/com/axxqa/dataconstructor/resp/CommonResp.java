package com.axxqa.dataconstructor.resp;

import lombok.Data;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
@Data
public class CommonResp<T>{
    /**
     * data : MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDRreBo+uELZ5FCFqhJfN5pPZvo98HNkuMA/BMaM74r2KHAjmMG2PE8r2wMtNV7MFuxzyIN7LA+AYsZBzcAGDZzvbntidzfiZsQXrqrsHYWC3OiFKqeWZNcfnMbqij5TTDJ/caCjn2BjnELUsabhHGfFQjJx63Dsh+ZsV7Y0BTwXwIDAQAB
     * timestamp : 2021-06-01 17:10:07
     * code : SUCCESS
     * msg : 成功
     * success : true
     */

    private T data;
    private String timestamp;
    private String code;
    private String msg;
    private boolean success=true;

}
