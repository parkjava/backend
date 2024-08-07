package com.parkjava.service;

import com.parkjava.model.usersModel;
import com.parkjava.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersService {

    @Autowired
    private usersRepository usersRepository;

    public List<usersModel> getAllUsers() { return usersRepository.findAll();}

    public usersModel getUserById(Long id){ return usersRepository.findById(id).orElse(null);}

    public usersModel createUsers(usersModel users) {
        return usersRepository.save(users);
    }

    public usersModel updateUsers(Long id, usersModel usersDetails){
        usersModel  user = usersRepository.findById(id).orElse(null);

        if (user != null) {
            user.setUser_name(usersDetails.getUser_name());
            user.setUser_pw(usersDetails.getUser_pw());
            user.setUser_id(usersDetails.getUser_id());
            return usersRepository.save(user);
        }
        return null;
    }
    public void deleteUsers(Long id){
        usersRepository.deleteById(id);
    }
}