package com.xaut.Employee;

import com.xaut.Employee.Data.Cache;
import com.xaut.Employee.entity.Employee;
import net.minidev.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {

	@Test
	public void contextLoads() {
	}

	private MockMvc mockMvc;
	private Map<String, Object> map = new HashMap<>();

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		map.put("name", "小王");
		map.put("age", 12);
		map.put("gender", 1);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testQuery() throws Exception {
		//Given
		String expect = "[{\"id\":0,\"name\":\"小明\",\"age\":20,\"gender\":\"男\"},{\"id\":1,\"name\":\"小红\",\"age\":19,\"gender\":\"女\"},{\"id\":2,\"name\":\"小智\",\"age\":15,\"gender\":\"男\"},{\"id\":3,\"name\":\"小刚\",\"age\":16,\"gender\":\"男\"},{\"id\":4,\"name\":\"小霞\",\"age\":15,\"gender\":\"女\"}]";
		String url = "/employees";

		//When
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();

		//Then
		Assert.assertEquals(expect, mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void testUpdate() throws Exception {
		//Given
		map.put("id", "3");
		String url = "/employees";
		String expect = "小王";

		//When
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())
				.andReturn();

		//Then
		Employee result = Cache.getCache().stream().filter(n -> n.getId() == 3).findFirst().get();
		Assert.assertEquals(expect, result.getName());
	}

	@Test
	public void testCreate() throws Exception {
		//Given
		map.put("id", "6");
		String url = "/employees";
		String expect = "小王";

		//When
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())
				.andReturn();

		//Then
		Employee result = Cache.getCache().stream().filter(n -> n.getId() == 6).findFirst().get();
		Assert.assertEquals(expect, result.getName());
	}

	@Test
	public void testDelete() throws Exception {
		//Given
		map.put("id", "1");
		map.put("name", "小红");
		map.put("age", 19);
		map.put("gender", 1);
		String url = "/employees";

		//When
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url).contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())
				.andReturn();

		//Then
		Boolean result = Cache.getCache().stream().anyMatch(n -> n.getId() == 1);
		Assert.assertFalse(result);
	}

	@After
	public void tearDown() throws Exception {
		map.clear();
	}
}
