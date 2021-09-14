package com.willy.restCRUD.repository;

import com.willy.restCRUD.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  private EntityManager em;

  @Autowired
  public UserDaoImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<User> getAllUsers() {
    TypedQuery<User> myQuery = em.createQuery("from User", User.class);
    return myQuery.getResultList();
  }

  @Override
  public User getSingleUserById(int id) {
    return em.find(User.class, id);
  }

  @Override
  public User saveSingleUser(User user) {
    em.persist(user);
    return user;
  }


  @Override
  public void deleteSingleUserById(int id) {
    em.remove(em.find(User.class, id));
  }


  @Override
  public User updateSingleUser(User user) {
    return em.merge(user);
  }
}
