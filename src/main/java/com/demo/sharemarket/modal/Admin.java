package com.demo.sharemarket.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    private String adminname;
    private String adminpassword;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String adminname, String adminpassword) {
		super();
		this.adminId = adminId;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminid(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminId + ", adminname=" + adminname + ", adminpassword=" + adminpassword + "]";
	}
    
}
	