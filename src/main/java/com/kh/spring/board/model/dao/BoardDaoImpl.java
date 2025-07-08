package com.kh.spring.board.model.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardExt;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.board.model.vo.BoardType;
import com.kh.spring.common.model.vo.PageInfo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao{
	
	private final SqlSessionTemplate session;
	
	@Override
	public Map<String, String> getBoardTypeMap() {
		/*
		 * selectMap
		 *  - Map<Key,value>형태의 데이터를 반환하는 메서드
		 *  - 두번째 매개변수로는 어떤 '칼럼' 을 key로 사용할지를 작성
		 *  - SEELCT key,value FROM TABLE
		*/
		return session.selectMap("board.getBoardTypeMap","boardCd");
	}
	@Override
	public int selectListCount(Map<String, Object> paramMap) {
		return 0;
	}

	@Override
	public List<Board> selectList(PageInfo pi, Map<String, Object> paramMap) {
		return null;
	}

	@Override
	public List<BoardType> selectBoardTypeList() {
		return null;
	}

	@Override
	public int insertBoard(Board b) {
		return 0;
	}

	@Override
	public int insertBoardImg(BoardImg bi) {
		return 0;
	}

	@Override
	public int insertBoardImgList(List<BoardImg> imgList) {
		return 0;
	}

	@Override
	public BoardExt selectBoard(int boardNo) {
		return null;
	}

	@Override
	public int increaseCount(int boardNo) {
		return 0;
	}

	@Override
	public List<BoardImg> selectBoardImgList(int boardNo) {
		return null;
	}

	@Override
	public int updateBoard(Board board) {
		return 0;
	}

	@Override
	public int deleteBoardImg(String deleteList) {
		return 0;
	}

	@Override
	public int updateBoardImg(BoardImg bi) {
		return 0;
	}

	@Override
	public List<String> selectFileList() {
		return null;
	}


	
	
	
	
	
	
	
	
}
