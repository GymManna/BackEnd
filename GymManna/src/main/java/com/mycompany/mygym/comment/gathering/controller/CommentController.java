package com.mycompany.mygym.comment.gathering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.mygym.comment.gathering.service.CommentServiceImpl;
import com.mycompany.mygym.comment.gathering.vo.GComment;

@Controller
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private CommentServiceImpl service;
	
	@RequestMapping(value="create/{pathv}", produces="application/json; charset=UTF-8")
	public GComment insertComment(@PathVariable String pathv, @RequestParam String commentGcontent, int articleGnum,String userNickname ,Model model ) {
		
		GComment comment = new GComment();
		comment.setArticleGnum(articleGnum);
		comment.setCommentGcontent(commentGcontent);
		comment.setUserNickname(userNickname);
		
		boolean result = service.insertComment(comment);
		
		if(result != false) {
			List<GComment> list = service.selectList(comment);
			model.addAttribute("CList",list);
		}
		
		return comment;
	}
	
	@RequestMapping(value="update/{commentGcontent}/{commentGnum}", produces="application/json; charset=UTF-8")
	public GComment updateComment(@PathVariable String commentGcontent, @PathVariable int commentGnum, Model model) {
		
		GComment comment = new GComment();
		comment.setCommentGnum(commentGnum);
		comment.setCommentGcontent(commentGcontent);
		
		boolean result = service.updateComment(comment);
		
		if(result != false) {
			List<GComment> list = service.selectList(comment);
			model.addAttribute("CList",list);
		}
		
		return comment;
	}
	
	@RequestMapping(value="delete/{commentGnum}", produces="application/json; charset=UTF-8")
	public GComment deleteComment(@PathVariable int commentGnum, Model model) {
		
		GComment comment = new GComment();
		comment.setCommentGnum(commentGnum);
		
		boolean result = service.deleteComment(comment);
		
		if(result != false) {
			List<GComment> list = service.selectList(comment);
			model.addAttribute("CList",list);
		}
		
		return comment;
	}
	
}
