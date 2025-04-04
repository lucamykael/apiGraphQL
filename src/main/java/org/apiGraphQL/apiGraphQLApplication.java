package org.apiGraphQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.apiGraphQL")
public class apiGraphQLApplication {
  public static void main(String[] args) {

    SpringApplication.run(apiGraphQLApplication.class, args);
  }
}