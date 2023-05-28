package com.revature.eMarket.utils.custom_exeptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException() {
        super("\nRole not found");
    }
}