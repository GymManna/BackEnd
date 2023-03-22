package com.mycompany.mygym.comment.photo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mygym.comment.photo.vo.CommentPhoto;
import com.mysql.cj.log.Log;

@Repository
public class CommentPhotoDaoImpl implements CommentPhotoDao {
	Logger log = LogManager.getLogger("case3");

	@Autowired
	private SqlSession session;

	// [Create]
	@Override
	public int createComment(CommentPhoto commentPhoto) {
		return session.insert("com.mycompany.mygym.comment.photo.createComment", commentPhoto);
	}

	// [Read]
	@Override
	public List<CommentPhoto> getComment(long articlePnum) {
		return session.selectList("com.mycompany.mygym.comment.photo.getComment", articlePnum);
	}

	// [Update]
	@Override
	public int updateComment(CommentPhoto commentPhoto) {
		return session.update("com.mycompany.mygym.comment.photo.updateComment", commentPhoto);
	}

	// [Delete]
	@Override
	public int deleteComment(long commentPnum) {
		return session.delete("com.mycompany.mygym.comment.photo.deleteComment", commentPnum);
	}
}
