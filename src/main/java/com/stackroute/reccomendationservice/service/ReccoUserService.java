package com.stackroute.reccomendationservice.service;


import com.stackroute.reccomendationservice.model.*;
import com.stackroute.reccomendationservice.repository.ReccoUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReccoUserService {

    @Autowired
    private ReccoUserRepository reccoUserRepository;


    public List<String> userReccomendations(String userId) throws Exception {
        if(reccoUserRepository.findById(userId).isEmpty()){
            throw new Exception("User not found");
        }
        else{
            Optional<ReccoUser> tempUser = reccoUserRepository.findById(userId);
            return tempUser.get().getreccomendations();
        }
    }
    public ReccoUser addNewUser(ReccoUser gifUser){
        System.out.println(reccoUserRepository.findById(gifUser.getUserId()));
        if(reccoUserRepository.findAll().size()==0){
            reccoUserRepository.save(gifUser);
            return gifUser;
        }

        else if(reccoUserRepository.findById(gifUser.getUserId()).isPresent()){
            reccoUserRepository.save(gifUser);
            return null;
        }
        return null;

    }

    public boolean addReccomendation(ReccoUser user){
        if(reccoUserRepository.findAll().size()==0){
            reccoUserRepository.save(user);
        }
        else if(reccoUserRepository.findById(user.getUserId()).isEmpty()){
            reccoUserRepository.save(user);
        }
        else {
            Optional<ReccoUser> userClass = reccoUserRepository.findById(user.getUserId());
            List<String> giflist = new ArrayList<>();
            giflist = userClass.get().getreccomendations();
            giflist.addAll(user.getreccomendations());
            ReccoUser userInsert = new ReccoUser(user.getUserId(), giflist);
            ReccoUser checkUser = reccoUserRepository.save(userInsert);
        }
        return true;

    }
}
