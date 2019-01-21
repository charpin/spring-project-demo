package com.siicanada.article.service;

import com.siicanada.article.model.ArticleModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

  List<ArticleModel> getArticles();

  ArticleModel getArticleById(Integer id);

  List<ArticleModel> getArticlesByTagDescription(String description);

}
