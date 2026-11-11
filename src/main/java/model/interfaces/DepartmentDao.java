package model.interfaces;

import model.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer obj);
    void findById(Integer obj);
    List<Department> findAll();

}
