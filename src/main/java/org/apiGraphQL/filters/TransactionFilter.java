package org.apiGraphQL.filters;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TransactionFilter {

  @Schema
  private String id;

  @Schema
  private String name;

  @Schema
  private String country;

  @Schema
  private String createdAt;
}
