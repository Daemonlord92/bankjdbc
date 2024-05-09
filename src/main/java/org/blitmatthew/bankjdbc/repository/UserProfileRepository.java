package org.blitmatthew.bankjdbc.repository;

import org.blitmatthew.bankjdbc.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserCredentialId(long id);
}
