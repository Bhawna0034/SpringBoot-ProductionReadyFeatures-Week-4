package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.configs;

import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration

@EnableJpaAuditing(auditorAwareRef = "getAuditAwareImpl")
public class MapperConfigs {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAuditAwareImpl(){
        return new AuditorAwareImpl();
    }
}
