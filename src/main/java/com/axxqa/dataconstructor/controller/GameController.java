package com.axxqa.dataconstructor.controller;

import com.axxqa.dataconstructor.req.game.CreateReq;
import com.axxqa.dataconstructor.req.game.PublishReq;
import com.axxqa.dataconstructor.resp.CommonResp;
import com.axxqa.dataconstructor.resp.LoginResp;
import com.axxqa.dataconstructor.resp.game.CreateResp;
import com.axxqa.dataconstructor.resp.game.PublishResp;
import com.axxqa.dataconstructor.service.GameService;
import com.axxqa.dataconstructor.utils.DateTimeUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author tianhuiying on 2021/6/8.
 * @version 1.0
 */
@RestController
@RequestMapping("/game")
@CrossOrigin
public class GameController {
    @Resource
    private GameService gameService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResp create(@RequestBody CreateReq req) throws IOException {
        gameService.login();
        CommonResp<CreateResp> resp=new CommonResp<>();
        if(req.getTemplateId()==0 ){
            CreateResp data= gameService.create(req);
            resp.setData(data);
            resp.setMsg("成功");
            resp.setTimestamp(DateTimeUtil.getCurrentDateTimeyyyy_MM_dd_HHmmss());
            resp.setCode("1");
            return resp;
        }else{
            CreateResp data1= gameService.createByTemplate(req);
            resp.setData(data1);
            resp.setMsg("成功");
            resp.setTimestamp(DateTimeUtil.getCurrentDateTimeyyyy_MM_dd_HHmmss());
            resp.setCode("1");
            return resp;
        }

    }

    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    public CommonResp publish(@RequestBody PublishReq req) throws IOException {
        CommonResp<PublishResp> resp=new CommonResp<>();
        PublishResp data= gameService.publish(req);
        resp.setData(data);
        resp.setMsg("成功");
        resp.setTimestamp(DateTimeUtil.getCurrentDateTimeyyyy_MM_dd_HHmmss());
        resp.setCode("1");
        return resp;
    }
}
