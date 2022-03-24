package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean enabled;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long LastUpdatedUserId, String firstName, String lastName, String userName, String password, String phoneNumber, boolean enabled, Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, LastUpdatedUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.role = role;
        this.gender = gender;
    }


}
