package com.mycompany.mygym.comment.photo.service;

import java.util.List;

import com.mycompany.mygym.comment.photo.vo.CommentPhoto;

public interface CommentPhotoService {
	int createComment(CommentPhoto commentPhoto); // [Create]
	List<CommentPhoto> getComment(long articlePnum); // [Read]
	int updateComment(CommentPhoto commentPhoto); // [Update]
	int deleteComment(long commentPnum); // [Delete]
}
