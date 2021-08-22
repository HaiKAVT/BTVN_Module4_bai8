package service;

import model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IBranchRepository;

import java.util.Optional;

@Service
public class BranchService implements IBranchService {
    @Autowired
    IBranchRepository branchRepository;

    @Override
    public Iterable<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> findById(Integer id) {
        return branchRepository.findById(id);
    }

    @Override
    public void save(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public void delete(Integer id) {
        branchRepository.deleteById(id);
    }
}
