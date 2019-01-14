package com.siicanada.article.service;

import com.siicanada.article.model.Article;
import org.springframework.stereotype.Service;

@Service
public interface ServiceArticle {

  Iterable<Article> getArticles();
}
