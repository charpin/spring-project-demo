package com.siicanada.article.service;

import com.siicanada.article.model.Article;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

  List<Article> getArticles();

  Article getArticleById(Integer id);

  List<Article> getArticlesByTagDescription(String description);

}
