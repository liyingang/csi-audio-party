package com.jit.csi.mapper;

import com.jit.csi.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-28 - 9:57
 */
@SpringBootTest
class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;

//    @Test
//    void findAllArticles() {
//        System.out.println(articleMapper.findAllArticles());
//
//    }
//
//    @Test
//    void findArticleByTitle() {
//        System.out.println(articleMapper.findArticleByTitle("test1"));
//    }

    @Test
    void updateArticleByTitle() {
        Article article=new Article();
        article.setArticleID(7);
        article.setPostTitle("test2");
        article.setPostText("dffbffefs");
        articleMapper.updateArticleById(article);
    }

    @Test
    @Transactional
    void delteArticleByTitle() {
        articleMapper.delteArticleByTitle("test2");
    }

//    @Test
//    //@Transactional
//    void insertArticle() {
//        Article article=new Article();
//        article.setUserID(10008);
//        article.setPostTitle("test1");
//        article.setPostText("asfasklfjasfajalsdas");
//        article.setPostAudio("httsadasdsa");
//        articleMapper.insertArticle(article);
//        articleMapper.findArticleByTitle(article.getPostTitle());
//    }
}