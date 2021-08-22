package repository;

import model.Branch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBranchRepository extends PagingAndSortingRepository<Branch, Integer> {
}
