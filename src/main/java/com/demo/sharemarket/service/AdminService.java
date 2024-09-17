package com.demo.sharemarket.service;



import com.demo.sharemarket.modal.Admin;


import java.util.List;



 
 
public interface AdminService {
 
 
		public Admin newAdmin(Admin newAdmin);
 
		public List<Admin> getAdmins();
 
		public Admin adminfind(int adminid);
 
		public List<Integer> getAdminIdList();
 
		public Admin updateAdmin(Admin admin);
 
		public Admin adminLogin(String adminname, String adminpassword);
		public Admin findByadminname(String adminname);
	}
