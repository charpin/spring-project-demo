package com.siicanada.article.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Classe de test de la classe {@link Article}
 */
public class ArticleTest {

  @Test
  public void whenConvertArticleToJsonThenCorrect() throws JsonProcessingException {
    Article article = new Article();
    article.setId(1);
    article.setTitle("Bienvenue");
    article.setIntro("Ceci est une intro");

    String jsonExpected = "{\"id\":1,\"title\":\"Bienvenue\",\"intro\":\"Ceci est une intro\",\"text\":null,\"picture\":null,\"picture_description\":null,\"tags\":null}";
    String result = new ObjectMapper().writeValueAsString(article);

    Assert.assertEquals(jsonExpected, result);
  }
}
