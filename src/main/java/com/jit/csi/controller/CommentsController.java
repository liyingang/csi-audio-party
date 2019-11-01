package com.jit.csi.controller;

import com.jit.csi.pojo.Article;
import com.jit.csi.pojo.Comments;
import com.jit.csi.pojo.User;
import com.jit.csi.service.ArticleService;
import com.jit.csi.service.CommentsService;
import com.jit.csi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:50
 */
@Controller
public class CommentsController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentsService commentsService;
    @Autowired
    UserService userService;

    @GetMapping("/comment.html")
    public String toComment(Integer postId, HttpServletRequest request){
        Article article=articleService.findArticleById(postId);
        article=articleService.getComments(article);
        request.setAttribute("article",article);
        return "comment";
    }

    @PostMapping("comment")
    @ResponseBody
    public Integer addComments(String text,Integer aid,Integer uid){
        Comments comments=new Comments();
        comments.setCmText(text);
        comments.setArticleID(aid);
        comments.setUserID(uid);
        return commentsService.insertComment(comments);
    }

    @DeleteMapping("comment")
    @ResponseBody
    public Integer deleteComment(@RequestParam("array[]") Integer[] array){
        List<Integer> list= Arrays.asList(array);
        return commentsService.deleteByList(list);
    }

}
