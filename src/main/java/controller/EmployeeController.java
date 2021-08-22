package controller;

import model.Branch;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IBranchService;
import service.IEmployeeService;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IBranchService branchService;

    @ModelAttribute("branches")
    public  Iterable<Branch> branches(){
        return branchService.findAll();
    }

//    @GetMapping("/home")
//    public ModelAndView home(@PageableDefault(sort = "age",direction = Sort.Direction.ASC) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("home");
//        Page<Employee> employees = employeeService.findAll(pageable);
//        modelAndView.addObject("employees", employees);
//        return modelAndView;
//    }

    @GetMapping("home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("employees", employeeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        }
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("redirect:/home");
            return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Employee employee = employeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("edit");
        }
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("redirect:/home");
            return modelAndView;
        }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        Employee employee = employeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute Employee employee) {
        employeeService.delete(employee.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
}
