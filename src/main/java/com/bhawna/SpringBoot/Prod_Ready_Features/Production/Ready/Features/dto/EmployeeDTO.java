package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto;

import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.annotations.EmployeeRoleValidation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {


    private Long id;
    private String name;
    private String email;
    private Integer age;

    @EmployeeRoleValidation
    private String role;
    private LocalDate dateOfJoining;
    private Boolean isActive;


}
