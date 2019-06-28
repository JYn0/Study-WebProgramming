package com.product;

import com.frame.Biz;
import com.vo.Product;

public class ProductsModify {

	public static void main(String[] args) {
		Product p= new Product(1, "NAME0", 10000, null, "IMGNAME0");
		Biz<Integer,Product> biz = new ProductBiz();
		
		try {
			biz.modify(p);
			System.out.println("Products Upadated");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
