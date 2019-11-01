package com.jit.csi.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:46
 */
public interface ZanService {
    Integer insertucZan(@Param("cid") Integer cid, @Param("uid") Integer uid);

    Integer deleteucZanByUid(Integer uid);


    Integer insertuaZan(@Param("aid") Integer aid, @Param("uid") Integer uid);

    Integer deleteuaZanByUid(Integer uid);
}
