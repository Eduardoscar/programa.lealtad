package com.oegr.programa.lealtad.service;

import com.oegr.programa.lealtad.dto.RewardDTO;

import java.util.List;

public interface RewardService {

    List<RewardDTO> findAll();
    RewardDTO findById(long id);
    RewardDTO save(RewardDTO data);
    void delete(long id) throws Exception;
}
