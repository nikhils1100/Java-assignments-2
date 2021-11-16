package com.example.bookCrud.Dao.Impl;

import com.example.bookCrud.Dao.Generics.AbstractJpaDao;
import com.example.bookCrud.Dao.IUserDao;
import com.example.bookCrud.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public class UserDao extends AbstractJpaDao<User>  implements IUserDao {
    public UserDao(EntityManager em){
        super(em);
        setClazz(User.class);
    }
}
