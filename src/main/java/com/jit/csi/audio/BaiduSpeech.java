package com.jit.csi.audio;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 10:35
 */
public class BaiduSpeech {
    //设置APPID/AK/SK
    private static final String APP_ID = "17589107";
    private static final String API_KEY = "iX4wf8C3stX6f1w0LbGlj2TT";
    private static final String SECRET_KEY = "4p34wVShEbuZ4HGlrdnBLHDMmNQyIyug";
    private volatile static AipSpeech client;
    private static HashMap<String, Object> options = new HashMap<>();
    private BaiduSpeech(){}

    public static AipSpeech getClient(){
        if (client == null) {
            synchronized (AipSpeech.class) {
                if (client == null) {
                    client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return client;
    }
    public static void setOptions(Integer spd, Integer pit, Integer per){
        // 设置可选参数
        options.put("spd", spd);
        options.put("pit", pit);
        options.put("per", per);
    }
    public static String synthesis(String text,  String dir,String id) {
        TtsResponse res = client.synthesis(text, "zh", 1, options);
        JSONObject result = res.getResult();    //服务器返回的内容，合成成功时为null,失败时包含error_no等信息
        byte[] data = res.getData();            //生成的音频数据
        if (result != null) {
            return result.toString(2);
        }
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, dir+"/"+id+"output.mp3");
                return "OK";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "转换错误";
    }


}
