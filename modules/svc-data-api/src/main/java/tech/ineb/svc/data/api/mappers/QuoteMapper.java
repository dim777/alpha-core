package tech.ineb.svc.data.api.mappers;

import org.mapstruct.*;
import ru.rzvt.flow.data.libcommonentities.entities.gp.spark.sink.tables.pojos.TblOffset;
import ru.rzvt.flow.data.libcommonstreamsupport.model.CommitMetaInfo;
import ru.rzvt.flow.data.libcommonstreamsupport.model.OffsetDTO;
import tech.ineb.lib.common.models.Quote;
import tech.ineb.lib.common.models.rest.QuoteSeriesRequest;

import java.util.UUID;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface QuoteMapper {
  @Mapping(source = "tblName", target = "tableName")
  Quote toDTO(QuoteSeriesRequest request);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(source = "tableName", target = "tblName")
  @Mapping(source = "commitMetaInfo.offset", target = "offset")
  @Mapping(source = "commitMetaInfo.partition", target = "partition")
  @BeanMapping(qualifiedByName = {"DefaultID"})
  TblOffset toPOJO(String tableName, CommitMetaInfo commitMetaInfo);

  @Mapping(target = "version", ignore = true)
  @Mapping(source = "tableName", target = "tblName")
  TblOffset toPOJO(OffsetDTO offset);

  @AfterMapping
  @Named("DefaultID")
  default void defaultId(@MappingTarget TblOffset offset) {
    offset.setId(UUID.randomUUID());
  }
}
