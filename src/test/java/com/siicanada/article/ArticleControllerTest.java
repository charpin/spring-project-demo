package com.siicanada.article;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
public class ArticleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getArticles_shouldReturnStatusCode200() throws Exception {
    //mockMvc.perform(get("/aricles")).andExpect(status().isOk());
  }
}
