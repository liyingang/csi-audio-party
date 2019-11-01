package com.jit.csi.audio;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import com.jit.csi.dictionary.PerDict;
import com.jit.csi.pojo.AudioConfig;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.json.JSONObject;

import java.io.File;
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
    //单例获取aipSpeech
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
    public static void setOptions(AudioConfig audioConfig){
        // 设置可选参数
        options.put("spd", audioConfig.getAuSetSpd());
        options.put("pit", audioConfig.getAuSetPit());
        options.put("per", audioConfig.getAuSetVoiPer());
        options.put("vol", audioConfig.getAuSetVol());
    }
    public static String synthesis(String text,String path,String name) {
        BaiduSpeech.getClient();
        TtsResponse res = client.synthesis(text, "zh", 1, options);
        JSONObject result = res.getResult();    //服务器返回的内容，合成成功时为null,失败时包含error_no等信息
        byte[] data = res.getData();            //生成的音频数据
        if (result != null) {
            return result.toString(2);
        }
        if (data != null) {
            try {
                File file=new File(path);
                if(!file.exists())file.mkdirs();
                file=new File(path+name);
                if(!file.exists())file.createNewFile();
                Util.writeBytesToFileSystem(data, path+name);
                return "OK";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "转换错误";
    }

//    public static void main(String[] args) {
//        String text="测试文本";
//        String path="D://test/";
//        String name="output.mp3";
//        AudioConfig audioConfig=new AudioConfig();
//        audioConfig.setAuSetVoiPer(PerDict.QINGGAN_DUXIAOYAO_VOICE);
//        audioConfig.setAuSetPit(5);
//        audioConfig.setAuSetSpd(5);
//        audioConfig.setAuSetVol(5);
//        BaiduSpeech.setOptions(audioConfig);
//        BaiduSpeech.synthesis(text,path,name);
//    }
}
