package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Bhawna Sharma");
    }
}
