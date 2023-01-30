package com.oegr.programa.lealtad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.oegr.programa.lealtad.entity.views.UserView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    @Column(name = "paternal_surname", nullable = false)
    @NotEmpty(message = "El apellido paterno no puede estar vacío")
    private String paternalSurname;

    @Column(name = "maternal_surname", nullable = false)
    @NotEmpty(message = "El apellido materno no puede estar vacío")
    private String maternalSurname;

    @Column(name = "email", nullable = false)
    @Email(message = "Ingresa un email valido")
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany
    @JoinColumn(name = "reward_id")
    Set<Reward> rewards;

}
