package org.example.service;

import org.example.domain.Employee;

import java.util.Comparator;
import java.util.List;

public interface EmployeeService {//Интерфейс главного бина. на нем он строится
    Employee create(Employee employee);
    List<Employee> getAll();
    List<Employee> get(String name);
    Employee get(Integer id);
    void delete(String name);
    void delete(Integer id);
    void dropDataBase();
    List<Employee> showEmployeeSorted(Comparator<Employee> comparator);
}
