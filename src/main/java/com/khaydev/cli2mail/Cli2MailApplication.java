package com.khaydev.cli2mail;

import com.khaydev.cli2mail.command.MailCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
@RequiredArgsConstructor
public class Cli2MailApplication implements CommandLineRunner, ExitCodeGenerator {

	private final MailCommand mailCommand;
	private final CommandLine.IFactory factory;

	private int exitCode;

	public static void main(String[] args) {
		SpringApplication.run(Cli2MailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		exitCode = new CommandLine(mailCommand, factory).execute(args);
		System.exit(exitCode);
	}


	@Override
	public int getExitCode() {
		return exitCode;
	}
}
