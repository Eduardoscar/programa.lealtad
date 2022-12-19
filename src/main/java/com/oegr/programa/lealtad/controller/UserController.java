package com.oegr.programa.lealtad.controller;

import com.oegr.programa.lealtad.dto.UserDTO;
import com.oegr.programa.lealtad.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        log.info("Endpoint:/users - Method: GET ");
        List<UserDTO> response = service.findAll();
        log.info("Endpoint:/users - Method: GET - Status: {}", HttpStatus.OK.value());
        return response;
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") long id) throws Exception {
        log.info("Endpoint:/users/{} - Method: GET ", id);
        UserDTO response = service.findById(id);
        log.info("Endpoint:/users/{} - Method: GET - Status: {}", id, HttpStatus.OK.value());
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody UserDTO data) {
        log.info("Endpoint:/users - Method: POST");
        UserDTO response = service.save(data);
        log.info("Endpoint:/users - Method: POST - Status: {}", HttpStatus.OK.value());
        return response;
    }

    @PatchMapping("/{id}")
    public UserDTO update(@PathVariable("id") long id, @RequestBody UserDTO data) throws Exception {
        log.info("Endpoint:/users/{} - Method: PATCH ", id);
        UserDTO response = service.update(id, data);
        log.info("Endpoint:/users/{} - Method: PATCH - Status: {} ", id, HttpStatus.OK.value());
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception {
        log.info("Endpoint:/users/{} - Method: DELETE ", id);
        service.delete(id);
        log.info("Endpoint:/users/{} - Method: DELETE - Status: {}", id, HttpStatus.NO_CONTENT.value());
    }

}
