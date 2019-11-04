package com.jit.csi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jit.csi.audio.SaveAudio;
import com.jit.csi.mapper.ArticleMapper;
import com.jit.csi.mapper.AudioConfigMapper;
import com.jit.csi.pojo.Article;
import com.jit.csi.pojo.AudioConfig;
import com.jit.csi.pojo.Comments;
import com.jit.csi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:43
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    AudioConfigMapper audioConfigMapper;

    @Override
    public PageInfo<Article> findAllArticles(Integer index,String userID) {
        PageHelper.startPage(index,7);
        List<Article> list=articleMapper.findAllArticles(userID);
        PageInfo<Article> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Article> findArticleByTitle(String title,Integer index,String userID) {
        PageHelper.startPage(index,7);
        List<Article> list=articleMapper.findArticleByTitle(title,userID);
        PageInfo<Article> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }



    @Override
    public Integer updateArticleById(Article article) {
        return articleMapper.updateArticleById(article);
    }

    @Override
    public Integer delteArticleByTitle(String title) {
        return articleMapper.delteArticleByTitle(title);
    }

    @Override
    @Transactional
    public Integer insertArticle(Article article) {
        try {
            AudioConfig audioConfig=audioConfigMapper.findAudioConfigByUserID(article.getUserID());
            int flag=articleMapper.insertArticle(article);
            if(flag==1){
                article.setArticleID(articleMapper.selectID());
                String path=this.getClass().getClassLoader().getResource("static").getPath()+"/audio/article/";
                String name=article.getArticleID()+"_"+article.getUserID()+".mp3";
                String state=SaveAudio.save(article.getPostText(),audioConfig,path,name);
                if(state.equals("OK")){
                    article.setPostAudio("audio/article/"+name);
                    return articleMapper.updateArticleById(article);
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
    public Integer deleteByList(List list) {
        return articleMapper.deleteByLogic(list);
    }

    @Override
    public Article findArticleById(Integer id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    public Article getComments(Article article) {
        List<Comments> hot=articleMapper.findhotComment(article.getArticleID());
        List<Comments> ne=articleMapper.findAllCommentByTime(article.getArticleID());
        article.setHotComments(hot);
        article.setNewComments(ne);
        return article;
    }


}
