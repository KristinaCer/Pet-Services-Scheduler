package com.kristina.dogsrestapi.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRole {
    @Id
    @GeneratedValue
    private Long id;
    private String roleName;
    @ManyToMany
    private Collection<Privilege> privileges;
}
