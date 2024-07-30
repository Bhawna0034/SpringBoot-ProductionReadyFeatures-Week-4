package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigs {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
