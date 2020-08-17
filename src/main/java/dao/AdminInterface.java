package dao;

import model.Admin;

public interface AdminInterface {
	
	int signUp(Admin admin);
	boolean loginAdmin(Admin admin);

}
