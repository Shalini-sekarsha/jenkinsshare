package com.demo.sharemarket.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.sharemarket.modal.Admin;
import com.demo.sharemarket.repository.AdminRepo;
import com.demo.sharemarket.service.AdminService;



@Service
@Transactional
public class AdminServiceImpl implements AdminService {
 
	@Autowired
	AdminRepo admindao;
 
	@Override
	public Admin newAdmin(Admin newAdmin) {
		return admindao.newAdmin(newAdmin);
	}
 
	@Override
	public List<Admin> getAdmins() {
 
		return admindao.getAdmins();
 
	}
 
	@Override
	public Admin adminfind(int adminId) {
		return admindao.adminfind(adminId);
	}
 
	@Override
	public List<Integer> getAdminIdList() {
		return admindao.getAdminIdList();
	}
 
	@Override
	public Admin updateAdmin(Admin admin) {
		return admindao.updateAdmin(admin);
	}
 
	
	public Admin adminLogin(String adminname, String adminpassword) {
		return admindao.AdminLogin(adminname, adminpassword);
	}
	@Override
	public Admin findByadminname(String adminname) {
		return admindao.findByadminname(adminname);
	}
}
