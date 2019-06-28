package com.user;

import com.frame.Biz;
import com.vo.User;

public class UserInsert {

	public static void main(String[] args) {
		
		User u1 = new User("id10", "jame", "pwd01");
		Biz<String, User> biz = new UserBiz();
		try {
			biz.register(u1);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
