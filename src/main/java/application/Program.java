package application;


import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.interfaces.SellerDao;

import java.util.Date;

public class Program {
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(2);

		System.out.println(seller);
	}

}
