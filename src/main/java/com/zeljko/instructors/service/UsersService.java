package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.*;

import java.util.List;

public interface UsersService {

     List<Users> getAllUsers();

     Users getUsersById(int Id);

     void saveOrUpdate(Users users);

     void deleteUsers(int Id);

}