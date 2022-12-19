package com.oegr.programa.lealtad.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private long id;
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String email;
    private Date createdAt;
    private Date updatedAt;
}
