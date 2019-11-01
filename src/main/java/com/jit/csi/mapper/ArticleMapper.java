package com.jit.csi.mapper;

import com.jit.csi.pojo.Article;
import com.jit.csi.pojo.Comments;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:59
 */
public interface ArticleMapper {

    List<Article> findAllArticles();

    List<Article> findArticleByTitle(String title);

    Integer updateArticleById(Article article);

    Integer delteArticleByTitle(String title);

    Integer insertArticle(Article article);

    Integer selectID();

    Integer deleteByLogic(List list);

    Article findArticleById(Integer id);

    List<Comments> findhotComment(Integer articleID);
    List<Comments> findAllCommentByTime(Integer articleID);
}
