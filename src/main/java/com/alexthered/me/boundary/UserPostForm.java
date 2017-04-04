package com.alexthered.me.boundary;

import com.alexthered.me.domain.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by hd on 04.04.17.
 */
@Data
public class UserPostForm {

    @NotNull(message = "Email cannot be empty")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
    message = "The email is not valid")
    String email;

    @NotNull(message = "First name cannot be empty")
    String firstName;

    @NotNull(message = "Last name cannot be empty")
    String lastName;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 5, message = "Password length must be at least 5")
    String password;

    public User buildUser(){
        return User.builder().firstName(firstName)
                .lastName(lastName).email(email).password(password).build();
    }
}
