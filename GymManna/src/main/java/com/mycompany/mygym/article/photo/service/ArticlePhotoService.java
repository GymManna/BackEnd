package com.mycompany.mygym.article.photo.service;

import java.util.List;


import com.mycompany.mygym.article.photo.vo.ArticlePhoto;
import com.mycompany.mygym.comment.photo.vo.CommentPhoto;

public interface ArticlePhotoService {
	int createPost(ArticlePhoto articlePhoto, String imageUrl); // [Create]
	List<ArticlePhoto> getArticle(); // [Read]
	List<ArticlePhoto> getPostById(long articlePnum); // [Read] 상세
	int deletePost(long articlePnum); // [Delete]
}
