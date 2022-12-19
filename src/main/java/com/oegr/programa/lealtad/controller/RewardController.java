package com.oegr.programa.lealtad.controller;

import com.oegr.programa.lealtad.dto.RewardDTO;
import com.oegr.programa.lealtad.service.RewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService service;

    @Autowired
    public RewardController(RewardService service) {
        this.service = service;
    }

    @PostMapping
    public RewardDTO create(@RequestBody RewardDTO data) throws Exception {
        log.info("Endpoint:/rewards - Method: POST");
        RewardDTO response = service.save(data);
        log.info("Endpoint:/rewards - Method: POST - Status: {}", HttpStatus.OK.value());
        return response;
    }

    @GetMapping
    public List<RewardDTO> findAll() {
        log.info("Endpoint:/rewards - Method: GET ");
        List<RewardDTO> response = service.findAll();
        log.info("Endpoint:/rewards - Method: GET - Status: {}", HttpStatus.OK.value());
        return response;
    }

    @GetMapping("/{id}")
    public RewardDTO findById(@PathVariable("id") long id) {
        log.info("Endpoint:/rewards/{} - Method: GET ", id);
        RewardDTO response = service.findById(id);
        log.info("Endpoint:/rewards/{} - Method: GET - Status: {}", id, HttpStatus.OK.value());
        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception {
        log.info("Endpoint:/rewards/{} - Method: DELETE ", id);
        service.delete(id);
        log.info("Endpoint:/rewards/{} - Method: DELETE - Status: {}", id, HttpStatus.NO_CONTENT.value());
    }

}
