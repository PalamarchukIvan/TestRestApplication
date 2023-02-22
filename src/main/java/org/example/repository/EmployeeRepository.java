package org.example.repository;

import org.example.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//описывает работу с БД
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where e.name = :name")
    List<Employee> findEmployeesByName(String name);

    @Query("select e from Employee e")//запрос
    List<Employee> findAll();
}
