package com.oegr.programa.lealtad.mapper;

import com.oegr.programa.lealtad.dto.RewardDTO;
import com.oegr.programa.lealtad.entity.Reward;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RewardMapper {

    RewardDTO toDTO(Reward data);
    Reward toEntity(RewardDTO data);
}
