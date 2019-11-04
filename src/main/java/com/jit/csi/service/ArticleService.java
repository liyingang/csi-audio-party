package com.jit.csi.service;

import com.github.pagehelper.PageInfo;
import com.jit.csi.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:45
 */
public interface ArticleService {
    PageInfo<Article> findAllArticles(Integer index,String userID);

    PageInfo<Article> findArticleByTitle(String title,Integer index,String userID);

    Integer updateArticleById(Article article);

    Integer delteArticleByTitle(String title);

    Integer insertArticle(Article article);

    Integer deleteByList(List list);

    Article findArticleById(Integer id);

    Article getComments(Article article);
}
