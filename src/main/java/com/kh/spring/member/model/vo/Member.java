package com.kh.spring.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor 
//@RequiredArgsConstructor // final에 대한 변수에만 Required를 붙여줌. 필수입력.
@Data
@Builder
public class Member {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String profileImg;
	private String email;
    private String birthday;
    private String gender;
    private String phone;
    private String address;
    private Date enrollDate;
    private Date modifyDate;
    private String status;
	
	
	
	
}
