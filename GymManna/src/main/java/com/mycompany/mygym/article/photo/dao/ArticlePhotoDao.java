package com.mycompany.mygym.article.photo.dao;

import java.util.List;

import com.mycompany.mygym.article.photo.vo.ArticleImage;
import com.mycompany.mygym.article.photo.vo.ArticlePhoto;

public interface ArticlePhotoDao {
	int createPost(ArticlePhoto articlePhoto); // [Create]
	List<ArticlePhoto> getArticle(); // [Read] 
	long getNowCreatedArticle(); // [Read] 최근 입력 게시글 번호
	int createImage(ArticleImage articleImage); // [Create] 이미지 
	List<ArticlePhoto> getPostById(long articlePnum); // [Read] 상세
	int deletePost(long articlePnum); // [Delete]
}
