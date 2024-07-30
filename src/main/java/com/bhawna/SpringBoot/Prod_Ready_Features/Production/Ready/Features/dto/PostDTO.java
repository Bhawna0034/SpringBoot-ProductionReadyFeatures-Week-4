package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id;
    private String title;
    private String description;
}
