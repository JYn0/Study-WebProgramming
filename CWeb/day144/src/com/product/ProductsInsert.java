package com.product;

import com.frame.Biz;
import com.vo.Product;

public class ProductsInsert {

	public static void main(String[] args) {
		Product p1 = new Product(1, "NAME1", 10000, null, "IMGNAME");
		Biz<Integer, Product> biz = new ProductBiz();
		try {
			biz.register(p1);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
