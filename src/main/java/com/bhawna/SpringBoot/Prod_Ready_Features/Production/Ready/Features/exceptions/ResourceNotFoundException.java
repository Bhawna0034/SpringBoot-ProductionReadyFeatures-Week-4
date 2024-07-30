package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
