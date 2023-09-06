package com.simba68.sbusersservices.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role", schema = "sbmaster")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String description;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "user_id", referencedColumnName = "numb")
//    private User user;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Role education = (Role) o;
//        return Objects.equals(id, education.id) &&
//                Objects.equals(roleName, education.roleName) &&
//                Objects.equals(description, education.description) &&
//                Objects.equals(userId, education.userId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, roleName, description, userId);
//    }
}
