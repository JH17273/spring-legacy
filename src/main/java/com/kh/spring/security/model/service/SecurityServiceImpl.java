package com.kh.spring.security.model.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.spring.security.model.dao.SecurityDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService{
	
	/*
	 * UserDetailsService
	 *  - 스프링 시큐리티에서 인증 처리시 사용하는 핵심 인터페이스로, 사용자 정보를 조회하는 메서드인
	 *    loadUserByUsername()를 정의하고 있다
	 * loadUserByUsername()
	 *  - 사용자의 아이디를 기반으로 UserDetails객체를 반환하는 메서드
	 *  - 반환된 UserDetails는 비밀번호 및 권한 검증시 사용된다.
	 *  - 일반적으로 DB를 이용하여 사용자 정보를 조회하는 비지니스 로직을 작성한다. 
	 */

	/*
	 * 사용자 인증 프로세스
	 * 1. 사용자가 로그인시 입력한 아이디(username)를 기반으로 사용자 정보를 조회
	 * 2. 조회된 사용자가 없는 경우 usernameNotFoundException를 throw
	 * 3. 인증 성공시 UserDetails객체를 반환
	 * 4. 조회된 사용자 정보를 시큐리티매니저에게 넘겨 비밀번호 및 권한 검증에 사용
	 * 
	 */
	
	private final SecurityDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails member = dao.loadUserByUsername(username);
		
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return member;
	}

}
