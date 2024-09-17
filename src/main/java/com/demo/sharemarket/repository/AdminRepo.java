package com.demo.sharemarket.repository;
import java.util.List;

import com.demo.sharemarket.modal.Admin;



public interface AdminRepo {
 
	public Admin newAdmin(Admin newAdmin);
 
	public List<Admin> getAdmins();
 
	public Admin adminfind(int adminId);
 
	public List<Integer> getAdminIdList();
 
	public Admin updateAdmin(Admin admin);
 
	public Admin AdminLogin(String adminname, String adminpassword);
	public Admin findByadminname(String adminname);


} 
