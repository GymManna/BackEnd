package com.mycompany.mygym.article.gathering.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.mycompany.mygym.article.gathering.service.ArticleService;
import com.mycompany.mygym.article.gathering.vo.Gathering;
import com.mycompany.mygym.comment.gathering.service.CommentServiceImpl;
import com.mycompany.mygym.comment.gathering.vo.GComment;

@RestController
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService service;
	
	@Autowired
	private CommentServiceImpl Cservice;
	
	Logger log = LogManager.getLogger("case3");

	// 만나 센터 별 게시글 수 확인
	@RequestMapping(value="search/{pathv}" , produces = "application/json; charset=UTF-8")
	public Gathering searchCountHandler(@PathVariable String pathv ,@RequestParam String centerName, Model model) {
		log.debug(centerName);
		Gathering gathering = new Gathering();
		gathering.setCenterName(centerName);
		
		int count = service.readText(gathering);
		
		model.addAttribute("countManna",count);
		
		gathering.setCountGnum(count);
		
		log.debug(count);
		
		return gathering;
		
	}
	
	// 만나 센터의 게시글 리스트
	@RequestMapping(value="searchlist/{pathv}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Gathering>> searchListHandler(@PathVariable String pathv, @RequestParam String centerName, long articleGnum, Model model) {
		
		Gathering gathering = new Gathering();
		gathering.setCenterName(centerName);
		gathering.setArticleGnum(articleGnum);
		log.debug(articleGnum);
		
		List<Gathering> list = service.selectGatheringList(gathering);
		
		model.addAttribute("GList",list);
		
		log.debug(list);
	
		return ResponseEntity.ok(list);
	}
	
	
	// 만나 게시글의 상세보기
	@RequestMapping(value="detail/{pathv}", produces = "application/json; charset=UTF-8")
	public HashMap<Object, Object> searchDetail(@PathVariable String pathv , @RequestParam long articleGnum, Model model) {
		
		Gathering gathering = new Gathering();
		gathering.setArticleGnum(articleGnum);
		
		GComment comment = new GComment();
		comment.setArticleGnum(articleGnum);
		
		log.debug(articleGnum);
		
		// 게시글 상세 정보 불러오기
		Gathering info = service.selectInfo(gathering);
		
		// 게시글 댓글 리스트 불러오기 
		List<GComment> list = Cservice.selectList(comment);
		
		log.debug(info);
		model.addAttribute("DInfo",info);
		model.addAttribute("CList",list);
		
		HashMap<Object, Object> map = new HashMap<Object , Object>();
		
		map.put("gathering", info);
		map.put("comment", list);
		
		return map;
		
	}
		
	
	// 만나 게시글 작성
	@RequestMapping(value="create/{pathv}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Gathering>> createArticle(@PathVariable String pathv , @RequestParam String title, String content,String category , String userId , Model model) {
		
		Gathering gathering = new Gathering();
		gathering.setArticleGtitle(title);
		gathering.setArticleGcontent(content);
		gathering.setCategoryType(category);
		gathering.setUserId(userId);
		
		List<Gathering> result = service.createArticle(gathering);
		
		model.addAttribute("GList",result);
		
		return ResponseEntity.ok(result);
	}
	
	// 만나 게시글 상세페이지 수정
	@RequestMapping(value="update/{pathv}", produces = "application/json; charset=UTF-8")
	public Gathering updateArticle(@PathVariable String pathv , @RequestParam long gnum,String title, String content, int countPuser, String centerName, Model model) {
		
		Gathering gathering = new Gathering();
		gathering.setArticleGnum(gnum);
		gathering.setArticleGtitle(title);
		gathering.setArticleGcontent(content);
		gathering.setCountPuser(countPuser);
		gathering.setCenterName(centerName);

		Gathering result = service.updateArticle(gathering);
		
		model.addAttribute("DInfo",result);
		
		return result;
	}
	
	// 만나 게시글 삭제
	@RequestMapping(value="delete/{pathv}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Gathering>> deleteArticle(@PathVariable String pathv , @RequestParam long gnum, Model model) {
		
		Gathering gathering = new Gathering();
		gathering.setArticleGnum(gnum);
		
		List<Gathering> list = service.deleteArticle(gathering);
		
		return ResponseEntity.ok(list);
		
	}
	
	// 만나 게시글 큐알코드
    @GetMapping("qr")
    public Object createQr(@RequestParam String url) throws WriterException, IOException {
    	
    	String path = System.getProperty("user.dir") + File.separator;
    	
    	File file = new File(path);
    	
    	int width = 200;
    	int height = 200;
    
    	BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height);


    	try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
       
    		MatrixToImageWriter.writeToStream(matrix, "PNG", out);
        
    	return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(out.toByteArray());
    	}
	
    }
	
    
}
