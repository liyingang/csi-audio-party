package com.jit.csi.service;

import com.jit.csi.pojo.AudioConfig;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:45
 */
public interface AudioConfigService {
    AudioConfig findAudioConfigByUserID(Integer userID);

    Integer updateAudioCOnfigByUserID(AudioConfig audioConfig);
}
