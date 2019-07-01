package com.user;

import com.frame.Biz;
import com.vo.User;

public class UserModify {
	
	public static void main(String[] args) {
		User u= new User("id10", "pwd79", "000");
		Biz<String,User> biz = new UserBiz();
		
		try {
			biz.modify(u);
			System.out.println("User Upadated");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
