package com.khaydev.cli2mail.command;

import com.khaydev.cli2mail.model.Email;
import com.khaydev.cli2mail.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "send", description = "Command to send mail", mixinStandardHelpOptions = true)
public class SendMailCommand implements Runnable{
    private EmailServiceImpl service;

    @Autowired
    public SendMailCommand(EmailServiceImpl service) {
        this.service = service;
    }

    @Value("${mail.user.from}")
    String from;

    @CommandLine.Option(names = {"--to","-t"}, description = "email of recipient", required = true)
    String to;

    @CommandLine.Option(names = {"--message", "-m"}, description = "message to send", required = true)
    String message;

    @CommandLine.Option(names = {"--subject", "-s"}, description = "subject of mail", required = true)
    String subject;


    @Override
    public void run() {
        Email email = Email.builder()
                .to(to)
                .from(from)
                .subject(subject)
                .message(message)
                .build();

        service.sendSimpleMail(email);
    }
}
