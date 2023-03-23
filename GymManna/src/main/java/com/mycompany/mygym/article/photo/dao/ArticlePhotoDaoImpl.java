package com.mycompany.mygym.article.photo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mygym.article.photo.vo.ArticleImage;
import com.mycompany.mygym.article.photo.vo.ArticlePhoto;

@Repository
public class ArticlePhotoDaoImpl implements ArticlePhotoDao{
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;
	
	@Override // [Create] 게시글
	public int createPost(ArticlePhoto articlePhoto) {
		return session.insert("com.mycompany.mygym.article.photo.createPost", articlePhoto);
	}

	@Override // [Read]
	public List<ArticlePhoto> getArticle() {
		return session.selectList("com.mycompany.mygym.article.photo.selectArticle");
	}

	@Override // [Read] 최근 생성 게시글 PK 가져오기
	public long getNowCreatedArticle() {
		return session.selectOne("com.mycompany.mygym.article.photo.selectNowCreatedArticle");
	}

	@Override // [Create]
	public int createImage(ArticleImage articleImage) {
		return session.insert("com.mycompany.mygym.article.photo.createImage", articleImage);
		
	}

	@Override // [Read] 상세
	public List<ArticlePhoto> getPostById(long articlePnum) {
		return session.selectList("com.mycompany.mygym.article.photo.selectArticleById", articlePnum);
	}

	@Override // [Delete]
	public int deletePost(long articlePnum) {
		return session.delete("com.mycompany.mygym.article.photo.deleteArticle", articlePnum);
	}
}
