package com.mycompany.mygym.article.photo.controller;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.mygym.article.photo.service.ArticlePhotoService;
import com.mycompany.mygym.article.photo.service.StorageService;
import com.mycompany.mygym.article.photo.vo.ArticlePhoto;
import com.mycompany.mygym.comment.photo.vo.CommentPhoto;

@RestController
@RequestMapping(value = "/article/photo/")
@CrossOrigin(origins = "http://localhost:8081")
public class ArticlePhotoController {
	Logger log = LogManager.getLogger("case3");

	@Autowired
	private ArticlePhotoService service;

	@Autowired
	private StorageService storage;

	// [Create]
	@PostMapping(value = "/")
	public ResponseEntity<?> createPost(@ModelAttribute ArticlePhoto articlePhoto,
			@RequestPart("image") MultipartFile image) throws IOException {

		String imageUrl = storage.store(image);
		int result = service.createPost(articlePhoto, imageUrl);

		if (result == 1) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// [Read]
	@GetMapping(value = "/")
	public ResponseEntity<List<ArticlePhoto>> getPost() {
		List<ArticlePhoto> list = service.getArticle();
		if (list != null) {
			return ResponseEntity.ok(list);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// [Read]
	@GetMapping(value = "/{articlePnum}")
	public ResponseEntity<List<ArticlePhoto>> getPostById(@PathVariable("articlePnum") long articlePnum) {
		List<ArticlePhoto> list = service.getPostById(articlePnum);

		if (list != null) {
			return ResponseEntity.ok(list);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// [Update]
	@PutMapping(value = "/{articlePnum}")
	public ResponseEntity<?> updatePost() {
		return null;
	}

	// [Delete]
	@DeleteMapping(value = "/{articlePnum}")
	public ResponseEntity<?> deletePost() {
		return null;
	}

}
