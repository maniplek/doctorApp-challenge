package domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public abstract User {
//    private String firstname = "glu";
    public String lastname;
    private int age;
    private Gender gender;

}
