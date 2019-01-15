package com.siicanada.article.service;

import com.siicanada.article.repository.ArticleRepository;
import com.siicanada.article.repository.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Override
  public Iterable<ArticleEntity> getArticles() {
    return articleRepository.findAll();
  }
}
