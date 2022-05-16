package com.kristina.dogsrestapi.employee.model;

import com.kristina.dogsrestapi.user.model.User;
import com.kristina.dogsrestapi.user.model.UserRole;

public final class EmployeeConverter {

    public static Employee convertToEntity(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        User user = new User();
        user.setUserRole(UserRole.EMPLOYEE);
        user.setName(employeeDTO.getName());
        user.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setDaysAvailable(employeeDTO.getDaysAvailable());
        employee.setSkills(employeeDTO.getSkills());
        employee.setUser(user);
        return employee;
    }

    public static EmployeeDTO convertToDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getUser().getName());
        employeeDTO.setPhoneNumber(employee.getUser().getPhoneNumber());
        employeeDTO.setSkills(employee.getSkills());
        employeeDTO.setDaysAvailable(employee.getDaysAvailable());
        return employeeDTO;
    }
}
