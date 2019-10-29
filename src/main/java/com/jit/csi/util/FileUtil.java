package com.jit.csi.util;

import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-29 - 16:46
 */
public class FileUtil {

    public static Integer uploadPhoto(String file,String name){
        try {
            //name=name.replace("%20"," ");
            name= URLDecoder.decode(name,"utf-8");//处理中文空格问题
            byte[] bytes=new BASE64Decoder().decodeBuffer(file);
            File imgPath=new File(name);
            if(!imgPath.exists()){
                imgPath.createNewFile();
            }
            OutputStream outputStream=new FileOutputStream(imgPath);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
            return 1;
        }catch (Exception e){
            System.out.println("IO异常");
            return 0;
        }
    }


}
