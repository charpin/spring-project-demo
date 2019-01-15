package com.siicanada.article.controller;

import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

  @Autowired
  ArticleService articleService;

  @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<ArticleEntity> getArticles() {
    return articleService.getArticles();
  }
}
