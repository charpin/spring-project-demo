package com.siicanada.article.service;

import com.siicanada.article.model.Article;
import com.siicanada.article.repository.ArticleRepository;
import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.service.mapping.ArticleMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Override
  public List<Article> getArticles() {

    List<ArticleEntity> articleEntities = articleRepository.findAll();

    return articleEntities.stream()
        .map(articleEntity -> ArticleMapper.INSTANCE.entityToModel(articleEntity)).collect(
            Collectors.toList());
  }
}
