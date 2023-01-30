package com.oegr.programa.lealtad.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.oegr.programa.lealtad.entity.views.UserView;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    @JsonView(UserView.Private.class)
    private long id;

    @JsonView(UserView.Public.class)
    private String name;
    @JsonView(UserView.Public.class)
    private String paternalSurname;
    @JsonView(UserView.Public.class)
    private String maternalSurname;
    @JsonView(UserView.Public.class)
    private String email;

    @JsonView(UserView.Private.class)
    private String role;

    @JsonView(UserView.Private.class)
    private String password;

    @JsonView(UserView.Private.class)
    private Date createdAt;

    @JsonView(UserView.Private.class)
    private Date updatedAt;

}
