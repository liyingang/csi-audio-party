package com.jit.csi.mapper;

import com.jit.csi.pojo.Comments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-28 - 10:33
 */
@SpringBootTest
class CommentsMapperTest {
    @Autowired
    CommentsMapper commentsMapper;

    @Test
    void insertComment() {
        Comments comments=new Comments();
        comments.setArticleID(7);
        comments.setCmAudio("asdsadas");
        comments.setCmText("test1sdasdfaadsa");
        commentsMapper.insertComment(comments);
    }

    @Test
    void findAllCommentByTime() {
        System.out.println(commentsMapper.findAllCommentByTime());
    }

    @Test
    void findPopularCommentByZan() {
        System.out.println(commentsMapper.findPopularCommentByZan());
    }

    @Test
    @Transactional
    void deleteCommentByID() {
        commentsMapper.deleteCommentByID(1);
    }

    @Test
    void updateCommentByID() {
        Comments comments=new Comments();
        comments.setCommentID(1);
        comments.setCmAudio("asdsadas");
        comments.setCmText("test1sdasdfaadsa");
        commentsMapper.updateCommentByID(comments);
    }
}