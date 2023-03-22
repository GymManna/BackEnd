package com.mycompany.mygym.comment.photo.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentPhoto {
	private long commentPnum;
	private String commentPcontent;
	private Date commentPdate;
	
	private long articlePnum;
	private String userNickname;
}
