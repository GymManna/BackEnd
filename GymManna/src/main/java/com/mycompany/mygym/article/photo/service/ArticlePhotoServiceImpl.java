package com.mycompany.mygym.article.photo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mycompany.mygym.article.photo.dao.ArticlePhotoDao;
import com.mycompany.mygym.article.photo.vo.ArticleImage;
import com.mycompany.mygym.article.photo.vo.ArticlePhoto;

@Service
public class ArticlePhotoServiceImpl implements ArticlePhotoService {
	Logger log = LogManager.getLogger("case3");

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private ArticlePhotoDao dao;

	// [Create]
	@Override
	public int createPost(ArticlePhoto articlePhoto, String imageUrl) {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

		int result = 0;
		int resultCreatePost = 0;
		long articleNum = 0;
		ArticleImage articleImage = new ArticleImage();

		try {
			resultCreatePost = dao.createPost(articlePhoto);

			if (resultCreatePost != 0) {
				articleNum = dao.getNowCreatedArticle();
				articleImage.setArticlePnum(articleNum);
				articleImage.setArticleImgurl(imageUrl);

				dao.createImage(articleImage);
				transactionManager.commit(status);

				result = 1;
			} else {
				transactionManager.commit(status);
			}
		} catch (Exception e) {
			transactionManager.rollback(status);
		}

		return result;
	}

	// [Read]
	@Override
	public List<ArticlePhoto> getArticle() {
		return dao.getArticle();
	}

	// [Read] 상세
	@Override
	public List<ArticlePhoto> getPostById(long articlePnum) {
		return dao.getPostById(articlePnum);
	}

	// [Delete]
	@Override
	public int deletePost(long articlePnum) {
		return dao.deletePost(articlePnum);
	}
}
