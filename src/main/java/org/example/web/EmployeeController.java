package org.example.web;

import lombok.AllArgsConstructor;
import org.example.domain.Employee;
import org.example.service.EmployeeServiceBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)//все запросы стартуют с /api
@AllArgsConstructor
public class EmployeeController {//описывает взаимодействие с сервером. посылает запросы
    private final EmployeeServiceBean serviceBean;

    @PostMapping("/employee")//Значит у нас режим Post
    @ResponseStatus(HttpStatus.CREATED)//хз
    public Employee create(@RequestBody Employee employee) { //@RequestBody означает -
        return serviceBean.create(employee);
    }
    @GetMapping("/employee/{id}")//Значит у нас режим GET
    @ResponseStatus(HttpStatus.OK)
    public Employee get(@PathVariable Integer id) { //@RequestBody означает, что мы берем переменную из пути
        return serviceBean.get(id);
    }
    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Employee> get(@RequestParam(name = "name") String name){ //@RequestParam означает, что мы берем имя из пути
        return serviceBean.get(name);
    }

    @GetMapping("/employee/show")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Employee> get(){
        return serviceBean.getAll();
    }

//    TODO
//    @PostMapping("/employees/sort/{comparator}")
//    @ResponseStatus(HttpStatus.OK)
//    public Collection<Employee> showSortedEmployees(@RequestBody Comparator<Employee> comparator) {
//        return serviceBean.showEmployeeSorted(comparator);
//    }

    @DeleteMapping("/employee/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        serviceBean.delete(id);
    }
    @DeleteMapping("/employee/delete")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@RequestParam(name = "name") String name) {
        serviceBean.delete(name);
    }

    @DeleteMapping("/drop_data_base")
    @ResponseStatus(HttpStatus.OK)
    public void dropDataBase(){
        serviceBean.dropDataBase();
    }
}
