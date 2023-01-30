package com.oegr.programa.lealtad.service;

import com.oegr.programa.lealtad.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO findById(long id);
    UserDTO save(UserDTO data);
    UserDTO update(long id,UserDTO data);
    void delete(long id);

}
