package com.product;

import com.frame.Biz;
import com.vo.Product;

public class ProductsGet {

	public static void main(String[] args) {
		Biz<Integer, Product> biz = new ProductBiz();
		
		try {
			biz.get(1);
			System.out.println("Products Selected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
