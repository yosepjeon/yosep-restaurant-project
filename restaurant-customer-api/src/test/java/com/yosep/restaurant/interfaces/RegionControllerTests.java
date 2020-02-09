package com.yosep.restaurant.interfaces;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import com.yosep.restaurant.application.RegionService;
import com.yosep.restaurant.domain.Region;

@RunWith(SpringRunner.class)
@WebMvcTest(RegionController.class)
public class RegionControllerTests {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private RegionService regionService;
	
	@Test
	public void list() throws Exception {
		List<Region> regions = new ArrayList<>();
		regions.add(Region.builder().name("Seoul").build());
//		List<Region> regions = regionService.getRegions();
		
		given(regionService.getRegions()).willReturn(regions);
		
		mvc.perform(get("/regions"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Seoul")));
	}
}
