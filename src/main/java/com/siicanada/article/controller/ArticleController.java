package com.siicanada.article.controller;

import com.siicanada.article.model.ArticleModel;
import com.siicanada.article.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour les articles
 */
@RestController
public class ArticleController {

  @Autowired
  ArticleService articleService;

  @GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ArticleModel>> getArticles() {
    return new ResponseEntity<>(articleService.getArticles(), HttpStatus.OK);
  }

  @GetMapping(value = "/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ArticleModel> getArticleById(@PathVariable("id") Integer id) {
    return new ResponseEntity<>(articleService.getArticleById(id), HttpStatus.OK);
  }
}
