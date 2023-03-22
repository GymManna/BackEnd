package com.mycompany.mygym.comment.photo.dao;

import java.util.List;

import com.mycompany.mygym.comment.photo.vo.CommentPhoto;

public interface CommentPhotoDao {
	int createComment(CommentPhoto commentPhoto); // [Create]
	List<CommentPhoto> getComment(long articlePnum); // [Read]
	int updateComment(CommentPhoto commentPhoto); // [Update]
	int deleteComment(long commentPnum); // [Delete]
}
