package com.khaydev.cli2mail.service;

import com.khaydev.cli2mail.model.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSenderImpl emailSender;

    @Override
    public void sendSimpleMail(Email email) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(email.getFrom());
        mail.setTo(email.getTo());
        mail.setSubject(email.getSubject());
        mail.setText(email.getMessage());

        emailSender.send(mail);
    }
}
