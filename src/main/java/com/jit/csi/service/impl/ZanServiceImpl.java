package com.jit.csi.service.impl;

import com.jit.csi.mapper.ZanMapper;
import com.jit.csi.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:45
 */
@Service
public class ZanServiceImpl implements ZanService {
    @Autowired
    ZanMapper zanMapper;


    @Override
    public Integer insertucZan(Integer cid, Integer uid) {
        return zanMapper.insertucZan(cid,uid);
    }

    @Override
    public Integer deleteucZanByUid(Integer uid) {
        return deleteucZanByUid(uid);
    }

    @Override
    public Integer insertuaZan(Integer aid, Integer uid) {
        return insertuaZan(aid,uid);
    }

    @Override
    public Integer deleteuaZanByUid(Integer uid) {
        return deleteuaZanByUid(uid);
    }
}
