package com.mycompany.mygym.comment.photo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mycompany.mygym.comment.photo.dao.CommentPhotoDao;
import com.mycompany.mygym.comment.photo.vo.CommentPhoto;

@Service
public class CommentPhotoServiceImpl implements CommentPhotoService {
	Logger log = LogManager.getLogger("case3");

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private CommentPhotoDao dao;

	// [Create]
	@Override
	public int createComment(CommentPhoto commentPhoto) {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		int result = 0;

		try {
			result = dao.createComment(commentPhoto);

			if (result == 1) {
				transactionManager.commit(status);
			} else {
				transactionManager.rollback(status);
			}
		} catch (Exception e) {
			transactionManager.rollback(status);
		}

		return result;
	}

	// [Read]
	@Override
	public List<CommentPhoto> getComment(long articlePnum) {
		return dao.getComment(articlePnum);
	}

	// [Update]
	@Override
	public int updateComment(CommentPhoto commentPhoto) {
		return dao.updateComment(commentPhoto);
	}

	// [Delete]
	@Override
	public int deleteComment(long commentPnum) {
		return dao.deleteComment(commentPnum);
	}
}
