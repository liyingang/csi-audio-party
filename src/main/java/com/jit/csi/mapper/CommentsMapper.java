package com.jit.csi.mapper;

import com.jit.csi.pojo.Comments;

import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:59
 */
public interface CommentsMapper {

    Integer insertComment(Comments comments);

    List<Comments> findAllCommentByTime();

    List<Comments> findPopularCommentByZan();

    Integer deleteCommentByID(Integer id);

    Integer updateCommentByID(Comments comments);

    Integer selectID();

    Integer deleteByLogic(List list);

}
