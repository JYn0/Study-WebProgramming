package com.product;

import java.util.ArrayList;

import com.frame.Biz;
import com.vo.Product;

public class ProductsGetAll {

	public static void main(String[] args) {
		Biz<Integer, Product> biz = new ProductBiz();
		ArrayList<Product> userr = new ArrayList<Product>();
		try {
			userr = biz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
