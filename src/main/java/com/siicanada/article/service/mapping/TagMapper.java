package com.siicanada.article.service.mapping;

import com.siicanada.article.model.Tag;
import com.siicanada.article.repository.entity.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses= {ArticleMapper.class})
public interface TagMapper {

  TagMapper INSTANCE = Mappers.getMapper( TagMapper.class );

  Tag entityToModel(TagEntity entity);
}
