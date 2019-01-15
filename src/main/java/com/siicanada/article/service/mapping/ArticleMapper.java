package com.siicanada.article.service.mapping;

import com.siicanada.article.model.Article;
import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.repository.entity.TagEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ArticleMapper {

  public static ArticleMapper INSTANCE = Mappers.getMapper( ArticleMapper.class );

  public abstract Article entityToModel(ArticleEntity entity);

  protected String mapTagToString(TagEntity tag) {
    return tag.getDescription();
  }

}
