package io.delasys.Employee.Manager.App;

import io.delasys.Employee.Manager.App.Service.EmployeeService;
import io.delasys.Employee.Manager.App.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employees = employeeService.findAllEmployee();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {

        Employee employee = employeeService.findEmployeeById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Employee>  addEmployee(@RequestBody Employee employee){
     Employee newEmployee=employeeService.addEmployee(employee);

     return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }


    @PostMapping("/update")
    public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee=employeeService.addEmployee(employee);

        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
