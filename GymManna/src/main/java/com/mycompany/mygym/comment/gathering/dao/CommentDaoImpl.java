package com.mycompany.mygym.comment.gathering.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mygym.comment.gathering.vo.Comment;

@Repository("commentDao")
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Comment> selectList(Comment comment) {
		
		return session.selectList("com.mycompany.mygym.comment.gathering.selectCommentList",comment);
	}

	@Override
	public int insertComment(Comment comment) {
		
		return session.insert("com.mycompany.mygym.comment.gathering.insertComment",comment);
	}

	@Override
	public int updateComment(Comment comment) {
		
		return session.update("com.mycompany.mygym.comment.gathering.updateComment",comment);
	}

	@Override
	public int deleteComment(Comment comment) {
	
		return session.delete("com.mycompany.mygym.comment.gathering.deleteComment",comment);
	}


}
