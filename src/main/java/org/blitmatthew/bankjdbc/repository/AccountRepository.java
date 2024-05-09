package org.blitmatthew.bankjdbc.repository;

import org.blitmatthew.bankjdbc.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
