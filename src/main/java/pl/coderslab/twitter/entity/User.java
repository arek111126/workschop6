package pl.coderslab.twitter.entity;


import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.twitter.validation.LoginValidationGroup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.groups.Default;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(groups = {Default.class})
    private String firstName;

    @NotEmpty(groups = {Default.class})
    private String lastName;

    @NotEmpty(groups = {Default.class, LoginValidationGroup.class})
    private String password;

    @NotEmpty(groups = {Default.class, LoginValidationGroup.class})
    @Email(groups = {Default.class, LoginValidationGroup.class})
    private String email;


}
