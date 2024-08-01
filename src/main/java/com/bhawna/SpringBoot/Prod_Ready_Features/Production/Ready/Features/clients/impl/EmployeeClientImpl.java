package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.clients.impl;

import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.advices.ApiResponse;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.clients.EmployeeClient;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto.EmployeeDTO;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        logger.trace("Retrieve list of all employees");

//        logger.error("error");
//        logger.warn("warn");
//        logger.info("info");
//        logger.debug("debug");
//        logger.trace("trace");
        try {
            logger.info("Attempting to retrieve all the employees");
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        logger.error(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not get all the employee");
                    }))
                    .body(new ParameterizedTypeReference<>() {
                    });

            logger.debug("Successfully retrieve all the employees");
            logger.trace("Retrieved list of all employees: {}", employeeDTOList.getData());
            return employeeDTOList.getData();
        } catch (Exception e) {
            logger.error("Exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {

        logger.trace("Retrieve employee by id: {}", employeeId);
        try{
            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        logger.error(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not get the employee");
                    }))
                    .body(new ParameterizedTypeReference<>() {
                    });
            return  employeeResponse.getData();
        }catch (Exception e) {
            logger.error("Exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        logger.trace("Create new employee with information: {}", employeeDTO);
        try{
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        logger.debug("4xxClient Error occurred during create new employee");
                        logger.error(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not create the employee");
                    }))
                    .toEntity(new ParameterizedTypeReference<>() {
                    });

            logger.trace("Successfully create new employees: {}", employeeDTOApiResponse.getBody());
            return employeeDTOApiResponse.getBody().getData();
        }catch (Exception e){
            logger.error("Exception occurred", e);
            throw new RuntimeException(e);
        }
    }

}
