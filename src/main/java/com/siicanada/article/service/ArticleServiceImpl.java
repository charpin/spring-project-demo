package com.siicanada.article.service;

import com.siicanada.article.exception.ArticleNotFoundException;
import com.siicanada.article.exception.TagNotFoundException;
import com.siicanada.article.model.Article;
import com.siicanada.article.repository.ArticleRepository;
import com.siicanada.article.repository.TagRepository;
import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.repository.entity.TagEntity;
import com.siicanada.article.service.mapping.ArticleMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Autowired
  private TagRepository tagRepository;

  @Autowired
  private ArticleMapper articleMapper;

  @Override
  public List<Article> getArticles() {

    List<ArticleEntity> articleEntities = articleRepository.findAll();

    return articleEntities.stream()
        .map(articleEntity -> articleMapper.entityToModel(articleEntity)).collect(
            Collectors.toList());
  }

  @Override
  public Article getArticleById(Integer id) {
    ArticleEntity articleEntity = articleRepository.findById(id)
        .orElseThrow(() -> new ArticleNotFoundException("Cannot find article id=" + id));
    return articleMapper.entityToModel(articleEntity);
  }

  @Override
  public List<Article> getArticlesByTagDescription(String description) {
    TagEntity tagEntity = tagRepository.getByDescription(description);
    if (tagEntity == null) {
      throw new TagNotFoundException("Cannot find tag by description=" + description);
    }
    return tagEntity.getArticles().stream()
        .map(articleEntity -> articleMapper.entityToModel(articleEntity)).collect(
            Collectors.toList());
  }
}
