package com.axxqa.dataconstructor.service;

import com.axxqa.dataconstructor.domain.Ebook;
import com.axxqa.dataconstructor.domain.EbookExample;
import com.axxqa.dataconstructor.mapper.EbookMapper;
import com.axxqa.dataconstructor.req.EbookReq;
import com.axxqa.dataconstructor.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianhuiying on 2021/6/7.
 * @version 1.0
 */
@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample=new EbookExample();
        EbookExample.Criteria criteria=ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList=ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList=new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp=new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);
            respList.add(ebookResp);
            
        }
        return respList;
    }
}
