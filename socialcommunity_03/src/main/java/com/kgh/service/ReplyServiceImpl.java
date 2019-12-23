package com.kgh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgh.domain.Criteria;
import com.kgh.domain.ReplyPageDTO;
import com.kgh.domain.ReplyVO;
import com.kgh.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	public int register(ReplyVO vo) {
		log.info("register...." + vo);
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		log.info("get ....... " + rno);
		return mapper.read(rno);
		
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("modify ....... " + vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove ....... " + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("get Reply list of a Board "+ bno);
		return mapper.getListWithPaging(cri, bno);
	}
	
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(
				mapper.getCountByBno(bno), 
				mapper.getListWithPaging(cri, bno));
	}
	

}
