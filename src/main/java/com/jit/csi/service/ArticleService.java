package com.jit.csi.service;

import com.jit.csi.pojo.Article;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:45
 */
public interface ArticleService {
    List<Article> findAllArticles();

    List<Article> findArticleByTitle(String title);

    Integer updateArticleById(Article article);

    Integer delteArticleByTitle(String title);

    Integer insertArticle(Article article);

    Integer deleteByList(List list);

    Article findArticleById(Integer id);

    Article getComments(Article article);
}
