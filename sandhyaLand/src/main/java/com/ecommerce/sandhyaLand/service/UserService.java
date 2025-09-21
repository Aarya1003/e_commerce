package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.UserException;
import com.ecommerce.sandhyaLand.model.User;

public interface UserService {

      User findUserById(Long userId) throws UserException;

      User findUserProfileByJwt(String Jwt) throws UserException;
}
