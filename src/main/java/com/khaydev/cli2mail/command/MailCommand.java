package com.khaydev.cli2mail.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "ctm", mixinStandardHelpOptions = true, subcommands = {SendMailCommand.class})
@RequiredArgsConstructor
public class MailCommand implements Runnable{

    @Override
    public void run() {
        System.out.println("Mail Command Running");
    }
}
