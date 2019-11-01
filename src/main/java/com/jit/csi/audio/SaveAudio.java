package com.jit.csi.audio;

import com.jit.csi.pojo.AudioConfig;

import java.net.URLDecoder;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-29 - 18:35
 */
public class SaveAudio {
    public static String save(String text, AudioConfig audioConfig,String path,String name) throws Exception{
        text=ClearTag.clear(text);
        BaiduSpeech.getClient();
        BaiduSpeech.setOptions(audioConfig);
        path= URLDecoder.decode(path,"utf-8");
        return BaiduSpeech.synthesis(text,path,name);
    }
}
