package org.blitmatthew.bankjdbc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.blitmatthew.bankjdbc.annotation.LogExecutionTime;
import org.blitmatthew.bankjdbc.dto.PostNewUser;
import org.blitmatthew.bankjdbc.dto.UpdateUserRequest;
import org.blitmatthew.bankjdbc.dto.User;
import org.blitmatthew.bankjdbc.entity.UserCredential;
import org.blitmatthew.bankjdbc.entity.UserProfile;
import org.blitmatthew.bankjdbc.exception.EntityExistsException;
import org.blitmatthew.bankjdbc.exception.EntityNotFoundException;
import org.blitmatthew.bankjdbc.repository.UserCredentialRepository;
import org.blitmatthew.bankjdbc.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    protected final UserCredentialRepository userCredentialRepository;
    protected final UserProfileRepository profileRepository;

    @Override
    @Transactional(rollbackFor = {DateTimeParseException.class, RuntimeException.class})
    @LogExecutionTime
    public User createUser(PostNewUser postNewUser) {
        log.info("UserServiceImpl:MJM:L35->Creating the UserCredential and UserProfile");
        if(userCredentialRepository.findByEmail(postNewUser.email()).isPresent()) throw new EntityExistsException("Email already inuse, Please log in.");
        UserCredential userCredential = UserCredential.builder()
                .email(postNewUser.email())
                .password(postNewUser.password())
                .build();
        userCredential = userCredentialRepository.save(userCredential);
        UserProfile userProfile = UserProfile.builder()
                .firstName(postNewUser.firstName())
                .lastName(postNewUser.lastName())
                .address(postNewUser.address())
                .creditScore(postNewUser.creditScore())
                .phone(postNewUser.phone())
                .dateOfBirth(LocalDate.parse(postNewUser.dateOfBirth()))
                .userCredentialId(userCredential.getId())
                .build();
        userProfile = profileRepository.save(userProfile);
        log.info("UserServiceImpl:MJM:L49->Completed and returning data in a User Record");
        return new User(
                userProfile.getId(),
                postNewUser.firstName(),
                postNewUser.lastName(),
                postNewUser.address(),
                postNewUser.phone(),
                postNewUser.email(),
                postNewUser.creditScore(),
                LocalDate.parse(postNewUser.dateOfBirth()));
    }

    @Override
    public User updateUserInformation(UpdateUserRequest request) {
        UserCredential userCredential = userCredentialRepository.findById(request.id())
                .orElseThrow(() -> new EntityNotFoundException(request.id() + " id not found"));
        UserProfile userProfile = profileRepository.findByUserCredentialId(request.id())
                .orElseThrow(() -> new EntityNotFoundException(request.id() + " id not found"));
        userCredential.setEmail(request.email());
        userCredential.setPassword(request.password());
        userProfile.setFirstName(request.firstName());
        userProfile.setLastName(request.lastName());
        userProfile.setAddress(request.address());
        userProfile.setCreditScore(request.creditScore());
        userProfile.setPhone(request.phone());
        userProfile.setDateOfBirth(request.dateOfBirth());
        return new User(
                userProfile.getId(),
                request.firstName(),
                request.lastName(),
                request.address(),
                request.phone(),
                request.email(),
                request.creditScore(),
                request.dateOfBirth());
    }
}
