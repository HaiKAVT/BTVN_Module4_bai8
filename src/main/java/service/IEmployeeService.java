package service;

import model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee>{
    Page<Employee> findAll(Pageable pageable);
}
