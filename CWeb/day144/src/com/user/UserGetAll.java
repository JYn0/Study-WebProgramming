package com.user;

import java.util.ArrayList;

import com.frame.Biz;
import com.vo.User;

public class UserGetAll {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();
		ArrayList<User> userr = new ArrayList<User>();
		try {
			userr = biz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
