package com.example.demo.interfaces.note;

import com.example.demo.DemoApplication;
import com.example.demo.domain.service.NoteCreateService;
import com.example.demo.interfaces.GenericMapDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
public class NoteControllerTest {

  @Autowired
  private NoteCreateService noteCreateService;

  @Autowired
  private JdbcOperations jdbcOperations; // 各テスト前処理用

  @Autowired
  private MockMvc mvc;

  @Before
  public void eachBefore() {
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=0");
    jdbcOperations.execute("TRUNCATE note");
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=1");
  }

  @After
  public void eachAfter() {
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=0");
    jdbcOperations.execute("TRUNCATE note");
    jdbcOperations.execute("SET FOREIGN_KEY_CHECKS=1");
  }

  /**
   * POST /notes
   */
  @Test
  public void create() throws Exception {
    String json = "{\n" +
      "            \"title\": \"ほげ\",\n" +
      "            \"content\": \"ふが\"\n" +
      "        }";

    MvcResult result = this.mvc.perform(
      post("/notes")
        .with(csrf())
        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .content(json)
    )
      .andExpect(status().is2xxSuccessful())
      .andReturn();

    MockHttpServletResponse response = result.getResponse();
    String responseJson = response.getContentAsString();

    Gson gson = new GsonBuilder()
      .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
      }.getType(), new GenericMapDeserializer<>())
      .serializeNulls()
      .create();


    Map<String, Object> map = gson.fromJson(responseJson, new TypeToken<Map<String, Object>>() {
    }.getType());

    Assert.assertNull(map.get("error_message"));
    Assert.assertTrue(((String) map.get("id")).matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"));
  }

}
