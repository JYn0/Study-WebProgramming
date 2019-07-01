package com.user;

import com.frame.Biz;
import com.vo.User;

public class UserGet {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();
		
		try {
			biz.get("id10");
			System.out.println("User Selected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
