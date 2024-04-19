package com.example.demo.pojo;

import lombok.Data;

/**
 * User class represents a user with an id, username, and email.
 *
 * @author Tabnine
 */
@Data
public class User {
    /**
     * The unique identifier for the user.
     */
    private Long id;

    /**
     * The username of the user.
     */
    private String name;

    /**
     * The email address of the user.
     */
    private String email;
}
