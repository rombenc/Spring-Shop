package com.dimas.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(

        String id,

        @NotNull(message = "First Name is required")
        String firstName,

        @NotNull(message = "Last Name is required")
        String lastName,

        @NotNull(message = "Email is required")
        @Email(message = "Enter your valid email address")
        String email,
        Address address
) {

}
