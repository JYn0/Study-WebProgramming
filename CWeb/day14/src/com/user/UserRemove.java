package com.user;

import com.frame.Biz;
import com.vo.User;

public class UserRemove {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();	
		
		try {
			biz.remove("id69");
			System.out.println("User Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
