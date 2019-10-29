package com.jit.csi.service.impl;

import com.jit.csi.mapper.AudioConfigMapper;
import com.jit.csi.pojo.AudioConfig;
import com.jit.csi.service.AudioConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:44
 */
@Service
public class AudioConfigServiceImpl implements AudioConfigService {
    @Autowired
    AudioConfigMapper audioConfigMapper;


    @Override
    public AudioConfig findAudioConfigByUserID(Integer userID) {
        return audioConfigMapper.findAudioConfigByUserID(userID);
    }

    @Override
    public Integer updateAudioCOnfigByUserID(AudioConfig audioConfig) {
        return audioConfigMapper.updateAudioConfigByUserID(audioConfig);
    }
}
