package com.mycompany.mygym.comment.gathering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.mygym.comment.gathering.service.CommentServiceImpl;
import com.mycompany.mygym.comment.gathering.vo.Comment;

@Controller
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private CommentServiceImpl service;
	
	@RequestMapping(value="create/{pathv}", produces="application/json; charset=UTF-8")
	public Comment insertComment(@PathVariable String pathv, @RequestParam String commentGcontent, int articleGnum,String userNickname ,Model model ) {
		
		Comment comment = new Comment();
		comment.setArticleGnum(articleGnum);
		comment.setCommentGcontent(commentGcontent);
		comment.setUserNickname(userNickname);
		
		boolean result = service.insertComment(comment);
		
		if(result != false) {
			List<Comment> list = service.selectList(comment);
			model.addAttribute("CList",list);
		}
		
		return comment;
	}
	
	@RequestMapping(value="update/{commentGcontent}", produces="application/json; charset=UTF-8")
	public Comment updateComment(@PathVariable String commentGcontent, int commentGnum, Model model) {
		
		Comment comment = new Comment();
		comment.setCommentGnum(commentGnum);
		comment.setCommentGcontent(commentGcontent);
		
		boolean result = service.updateComment(comment);
		
		if(result != false) {
			List<Comment> list = service.selectList(comment);
			model.addAttribute("CList",list);
		}
		
		return comment;
	}
	
	@RequestMapping(value="delete/{commentGnum}", produces="application/json; charset=UTF-8")
	public Comment deleteComment(@PathVariable int commentGnum, Model model) {
		
		Comment comment = new Comment();
		comment.setCommentGnum(commentGnum);
		
		boolean result = service.deleteComment(comment);
		
		if(result != false) {
			List<Comment> list = service.selectList(comment);
			model.addAttribute("CList",list);
		}
		
		return comment;
	}
	
}
