package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.clients;


import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long employeeId);
    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
