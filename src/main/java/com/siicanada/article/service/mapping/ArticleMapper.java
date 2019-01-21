package com.siicanada.article.service.mapping;

import com.siicanada.article.model.ArticleModel;
import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.repository.entity.TagEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ArticleMapper {

  public abstract ArticleModel entityToModel(ArticleEntity entity);

  protected String mapTagToString(TagEntity tag) {
    return tag.getDescription();
  }

}
