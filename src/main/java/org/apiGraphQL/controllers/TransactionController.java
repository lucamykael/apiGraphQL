package org.apiGraphQL.controllers;

import lombok.RequiredArgsConstructor;
import org.apiGraphQL.entities.Transaction;
import org.apiGraphQL.filters.TransactionInput;
import org.apiGraphQL.services.TransactionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionService service;

  @QueryMapping
  public Collection<Transaction> findTransactions(){
    return service.getTransactions();
  }

  @MutationMapping
  public ResponseEntity<Transaction> createTransaction(@Argument("input") TransactionInput dto){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.postTransaction(dto));
  }

  @MutationMapping
  public ResponseEntity<Transaction> updateTransaction(@Argument("input") TransactionInput dto){
    return ResponseEntity.status(HttpStatus.OK).body(service.updateTransaction(dto));
  }

  @MutationMapping
  public ResponseEntity<String> deleteTransaction(@Argument("id") String id){
    return ResponseEntity.status(HttpStatus.OK).body(service.deleteTransaction(id));
  }
}
