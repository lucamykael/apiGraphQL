package org.apiGraphQL.services;

import lombok.AllArgsConstructor;
import org.apiGraphQL.entities.Transaction;
import org.apiGraphQL.exceptions.NotFoundException;
import org.apiGraphQL.filters.TransactionInput;
import org.apiGraphQL.mappers.TransactionMapper;
import org.apiGraphQL.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class TransactionService {

  private final TransactionRepository repository;
  private final TransactionMapper mapper;

  public Collection<Transaction> getTransactions(){
    return repository.findAll();
  }

  public Transaction postTransaction(TransactionInput dto){
    return repository.save(mapper.toEntity(dto));
  }

  public Transaction updateTransaction(TransactionInput dto){
    Transaction transaction = repository.findTransactionById(dto.getId());
    if(transaction == null){
      throw new NotFoundException("Transaction not found with id: " + dto.getId());
    }

    Transaction newTransaction = mapper.updateEntity(dto, transaction);

    repository.save(newTransaction);

    return newTransaction;
  }

  public String deleteTransaction(String id){
    if(!repository.existsById(id)){
      throw new NotFoundException("Transaction not found with id: " + id);
    }
    repository.deleteById(id);

    return id;
  }
}
