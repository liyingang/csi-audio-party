package com.jit.csi.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:22
 */
public interface ZanMapper {

    Integer insertZan(@Param("cid") String cid, @Param("uid") String uid);

    Integer deleteZanByUid(String uid);

    Integer deleteZanByCid(String cid);

}
