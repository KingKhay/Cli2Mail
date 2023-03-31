package com.khaydev.cli2mail.service;

import com.khaydev.cli2mail.model.Email;

public interface EmailService {

    void sendSimpleMail(Email email);
}
