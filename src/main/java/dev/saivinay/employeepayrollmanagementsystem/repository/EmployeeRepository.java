package dev.saivinay.employeepayrollmanagementsystem.repository;

import dev.saivinay.employeepayrollmanagementsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeRepository {
    private JdbcTemplate template;

    public EmployeeRepository() {
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Employee e1){
        String sql = "INSERT INTO Employee (ename, department, designation, salary, doj) values (?, ?, ?, ?, ?)";
        int rows = template.update(sql, e1.getEname(), e1.getDepartment(), e1.getDesignation(), e1.getSalary(), e1.getDoj());
        System.out.println(rows==0?"Something went wrong":"Successfully added the Employee record to DB");
    }

    public void deleteById(int eid){
        String sql = "DELETE FROM Employee WHERE eid = ?";
        int rows = template.update(sql, eid);
        System.out.println(rows==0?"Something went wrong":"Successfully deleted the employee with the id "+eid);
    }

    public List<Employee> findAll(){
        String sql = "SELECT * FROM Employee";
        return template.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee e1 = new Employee();
                e1.setEid(rs.getInt(1));
                e1.setEname(rs.getString(2));
                e1.setDepartment(rs.getString(3));
                e1.setDesignation(rs.getString(4));
                e1.setSalary(rs.getFloat(5));
                e1.setDoj(rs.getDate(6).toLocalDate());
                return e1;
            }
        });
    }

    public Employee findById(int eid){
        String sql = "SELECT * FROM Employee where eid=?";
        return template.query(sql, (rs, rowNum) -> {
                Employee e1 = new Employee();
                e1.setEid(rs.getInt(1));
                e1.setEname(rs.getString(2));
                e1.setDepartment(rs.getString(3));
                e1.setDesignation(rs.getString(4));
                e1.setSalary(rs.getFloat(5));
                e1.setDoj(rs.getDate(6).toLocalDate());
                return e1;
        }, eid).get(0);
    }

    public Employee findMaxBySalary() {
        String sql = "SELECT * FROM Employee ORDER BY salary DESC LIMIT 1";
        return template.query(sql, (rs, rowNum)->{
            Employee e1 = new Employee();
            e1.setEid(rs.getInt(1));
            e1.setEname(rs.getString(2));
            e1.setDepartment(rs.getString(3));
            e1.setDesignation(rs.getString(4));
            e1.setSalary(rs.getFloat(5));
            e1.setDoj(rs.getDate(6).toLocalDate());
            return e1;
        }).get(0);
    }

    public void updateSalary(int eid, float salary){
        String sql = "UPDATE Employee SET salary = ? WHERE eid=?";
        int rows = template.update(sql, salary, eid);
        System.out.println(rows==0?"Something went wrong":"Updated the employeeSalary");
    }

    public void updateName(int eid, String uname) {
        String sql = "UPDATE Employee SET ename = ? WHERE eid = ?";
        int rows = template.update(sql, uname, eid);
        System.out.println(rows==0?"Something went wrong":"Updated the Employee Name");
    }

    public void updateDepartment(int eid, String udept) {
        String sql = "UPDATE Employee SET department = ? WHERE eid = ?";
        int rows = template.update(sql, udept, eid);
        System.out.println(rows==0?"Something went wrong":"Updated the Employee Department");
    }

    public void updateDesignation(int eid, String udesignation) {
        String sql = "UPDATE Employee SET designation = ? WHERE eid = ?";
        int rows = template.update(sql, udesignation, eid);
        System.out.println(rows==0?"Something went wrong":"Updated the Employee Designation");
    }

    public void updateDOJ(int eid, LocalDate doj) {
        String sql = "UPDATE Employee SET doj = ? WHERE eid = ?";
        int rows = template.update(sql, doj, eid);
        System.out.println(rows==0?"Something went wrong":"Updated the Employee DOJ");
    }
}
