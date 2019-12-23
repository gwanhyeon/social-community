package com.kgh.service;

import java.util.List;

import com.kgh.domain.Criteria;
import com.kgh.domain.ReplyPageDTO;
import com.kgh.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(Long rno);
	public int modify(ReplyVO vo);
	public int remove(Long rno);
	public List<ReplyVO> getList(Criteria cri, Long bno);
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
	
}
