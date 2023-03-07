package com.mycompany.mygym.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private String memberId;
	private String memberPw;
	private String memberName;
}
