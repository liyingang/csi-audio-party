package com.jit.csi.mapper;

import com.jit.csi.dictionary.PerDict;
import com.jit.csi.pojo.AudioConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-28 - 10:16
 */
@SpringBootTest
class AudioConfigMapperTest {
    @Autowired
    AudioConfigMapper audioConfigMapper;

    @Test
    void findAudioConfigByUserID() {
        System.out.println(audioConfigMapper.findAudioConfigByUserID(10008));
    }

    @Test
    void updateAudioConfigByUserID() {
        AudioConfig audioConfig=new AudioConfig();
        audioConfig.setUserID(10008);
        audioConfig.setAuSetPit(6);
        audioConfig.setAuSetVoiPer(PerDict.GENTL_VOICE);
        audioConfigMapper.updateAudioConfigByUserID(audioConfig);
    }
}