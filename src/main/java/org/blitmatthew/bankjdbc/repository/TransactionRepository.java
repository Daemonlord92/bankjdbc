package org.blitmatthew.bankjdbc.repository;

import org.blitmatthew.bankjdbc.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
