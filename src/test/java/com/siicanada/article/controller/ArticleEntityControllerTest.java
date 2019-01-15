package com.siicanada.article.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.siicanada.article.model.Article;
import com.siicanada.article.service.ArticleService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleEntityControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ArticleService articleService;

  @Test
  public void getArticles_shouldReturnArticleListAndStatusCode200() throws Exception {
    String jsonExpected = "[{\"id\":1,\"title\":\"Bienvenue\",\"intro\":\"Ceci est une intro\",\"text\":null,\"picture\":null,\"picture_description\":null,\"tags\":null}]";

    Article article = new Article();
    article.setId(1);
    article.setTitle("Bienvenue");
    article.setIntro("Ceci est une intro");

    List<Article> articleList = new ArrayList<>();
    articleList.add(article);

    when(articleService.getArticles()).thenReturn(articleList);
    mockMvc.perform(get("/articles"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(jsonExpected))
        .andExpect(status().isOk());

    verify(articleService, times(1)).getArticles();
  }

  @Test
  public void getArticlesWithWrongPath_shouldReturnStatusCode404() throws Exception {
    mockMvc.perform(get("/articlesList"))
        .andExpect(status().isNotFound());
  }
}
