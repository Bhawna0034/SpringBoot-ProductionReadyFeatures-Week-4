package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features;

import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.clients.EmployeeClient;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductionReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	@Order(3)
	void getAllEmployeesTest(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	@Order(2)
	void getEmployeedByIdTest() {
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(19L);
		System.out.println(employeeDTO);
	}

	@Test
	@Order(1)
	void createNewEmployeeTest(){
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Bhawna", "bhawnaasharma@gmail.com",22, "ADMIN", LocalDate.of(2024, 1, 3),true);
		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}
}
