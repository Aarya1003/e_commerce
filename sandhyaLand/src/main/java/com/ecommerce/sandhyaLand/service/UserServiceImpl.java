package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.config.JwtProvider;
import com.ecommerce.sandhyaLand.exception.UserException;
import com.ecommerce.sandhyaLand.model.User;
import com.ecommerce.sandhyaLand.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository  userRepository;
    JwtProvider jwtProvider;

    public UserServiceImpl(JwtProvider jwtProvider, UserRepository userRepository) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()){
            return userRepository.save(user.get());
        }
        throw new UserException("User not found with id "+userId);
    }

    @Override
    public User findUserProfileByJwt(String Jwt) throws UserException {
        String email=jwtProvider.getEmailFromToken(Jwt);
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UserException("User not found with email "+email);
        }
        return userRepository.save(user);
    }
}


















