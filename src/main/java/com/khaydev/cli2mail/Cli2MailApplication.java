package com.khaydev.cli2mail;

import com.khaydev.cli2mail.command.MailCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class Cli2MailApplication implements CommandLineRunner{

	private final MailCommand mailCommand;
	private final CommandLine.IFactory factory;

	private final Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		SpringApplication.run(Cli2MailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			new CommandLine(mailCommand, factory).execute(args);
		}
}
