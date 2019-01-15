package com.siicanada.article.service;

import com.siicanada.article.repository.entity.ArticleEntity;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

  Iterable<ArticleEntity> getArticles();
}
