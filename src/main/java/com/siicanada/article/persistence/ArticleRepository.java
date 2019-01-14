package com.siicanada.article.persistence;

import com.siicanada.article.model.Article;
import java.util.List;

public interface ArticleRepository {

  List<Article> getArticles();
}
