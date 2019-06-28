package com.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Product;

public class ProductDao extends Dao<Integer, Product> {

	public void insert(Product v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertProduct);
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getImgname());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}
  
	@Override
	public void delete(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.DeleteProduct);
			pstmt.setInt(1, k);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void update(Product v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.UpdateProduct);
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getImgname());
			pstmt.setInt(4, v.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public Product select(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product sp = null;
		try {
			pstmt = con.prepareStatement(Sql.SelectProduct);
			pstmt.setInt(1, k);
			rset = pstmt.executeQuery();
			rset.next();
			int spid = rset.getInt("ID");
			String spname = rset.getString("NAME");
			Double spprice = rset.getDouble("PRICE");
			Date spregdate = rset.getDate("REGDATE");
			String spimgname = rset.getString("IMGNAME");
			sp = new Product(spid, spname, spprice, spregdate, spimgname);
			System.out.println(spid + " " + spname + " " + spprice + " " + spregdate + " " + spimgname);
		} catch (SQLException e) {
			throw e;
		} finally {
			close(pstmt);
		}
		return sp;
	}

	@Override
	public ArrayList<Product> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product sp = null;
		ArrayList<Product> sps = new ArrayList<Product>(); // !! ArrayList �ʱ�ȭ !!

		try {
			pstmt = con.prepareStatement(Sql.SelectAllProduct);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				int spid = rset.getInt("ID");
				String spname = rset.getString("NAME");
				double spprice = rset.getDouble("PRICE");
				Date spdate = rset.getDate("REGDATE");
				String spimgName = rset.getString("IMGNAME");
				sp = new Product(spid, spname, spprice, spdate, spimgName);
				sps.add(sp);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(pstmt);
		}
		return sps;
	}
}
