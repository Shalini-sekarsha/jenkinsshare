package com.demo.sharemarket.repoimpl;


 

 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.sharemarket.modal.User;
import com.demo.sharemarket.repository.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
 
@Repository
public class UserRepoImpl implements UserRepo {
 
	@Autowired
	EntityManager entityMan;
 
	public User insertUser(User newUser) {
		entityMan.merge(newUser);
		return newUser;
	}

	@Override
	public User updateUser(User user) {
		entityMan.merge(user);
		return user;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return entityMan.createQuery("from User").getResultList();
 
	}
 
	@Override
	public User userfind(int userId) {
		return entityMan.find(User.class, userId);
 
	}
 
	@Override
	public User findUserByUserEmail(String userEmail) {
		return entityMan.find(User.class, userEmail);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getUserIdlist() {
		Query q = entityMan.createQuery("SELECT c.userId FROM User c");
		return q.getResultList();
 
	}
 
	@SuppressWarnings("unchecked")
	public List<User> searchUser(String userName) {
		Query qry2 = entityMan.createQuery("from User u where u.userName=?1");
		qry2.setParameter(1, userName);
		return qry2.getResultList();
	}
	public User userLogin(String userEmail, String userPassword) {
	    Query query = entityMan.createQuery("from User u where u.userEmail = :userEmail and u.userPassword = :userPassword");
	    query.setParameter("userEmail", userEmail);
	    query.setParameter("userPassword", userPassword);
	    List<User> results = query.getResultList();
	    if (results.isEmpty()) {
	        return null; 
	    }
	    return results.get(0); 
	}
	@Override
	public User findByuserName(String userEmail) {
		 String jpql = "SELECT u FROM User u WHERE u.userEmail = :userEmail";
		    TypedQuery<User> query = entityMan.createQuery(jpql, User.class);
		    query.setParameter("userEmail", userEmail);
		    
		    try {
		        return query.getSingleResult();
		    } catch (NoResultException | NonUniqueResultException e) {
		        return null;
		    }
	}

	@Override
	public User getCurrentUser() {
		return null;
	}
	

	

}
