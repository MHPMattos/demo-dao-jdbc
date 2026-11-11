package model.dao;

import database.DataBase;
import model.interfaces.SellerDao;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DataBase.getConnection());
    }
}
