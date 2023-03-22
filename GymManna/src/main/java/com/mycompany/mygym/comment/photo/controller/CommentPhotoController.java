package com.mycompany.mygym.comment.photo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.mygym.comment.photo.service.CommentPhotoService;
import com.mycompany.mygym.comment.photo.vo.CommentPhoto;

@RestController
@RequestMapping(value = "/article/photo/{articlePnum}/comment/")
@CrossOrigin(origins = "http://localhost:8081")
public class CommentPhotoController {
	Logger log = LogManager.getLogger("case3");

	@Autowired
	private CommentPhotoService service;

	// [Create]
	@PostMapping(value = "/")
	public ResponseEntity<?> createComment(@ModelAttribute CommentPhoto commentPhoto) {
		int result = service.createComment(commentPhoto);

		if (result != 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// [Read]
	@GetMapping(value = "/")
	public ResponseEntity<List<CommentPhoto>> getComment(@PathVariable("articlePnum") long articlePnum) {
		List<CommentPhoto> list = service.getComment(articlePnum);

		if (list != null) {
			return ResponseEntity.ok(list);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// [Update]
	@PutMapping(value = "/{commentPnum}")
	public ResponseEntity<?> updateComment(@PathVariable("commentPnum") long commentPnum,
			@RequestBody CommentPhoto commentPhoto) {
		
		commentPhoto.setCommentPnum(commentPnum);
		
		int result = service.updateComment(commentPhoto);
		
		if (result != 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// [Delete]
	@DeleteMapping(value = "/{commentPnum}")
	public ResponseEntity<?> deleteComment(@PathVariable("commentPnum") long commentPnum) {

		int result = service.deleteComment(commentPnum);

		if (result != 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
