package com.jit.csi.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-28 - 10:44
 */
@SpringBootTest
class ZanMapperTest {
    @Autowired
    ZanMapper zanMapper;

    @Test
    void insertZan() {
        zanMapper.insertucZan(1,10008);
    }

    @Test
    @Transactional
    void deleteZanByUid() {
        zanMapper.deleteucZanByUid(10008);
    }

}