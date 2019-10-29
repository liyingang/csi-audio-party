package com.jit.csi.controller;

import com.jit.csi.pojo.AudioConfig;
import com.jit.csi.pojo.User;
import com.jit.csi.service.AudioConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:50
 */
@RestController
public class AudioConfigController {
    @Autowired
    AudioConfigService audioConfigService;


    @GetMapping("audio")
    public AudioConfig findAudioConfigByUserID(HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        return audioConfigService.findAudioConfigByUserID(user.getUserID());
    }

    @PutMapping("audio")
    public Integer updateAudioConfig(AudioConfig audio){
        return audioConfigService.updateAudioCOnfigByUserID(audio);
    }


}
