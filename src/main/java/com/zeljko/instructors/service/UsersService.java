package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.*;

import java.util.List;

public interface UsersService {

    public List<Users> getAllUsers();

    public Users getUsersById(int Id);

    public void saveOrUpdate(Users users);

    public void deleteUsers(int Id);

}