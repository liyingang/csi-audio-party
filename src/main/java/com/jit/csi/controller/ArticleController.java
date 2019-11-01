package com.jit.csi.controller;

import com.jit.csi.pojo.Article;
import com.jit.csi.pojo.User;
import com.jit.csi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:50
 */
@RestController
@RequestMapping("/article/")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/title/{id}")
    public List<Article> findArticle(@PathVariable("id") String title, HttpSession session){
        if("all".equals(title)){
            return articleService.findAllArticles();
        }else{
            return articleService.findArticleByTitle(title);
        }
    }
    @PostMapping("/article")
    public Integer updateArticle(String title, String text,HttpSession session){
        User user= (User) session.getAttribute("user");
        Article article=new Article();
        article.setPostTitle(title);
        article.setPostText(text);
        article.setUserID(user.getUserID());
        return articleService.insertArticle(article);
    }
    @DeleteMapping("/article")
    public Integer deleteArticle(@RequestParam("array[]") Integer[] array){
        List<Integer> list=Arrays.asList(array);
        return articleService.deleteByList(list);
    }
    @GetMapping("/article")
    public Article getArticle(Integer id){
        return articleService.findArticleById(id);
    }
    @PutMapping("/article")
    public Integer updateArticle(Integer aid){
        Article article=articleService.findArticleById(aid);
        article.setZan(article.getZan()+1);
        return articleService.updateArticleById(article);
    }

    @PutMapping("addView")
    public void addView(Integer id){
        Article article=articleService.findArticleById(id);
        article.setPostPageviews(article.getPostPageviews()+1);
        articleService.updateArticleById(article);
    }



}
