package com.oegr.programa.lealtad.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RewardDTO {
    private long id;
    private int points;
    private Date createdAt;
    private UserDTO user;
}
