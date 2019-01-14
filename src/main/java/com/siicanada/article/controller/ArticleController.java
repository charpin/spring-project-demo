package com.siicanada.article.controller;

import com.siicanada.article.model.Article;
import com.siicanada.article.service.ServiceArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

  @Autowired
  ServiceArticle serviceArticle;

  @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Article> getArticles() {
    return serviceArticle.getArticles();
  }
}
