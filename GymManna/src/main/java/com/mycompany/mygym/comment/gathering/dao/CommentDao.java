package com.mycompany.mygym.comment.gathering.dao;

import java.util.List;

import com.mycompany.mygym.comment.gathering.vo.Comment;

public interface CommentDao {

	List<Comment> selectList(Comment comment);
	
	int insertComment(Comment comment);
	
	int updateComment(Comment comment);
	
	int deleteComment(Comment comment);
}
