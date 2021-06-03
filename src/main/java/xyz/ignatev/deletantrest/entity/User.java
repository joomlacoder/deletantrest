package xyz.ignatev.deletantrest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Data
@Entity
public class User {
    @Id
    @Email
    private String email;
    private String activationCode;
}
