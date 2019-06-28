package com.product;

import com.frame.Biz;
import com.vo.Product;

public class ProductsRemove {

	public static void main(String[] args) {
		Biz<Integer, Product> biz = new ProductBiz();
		
		try {
			biz.remove(1);
			System.out.println("User Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
