package com.demo.sharemarket.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.demo.sharemarket.modal.Admin;
import com.demo.sharemarket.service.AdminService;


import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {



 
		@Autowired
		AdminService adminservice;
 
	    
		
		@PostMapping("/doadmininsert")
		public Admin insertAdmin(@RequestBody Admin newAdmin) {
			return adminservice.newAdmin(newAdmin);
 
		}
 
		@PutMapping("/updateadmin")
		public Admin updateAdmin(@RequestBody Admin admin) {
 
			return adminservice.updateAdmin(admin);
		}
 
		
		@GetMapping("/getallAdminList")
		public List<Admin> getAdmins() {
			return adminservice.getAdmins();
		}
 
		
		@GetMapping("/getadminid/{adminId}")
		public Admin appfind(@PathVariable("adminId") int adminId) {
			return adminservice.adminfind(adminId);
		}
 
		@GetMapping("/loginadmin/{adminname}/{adminpassword}")
		public boolean loginadmin(@PathVariable("adminname") String adminname,
				@PathVariable("adminpassword") String adminpassword) {
			
//			Admin existingAdmin = adminservice.findByadminname(adminname);
			try {
				adminservice.adminLogin(adminname, adminpassword);
//				if (existingAdmin != null && adminPassword.equals(existingAdmin.getAdminpassword())) {
					return true;
//				} else {
//					return false;
//				}
			} catch (Exception e) {
				return false;
			}
		}
}

