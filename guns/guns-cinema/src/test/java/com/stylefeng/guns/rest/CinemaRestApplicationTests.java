package com.stylefeng.guns.rest;

import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.CinemaVO;
import com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo.GetCinemasRequestVo;
import com.stylefeng.guns.rest.persistence.service.impl.CinemaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CinemaRestApplicationTests {

	@Autowired
	CinemaServiceImpl cinemaService;

	@Test
	public void contextLoads() {
	}


	@Test
	public void Test1(){
		GetCinemasRequestVo getCinemasRequestVo = new GetCinemasRequestVo();
		getCinemasRequestVo.setBrandId(99);
		getCinemasRequestVo.setHallType("99");
		getCinemasRequestVo.setDistrictId(99);
		List<CinemaVO> cinemas = cinemaService.getCinemas(12, 1, getCinemasRequestVo);
		for (CinemaVO cinema : cinemas) {
			System.out.println(cinema);
		}
	}
}
