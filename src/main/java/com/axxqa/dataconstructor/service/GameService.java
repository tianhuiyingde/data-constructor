package com.axxqa.dataconstructor.service;

import com.axxqa.dataconstructor.http.EditorHttpClient;
import com.axxqa.dataconstructor.http.UserHttpClient;
import com.axxqa.dataconstructor.req.game.CreateReq;
import com.axxqa.dataconstructor.req.game.PublishReq;
import com.axxqa.dataconstructor.resp.*;
import com.axxqa.dataconstructor.resp.game.CreateResp;
import com.axxqa.dataconstructor.resp.game.PublishResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import retrofit2.Response;

import java.io.IOException;

import static com.axxqa.dataconstructor.http.EditorHttpClient.*;
import static com.axxqa.dataconstructor.http.UserHttpClient.PUBLICKEY;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
@Service
@Configuration
public class GameService {
    @Value("${user.username}")
    private String username;
    @Value("${user.password}")
    private String password;
    EditorHttpClient editorHttpClient=new EditorHttpClient();

    private static final Logger LOG = LoggerFactory.getLogger(GameService.class);
    public CreateResp create(CreateReq req) throws IOException {

        Response<CommonResp<CreateGameResp>> createResp=editorHttpClient.createGame(req);
        CreateGameResp createGameResp=createResp.body().getData();
        CreateResp resp1=new CreateResp();
        if(createGameResp!=null){
            gameId=createGameResp.getId();
            gameName=createGameResp.getName();
            resp1.setGameId(gameId);
            resp1.setGameName(gameName);
            editorUri="/#/editor?parentId=0&id="+gameId+"&name="+gameName;
            resp1.setEditorUrl(editorHttpClient.baseUrl+editorUri);
        }
        LOG.info("***创建互动题项目成功！！！！***");
        return resp1;
    }


    public  void login() throws IOException {
        UserHttpClient userHttpClient=new UserHttpClient();
        Response<CommonResp> resp=userHttpClient.getPublicKey();
        if(resp.body().getData()!=null){
            PUBLICKEY=resp.body().getData().toString();
            LOG.info("PUBLICKEY:{}", PUBLICKEY);
        }
        Response<CommonResp<LoginResp>> loginResp=userHttpClient.login(username,password);
        LoginResp data=loginResp.body().getData();
        if(data!=null){
            userHttpClient.SESSIONID=data.getSessionId();
            userHttpClient.TOKEN=data.getToken();
        }
        LOG.info("***登录成功！！！！***");
    }

    public CreateResp createByTemplate(CreateReq req) throws IOException {

        Response<CommonResp<CreateGameResp>> createResp=editorHttpClient.createGameByTemplate(req);
        templateId=req.getTemplateId();
        CreateGameResp createGameResp=createResp.body().getData();
        CreateResp resp1=new CreateResp();
        if(createGameResp!=null){
            gameId=createGameResp.getId();
            gameName=createGameResp.getName();
            resp1.setGameId(gameId);
            resp1.setGameName(gameName);
            editorUri="/#/editor?parentId=0&id="+gameId+"&name="+gameName;
            resp1.setEditorUrl(editorHttpClient.baseUrl+editorUri);
        }
        LOG.info("***创建互动题项目成功！！！！***");
        return resp1;
    }
    public PublishResp publish(PublishReq req) throws IOException {
        Response<CommonResp<UpdateGameResp>> updateResp=editorHttpClient.updateGame(req);
        Response<CommonResp<AuditGameResp>> auditResp=editorHttpClient.auditGame(String.valueOf(gameId));
        if(templateId==0){
            AuditGameResp auditGameResp=auditResp.body().getData();
            LOG.info("***互动题提交审核成功！！！！***");
            Response<CommonResp> auditContentResp=editorHttpClient.auditContent();
            LOG.info("***互动题内容审核通过！！！！***");
            Response<CommonResp> auditDesignResp=editorHttpClient.auditDesign();
            LOG.info("***互动题设计审核通过！！！！***");
            LOG.info("***互动题发布成功！！！！***");

        }else {
            AuditGameResp auditGameResp=auditResp.body().getData();
            LOG.info("***互动题发布成功！！！！***");
        }
        gameUri="/games/"+gameId+"/";
        PublishResp resp=new PublishResp();
        resp.setGameId(gameId);
        resp.setGameName(gameName);
        resp.setGameUrl(editorHttpClient.baseUrl+gameUri);

        return resp;

    }



}
