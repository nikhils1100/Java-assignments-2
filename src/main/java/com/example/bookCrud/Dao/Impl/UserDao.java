package com.example.bookCrud.Dao.Impl;

import com.example.bookCrud.Dao.Generics.AbstractHibernateDao;
import com.example.bookCrud.Dao.IUserDao;
import com.example.bookCrud.Model.Book;
import com.example.bookCrud.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractHibernateDao<User>  implements IUserDao {
    public UserDao(){
        super();
        setClazz(User.class);
    }
}
