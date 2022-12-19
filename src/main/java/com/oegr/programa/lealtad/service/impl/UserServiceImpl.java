package com.oegr.programa.lealtad.service.impl;

import com.oegr.programa.lealtad.dto.UserDTO;
import com.oegr.programa.lealtad.entity.User;
import com.oegr.programa.lealtad.exceptionmapper.BadRequestExceptionMapper;
import com.oegr.programa.lealtad.exceptionmapper.NotFoundExceptionMapper;
import com.oegr.programa.lealtad.mapper.UserMapper;
import com.oegr.programa.lealtad.model.Email;
import com.oegr.programa.lealtad.repository.UserRepository;
import com.oegr.programa.lealtad.service.EmailService;
import com.oegr.programa.lealtad.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private Pattern pattern = Pattern.compile("^[\\S]+@[\\S]+\\.[\\S]+$");
    private UserMapper mapper;
    private UserRepository repository;
    private EmailService emailService;

    @Autowired
    public UserServiceImpl(UserMapper mapper, UserRepository repository, EmailService emailService) {
        this.mapper = mapper;
        this.repository = repository;
        this.emailService = emailService;
    }

    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream().map(mapper::toDTO).toList();
    }

    public UserDTO findById(long id) {
        Optional<User> result = repository.findOneById(id);
        if (result.isEmpty()) {
            throw new NotFoundExceptionMapper("No existe el id: " + id + " en usuarios");
        }
        return mapper.toDTO(result.get());
    }

    public UserDTO save(UserDTO data) {
        User entity = mapper.toEntity(data);
        log.info(data.getEmail());
        Matcher matcher = pattern.matcher(data.getEmail());
        if (!matcher.find()){
            throw new BadRequestExceptionMapper("Email inválido");}
        emailService.sendEmail(new Email("Bienvenido al Programa de Leatad", entity.getEmail(), "Bienvenido"));
        return mapper.toDTO(repository.save(entity));
    }

    public UserDTO update(long id, UserDTO data) {
        Optional<User> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundExceptionMapper("No existe el id: " + id + " en usuarios");
        }

        User user = result.get();

        if (!Objects.isNull(data.getName())) {
            user.setName(data.getName());
        }
        if (!Objects.isNull(data.getPaternalSurname())) {
            user.setPaternalSurname(data.getPaternalSurname());
        }
        if (!Objects.isNull(data.getMaternalSurname())) {
            user.setMaternalSurname(data.getMaternalSurname());
        }
        if (!Objects.isNull(data.getEmail())) {
            Matcher matcher = pattern.matcher(data.getEmail());
            if (!matcher.find()){
                throw new BadRequestExceptionMapper("Email inválido");}
            }
        user.setEmail(data.getEmail());
        return mapper.toDTO(repository.save(user));
    }

    public void delete(long id) {
        Optional<User> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundExceptionMapper("No existe el id: " + id + " en usuarios");
        }

        repository.deleteById(id);
    }

}
