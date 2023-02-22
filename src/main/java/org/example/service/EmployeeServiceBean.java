package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeServiceBean implements EmployeeService{//Описывает функционал работы прилложения. Отвечает за логику
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> get(String name) {
        return employeeRepository.findEmployeesByName("name");
    }

    @Override
    public Employee get(Integer id) {
        return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void delete(String name) {
        List<Employee> listForDelete = employeeRepository.findEmployeesByName(name);
        employeeRepository.deleteAll(listForDelete);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.delete(employeeRepository.getById(id));
    }

    @Override
    public void dropDataBase() {
        employeeRepository.deleteAll();
    }

    @Override
    public List<Employee> showEmployeeSorted(Comparator<Employee> comparator) {
        List<Employee> sortedList = employeeRepository.findAll();
        sortedList.sort(comparator);
        return sortedList;
    }

}
