package com.meli.be_java_hisp_w22_g01.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements IUserRepository{

    private List<User> list_of_users = new ArrayList<>();

    @Override
    public void save(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findById(int user_id) {
        return null;
    }
}
