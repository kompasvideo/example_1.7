package com.example.users.service;

import com.example.users.exception.BadRequestException;
import com.example.users.exception.InternalServerError;
import com.example.users.exception.NotFoundException;
import com.example.users.model.User;
import com.example.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Transactional
    @Override
    public User saveUser(User userDto) {
        validate(userDto);
        return userRepository.save(userDto);
    }

    @Transactional
    @Override
    public User updateUser(long userId, User updateUser) {
        validateForUpdateUser(userId, updateUser);
        User user = userRepository.findById(userId).orElseThrow();
        if(updateUser.getName() != null)
            user.setName(updateUser.getName());
        if(updateUser.getEmail() != null)
            user.setEmail(updateUser.getEmail());
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long userId) {
        userIdValidate(userId);
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseThrow();
    }

    @Transactional
    @Override
    public void deleteUser(long userId) {
        userIdValidate(userId);
        userRepository.deleteById(userId);
    }

    private void validate(User user){
        if(user.getEmail() == null || user.getEmail().isBlank())
            throw new BadRequestException();
        if(user.getEmail().contains("@"))
            throw new BadRequestException();
    }

    private void validateForUpdateUser(long userId, User user) {
        userIdValidate(userId);
        if(user.getEmail() != null){
            emailValidate(user.getEmail());
        };
    }

    private void emailValidate(String email){
        List<User> users = userRepository.findAll();
        if(users.stream().allMatch(user -> user.getEmail().equals(email))){
            throw new InternalServerError();
        }
    }
    private void userIdValidate(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new NotFoundException("User not found, id = " + userId);
        }
    }
}
