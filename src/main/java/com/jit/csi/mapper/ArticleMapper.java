package com.jit.csi.mapper;

import com.jit.csi.pojo.Article;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:59
 */
public interface ArticleMapper {

    List<Article> findAllArticles();

    Article findArticleByTitle(String title);

    Integer updateArticleByTitle(Article article);

    Integer delteArticleByTitle(String title);

    Integer insertArticle(Article article);
}
