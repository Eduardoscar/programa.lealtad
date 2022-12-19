package com.oegr.programa.lealtad.service.impl;

import com.oegr.programa.lealtad.dto.RewardDTO;
import com.oegr.programa.lealtad.dto.UserDTO;
import com.oegr.programa.lealtad.entity.Reward;
import com.oegr.programa.lealtad.exceptionmapper.NotFoundExceptionMapper;
import com.oegr.programa.lealtad.mapper.RewardMapper;
import com.oegr.programa.lealtad.repository.RewardRepository;
import com.oegr.programa.lealtad.service.RewardService;
import com.oegr.programa.lealtad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RewardServiceImpl implements RewardService {

    private final RewardMapper mapper;
    private final RewardRepository repository;
    private final UserService userService;

    @Autowired
    public RewardServiceImpl(RewardMapper mapper, RewardRepository repository, UserService userService) {
        this.mapper = mapper;
        this.repository = repository;
        this.userService = userService;
    }

    public List<RewardDTO> findAll() {
        List<Reward> rewards = repository.findAll();
        return rewards.stream().map(mapper::toDTO).toList();
    }

    public RewardDTO findById(long id) {
        Optional<Reward> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundExceptionMapper("No existe el id: " + id + " de la recompensa");
        }
        return mapper.toDTO(result.get());
    }

    public RewardDTO save(RewardDTO data) {
        if (data.getUser().getId() != 0) {
            UserDTO user = userService.findById(data.getUser().getId());
            data.setUser(user);
        }
        Reward entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    public void delete(long id) {
        Optional<Reward> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundExceptionMapper("No existe el id: " + id + " de la recompensa");
        }
        repository.deleteById(id);
    }
}
