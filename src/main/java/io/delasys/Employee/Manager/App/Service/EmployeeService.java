package io.delasys.Employee.Manager.App.Service;

import io.delasys.Employee.Manager.App.Repository.EmployeeRepository;
import io.delasys.Employee.Manager.App.exception.UserNotFoundException;
import io.delasys.Employee.Manager.App.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return  employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

  public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow( ()->new UserNotFoundException ("User by ID "+id +"was not found") );
  }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }




}
