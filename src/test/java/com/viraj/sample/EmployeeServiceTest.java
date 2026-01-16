package com.viraj.sample;

import com.viraj.sample.entity.Employee;
import com.viraj.sample.repository.EmployeeRepository;
import com.viraj.sample.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(org.springframework.test.context.junit.jupiter.SpringExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setEmployeeName("Anderson Daniel Cango Samuisa");
    }

    @Test
    public void saveEmployee_shouldReturnSavedEmployee() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee result = employeeService.saveEmployee(employee);
        assertNotNull(result);
        assertEquals("Anderson Daniel Cango Samuisa", result.getEmployeeName());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void updateEmployee_shouldReturnUpdatedEmployee() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee result = employeeService.updateEmployee(employee);
        assertNotNull(result);
        assertEquals(employee.getEmployeeId(), result.getEmployeeId());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void getAllEmployees_shouldReturnListOfEmployees() {
        List<Employee> employees = Arrays.asList(employee, new Employee());
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> result = employeeService.getAllEmployees();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(employeeRepository, times(1)).findAll();
    }
}
