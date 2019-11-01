package com.jit.csi.service;

import com.jit.csi.pojo.Comments;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:46
 */
public interface CommentsService {
    Integer insertComment(Comments comments);

    List<Comments> findAllCommentByTime();

    List<Comments> findPopularCommentByZan();

    Integer deleteCommentByID(Integer id);

    Integer updateCommentByID(Comments comments);

    Integer deleteByList(List list);
}
