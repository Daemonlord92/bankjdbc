package org.blitmatthew.bankjdbc.repository;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import org.blitmatthew.bankjdbc.entity.UserCredential;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCredentialRepository extends CrudRepository<UserCredential, Long> {
    Optional<UserCredential> findByEmail(String email);
}
