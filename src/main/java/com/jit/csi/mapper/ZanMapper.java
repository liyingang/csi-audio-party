package com.jit.csi.mapper;

import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:22
 */
public interface ZanMapper {

    Integer insertZan(@Param("cid") Integer cid, @Param("uid") Integer uid);

    Integer deleteZanByUid(Integer uid);


}
