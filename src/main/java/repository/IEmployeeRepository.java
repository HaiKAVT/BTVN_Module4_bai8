package repository;

import model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}
