package com.siicanada.article.integration;

import com.siicanada.article.ArticleApplication;
import com.siicanada.article.model.Article;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArticleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleControllerIT {

  @LocalServerPort
  private int port;

  private TestRestTemplate restTemplate = new TestRestTemplate();

  private HttpHeaders headers = new HttpHeaders();

  @Test
  public void testGetArticles() {

    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/article-api/articles"),
        HttpMethod.GET, entity, String.class);

  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }

}
