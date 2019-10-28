package com.jit.csi.mapper;

import com.jit.csi.pojo.Zan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sun.util.resources.cldr.zu.CalendarData_zu_ZA;

import java.awt.color.CMMException;

import static org.junit.jupiter.api.Assertions.*;

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
        zanMapper.insertZan(1,10008);
    }

    @Test
    @Transactional
    void deleteZanByUid() {
        zanMapper.deleteZanByUid(10008);
    }

}