package dev.saivinay.employeepayrollmanagementsystem.service;

import dev.saivinay.employeepayrollmanagementsystem.model.Employee;
import dev.saivinay.employeepayrollmanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService() {

    }

    public EmployeeRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee e1) {
        this.repository.save(e1);
    }

    public void deleteEmployeeById(int id){
        this.repository.deleteById(id);
    }

    public Employee getEmployeeById(int id){
        return this.repository.findById(id);
    }

    public List<Employee> getEmployees() {
        return this.repository.findAll();
    }

    public Employee getHighestPaidEmployee() {
        return this.repository.findMaxBySalary();
    }

    public void updateEmployeeSalary(int eid, float salary) {
        this.repository.updateSalary(eid, salary);
    }

    public void updateEmployeeName(int eid, String uname) {
        this.repository.updateName(eid, uname);
    }

    public void updateEmployeeDepartment(int eid, String udept) {
        this.repository.updateDepartment(eid, udept);
    }

    public void updateEmployeeDesignation(int eid, String udesignation) {
        this.repository.updateDesignation(eid, udesignation);
    }

    public void updateEmployeeDoj(int eid, LocalDate doj) {
        this.repository.updateDOJ(eid, doj);
    }
}
