package com.siicanada.article.service;

import com.siicanada.article.model.Article;
import com.siicanada.article.persistence.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceArticleImpl implements ServiceArticle {

  @Autowired
  private ArticleRepository articleRepository;

  @Override
  public Iterable<Article> getArticles() {
    return articleRepository.findAll();
  }
}
