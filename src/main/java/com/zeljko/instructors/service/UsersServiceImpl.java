package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.Users;
import com.zeljko.instructors.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Users getUsersById(int id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUsers(int id) {
        usersRepository.deleteById(id);
    }
}