package lk.ac.kln.employeeManager.service;

import lk.ac.kln.employeeManager.exception.UserNotFoundException;
import lk.ac.kln.employeeManager.model.Employee;
import lk.ac.kln.employeeManager.repositorary.EmployeeRepository;
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
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).
                orElseThrow(()-> new UserNotFoundException("User by id " + id + "not found"));
    }

     public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }

}
