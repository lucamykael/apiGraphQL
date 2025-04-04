package org.apiGraphQL.mappers;

import org.apiGraphQL.dtos.TransactionDto;
import org.apiGraphQL.entities.Transaction;
import org.apiGraphQL.filters.TransactionInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {

  @Mapping(target = "name", source = "name")
  @Mapping(target = "country", source = "country")
  @Mapping(target = "createdAt", source = "createdAt")
  TransactionDto toDto (Transaction entity);

  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
  @Mapping(target = "name", source = "dto.name")
  @Mapping(target = "country", source = "dto.country")
  @Mapping(target = "createdAt", expression = "java(new java.sql.Timestamp(System.currentTimeMillis()))")
  Transaction toEntity (TransactionInput dto);


  @Mapping(target = "id", source = "dto.id")
  @Mapping(target = "name", source = "dto.name")
  @Mapping(target = "country", source = "dto.country")
  @Mapping(target = "createdAt", source = "transaction.createdAt")
  Transaction updateEntity(TransactionInput dto, Transaction transaction);
}
