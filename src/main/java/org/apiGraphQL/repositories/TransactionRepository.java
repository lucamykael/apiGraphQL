package org.apiGraphQL.repositories;

import org.apiGraphQL.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
  String deleteTransactionById(String id);
  Transaction findTransactionById(String id);
}
