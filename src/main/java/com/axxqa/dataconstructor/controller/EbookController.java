package com.axxqa.dataconstructor.controller;

import com.axxqa.dataconstructor.req.EbookReq;
import com.axxqa.dataconstructor.resp.CommonResp;
import com.axxqa.dataconstructor.resp.EbookResp;
import com.axxqa.dataconstructor.service.EbookService;
import com.axxqa.dataconstructor.utils.DateTimeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianhuiying on 2021/6/7.
 * @version 1.0
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq req){
        CommonResp<List<EbookResp>> resp=new CommonResp<>();
        List<EbookResp> list=ebookService.list(req);
        resp.setData(list);
        resp.setMsg("成功");
        resp.setTimestamp(DateTimeUtil.getCurrentDateTimeyyyy_MM_dd_HHmmss());
        resp.setCode("1");
        return resp;
    }

}
