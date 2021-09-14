package com.willy.restCRUD.dao;

import com.willy.restCRUD.dto.UserDto;
import com.willy.restCRUD.entity.User;
import com.willy.restCRUD.entity.UserProfile;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrudDaoImpl implements CrudDao{
  private static final Logger LOG = LoggerFactory.getLogger(CrudDaoImpl.class);
  private EntityManager em;

  @Autowired
  public CrudDaoImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<User> getUsers() {
    return null;
  }

  @Override
  @Transactional
  public User saveUser(UserDto userDto) {
    // TODO
    Session session = em.unwrap(Session.class);
    User user = userDto.getUser();
    UserProfile userProfile = userDto.getUserProfile();

    user.setUserProfile(userProfile);
    userProfile.setUser(user);
    session.persist(userProfile);
    return user;
  }

  @Override
  public User getUserById(int id) {
    Session session = em.unwrap(Session.class);
    User user = session.get(User.class, id);
    LOG.info("USER: " + user + "\n PROFILE: " + user.getUserProfile());
    return user;
  }

  @Override
  public void deleteUserById(int id) {
    Session session = em.unwrap(Session.class);
    session.delete(session.get(User.class, id));
    return;
  }
}
