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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Classe de test de la classe {@link ArticleController}
 */
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(TagController.class)
@AutoConfigureMockMvc
public class TagControllerTest {


  @InjectMocks
  private TagController tagController;

  private MockMvc mockMvc;

  @Mock
  private ArticleService articleService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(tagController).build();
  }

  @Test
  public void getArticlesByTagDescriptionShouldReturnArticleListAndStatusCode200()
      throws Exception {
    String jsonExpected = "[{\"id\":1,\"title\":\"Bienvenue\",\"intro\":\"Ceci est une intro\",\"text\":null,\"picture\":null,\"picture_description\":null,\"tags\":null}]";

    Article article = new Article();
    article.setId(1);
    article.setTitle("Bienvenue");
    article.setIntro("Ceci est une intro");

    List<Article> articleList = new ArrayList<>();
    articleList.add(article);

    when(articleService.getArticlesByTagDescription("sport")).thenReturn(articleList);
    mockMvc.perform(get("/tags/{description}/articles", "sport"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(jsonExpected))
        .andExpect(status().isOk());

    verify(articleService, times(1)).getArticlesByTagDescription("sport");
  }

  @Test
  public void getArticlesWithUnknownDescriptionPathShouldReturnStatusCode404() throws Exception {
    mockMvc.perform(get("/tags/{description}/article", "TV"))
        .andExpect(status().isNotFound());
  }

}
