package model.dao;

import model.interfaces.SellerDao;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
