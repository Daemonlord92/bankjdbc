package org.blitmatthew.bankjdbc.service;

import org.blitmatthew.bankjdbc.dto.PostNewUser;
import org.blitmatthew.bankjdbc.dto.UpdateUserRequest;
import org.blitmatthew.bankjdbc.dto.User;

public interface UserService {
    User createUser(PostNewUser postNewUser);
    User updateUserInformation(UpdateUserRequest request);
}
