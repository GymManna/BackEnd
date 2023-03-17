package com.mycompany.mygym.article.gathering.dao;

import java.util.List;

import com.mycompany.mygym.article.gathering.vo.Gathering;

public interface ArticleDaoImpl {

	int selectText(Gathering gathering);
	
	List<Gathering> selectGatheringList(Gathering gathering);
	
	Gathering selectInfo(Gathering gathering);
	
	int createArticle(Gathering gathering);
	
	int updateArticle(Gathering gathering);
	
	int deleteArticle(Gathering gathering);
}
