package com.oegr.programa.lealtad.service.impl;

import com.oegr.programa.lealtad.model.Email;
import com.oegr.programa.lealtad.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    @Value("${oegr.exchange}")
    private String TOPIC_EXCHANGE_NAME;

    @Value("${oegr.routing}")
    private String ROUTING_KEY;

    private RabbitTemplate template;
    @Autowired
    public EmailServiceImpl(RabbitTemplate template) {
        this.template = template;
    }

    public void sendEmail(Email data) {
        log.info("Enviando mensaje...");
        template.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY, data);
    }
}
