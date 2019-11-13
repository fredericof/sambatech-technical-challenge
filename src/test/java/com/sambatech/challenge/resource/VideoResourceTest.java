package com.sambatech.challenge.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sambatech.challenge.SambatechApplication;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SambatechApplication.class)
public class VideoResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_add_video_resource() throws Exception {

		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"duration\": 200.3");
		json.append(",");
		json.append("\"timestamp\": " + System.currentTimeMillis());
		json.append("}");

		this.mockMvc.perform(post("/v1/videos").contentType("application/json").content(json.toString()))
				.andExpect(status().isCreated());
	}

	@Test
	public void should_not_add_video_resource_due_old_timestamp() throws Exception {

		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"duration\": 200.3");
		json.append(",");
		json.append("\"timestamp\": " + (System.currentTimeMillis() - 60000));
		json.append("}");

		this.mockMvc.perform(post("/v1/videos").contentType("application/json").content(json.toString()))
				.andExpect(status().isNoContent());
	}

}
