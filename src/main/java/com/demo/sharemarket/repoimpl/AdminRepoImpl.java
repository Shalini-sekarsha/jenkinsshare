package com.demo.sharemarket.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.sharemarket.modal.Admin;
import com.demo.sharemarket.repository.AdminRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class AdminRepoImpl implements AdminRepo {

	@Autowired
	EntityManager entityMan;

	public Admin newAdmin(Admin newAdmin) {
		entityMan.persist(newAdmin);
		return newAdmin;
	}

	@SuppressWarnings("unchecked")

	public List<Admin> getAdmins() {
		return entityMan.createQuery("from Admin").getResultList();
	}

	public Admin adminfind(int adminId) {
		return entityMan.find(Admin.class, adminId);
	}

	

	public Admin updateAdmin(Admin admin) {
		entityMan.merge(admin);
		return admin;
	}

	

	public List<Integer> getAdminIdList() {
		Query q = entityMan.createQuery("SELECT c.adminId FROM Admin");
		return q.getResultList();
	}

	public Admin AdminLogin(String adminname, String adminpassword) {
		Query query1 = entityMan.createQuery("from Admin u where u.adminname =?1 and u.adminpassword=?2");
		query1.setParameter(1, adminname);
		query1.setParameter(2, adminpassword);

		return (Admin) query1.getSingleResult();

	}
	@Override
	public Admin findByadminname(String adminname) {
		 String jpql = "SELECT u FROM Admin u WHERE u.adminname = :adminname";
		    TypedQuery<Admin> query = entityMan.createQuery(jpql, Admin.class);
		    query.setParameter("adminname", adminname);
		    
		    try {
		        return query.getSingleResult();
		    } catch (NoResultException | NonUniqueResultException e) {
		        return null;
		    }
	}

	
}
