package com.learn.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String category;
}
