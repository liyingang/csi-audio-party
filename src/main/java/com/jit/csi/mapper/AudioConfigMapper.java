package com.jit.csi.mapper;

import com.jit.csi.pojo.AudioConfig;
import com.jit.csi.pojo.User;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:58
 */
public interface AudioConfigMapper {

    AudioConfig findAudioConfigByUserID(Integer uid);

    Integer updateAudioConfigByUserID(AudioConfig audioConfig);



}
