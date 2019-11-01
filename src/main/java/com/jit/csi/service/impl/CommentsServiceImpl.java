package com.jit.csi.service.impl;

import com.jit.csi.audio.SaveAudio;
import com.jit.csi.mapper.AudioConfigMapper;
import com.jit.csi.mapper.CommentsMapper;
import com.jit.csi.pojo.AudioConfig;
import com.jit.csi.pojo.Comments;
import com.jit.csi.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:44
 */
@Service
public class CommentsServiceImpl  implements CommentsService {
    @Autowired
    CommentsMapper commentsMapper;
    @Autowired
    AudioConfigMapper audioConfigMapper;

    @Override
    public Integer insertComment(Comments comments) {
        try {
            AudioConfig audioConfig=audioConfigMapper.findAudioConfigByUserID(comments.getUserID());
            int flag=commentsMapper.insertComment(comments);
            if(flag==1){
                comments.setCommentID(commentsMapper.selectID());
                String path=this.getClass().getClassLoader().getResource("static").getPath()+"/audio/comment/";
                String name=comments.getCommentID()+"_"+comments.getArticleID()+"_"+comments.getUserID()+".mp3";
                String state= SaveAudio.save(comments.getCmText(),audioConfig,path,name);
                if(state.equals("OK")){
                    comments.setCmAudio("audio/comment/"+name);
                    return commentsMapper.updateCommentByID(comments);
                }else{
                    System.out.println(state);
                    return 0;
                }
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Comments> findAllCommentByTime() {
        return commentsMapper.findAllCommentByTime();
    }

    @Override
    public List<Comments> findPopularCommentByZan() {
        return commentsMapper.findPopularCommentByZan();
    }

    @Override
    public Integer deleteCommentByID(Integer id) {
        return commentsMapper.deleteCommentByID(id);
    }

    @Override
    public Integer updateCommentByID(Comments comments) {
        return commentsMapper.updateCommentByID(comments);
    }

    @Override
    public Integer deleteByList(List list) {
        return commentsMapper.deleteByLogic(list);
    }
}
