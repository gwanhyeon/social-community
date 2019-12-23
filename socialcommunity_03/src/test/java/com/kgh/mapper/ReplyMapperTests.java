package com.kgh.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kgh.domain.Criteria;
import com.kgh.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	private Long[] bnoArr = {460L, 461L, 462L, 463L, 464L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			
			//게시물 번호
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글테스트" +i);
			vo.setReplyer("replyer"+i);
			mapper.insert(vo);
		});
	}
	@Test
	public void testRead() {
		Long targetRno = 5L;
		ReplyVO vo = mapper.read(targetRno);
		log.info("TestREAD" + vo);
	}
	@Test
	public void testUpdate() {
		Long targetRno = 10L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("update reply");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT: " + count);
	}
	@Test
	public void TestListener() {
		Criteria cri = new Criteria();
		// 3145745L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply->log.info(reply));
	}
	
	@Test
	public void testMapper() {
		log.info(mapper);
	
	}
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 460L);
		replies.forEach(reply->log.info(reply));
	}

}
