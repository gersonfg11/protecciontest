package com.example.fibonacci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendFibonacciResult(String result) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("didier.correa@proteccion.com.co", "correalondon@gmail.com");
        message.setSubject("Prueba Técnica - Gerson Fernando Gomez Mojica");
        message.setText(result);

        emailSender.send(message);
    }
}
