package com.mycompany.mygym.comment.gathering.service;

import java.util.List;

import com.mycompany.mygym.comment.gathering.vo.Comment;

public interface CommentService {

	List<Comment> selectList(Comment comment);
	
	boolean insertComment(Comment comment); 
	
	boolean updateComment(Comment comment); 
	
	boolean deleteComment(Comment comment); 
}
