package org.apiGraphQL.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionDto {

  private String name;

  private String country;

  private Timestamp createdAt;
}
