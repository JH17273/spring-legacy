package com.kh.spring.board.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board") // 공용주소 설정
@Slf4j
public class BoardController {
	

	private final BoardService boardService;
	// ServletContext : application scope를 가진 서블릿 전역에서 사용가능한 객체
	private final ServletContext application;
	/*
	 * ResourceLoader
	 *  - 스프링에서 제공하는 자원 로딩 클래스 
	 *  - classpath,file시스템,url등 다양한 경로의 자원을 동일한 인터페이스로 로드하는 메서드를 제공
	*/	
	private final ResourceLoader resourceLoader;
	
	// BoardType전역객체 설정
	// 	- 어플리케이션 전역에서 사용할 수 있는 BoardType객체를 추가
	//	- 서버 가동중에 1회 수행되어 application에 자동으로 등
	@PostConstruct
	public void init() {
		// key=value, BOARD_CODE = BOARD_NAME
		// N=일반게시판, P=사진게시판
		Map<String, String> boardTypeMap = boardService.getBoardTypeMap();
		application.setAttribute("boardTypeMap", boardTypeMap);
		log.info("boardTypeMap : {} ", boardTypeMap);
	}
	
	// 게시판 목록보기 서비스
	// 일반게시판, 사진게시판, 롤게시판 등등 모든 목록보기 페이지를 하나의 메서드에서 경로를 매핑하는 방법
	// 1. GetMapping의 속성값을 "문자열 배열"형태로 관리
	// @GetMapping({"/list/N","list/P","list/L"})
	// 2. GetMapping에 동적 경로 변수를 사용
	@GetMapping("/list/{boardCode}")
	//	- {boardCode}는 N,P,C,L,D...등 동적으로 바뀌는 모든 보드코드값을 저장할 수 있다.
	//	- 선언한 동적 경로 변수는 @PathVariable어노테이션으로 추출하여 사용할 수 있다.
	//	- @PathVariable로 자원경로 추출시, 추출한 변수는 model영역에 자동으로 추가된다.
	public String selectList(
			@PathVariable("boardCode") String boardCode,
			// currentPage
			//	- 현재 요청한 페이지 번호.(페이징 처리에 필요한 변수)
			//	- 기본값은 1로 처리하여, 값을 전달하지 않은 경우 항상 1페이지로 요청하게 처리
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage
			
			) {
		
		return "";
	}
	
	
}
