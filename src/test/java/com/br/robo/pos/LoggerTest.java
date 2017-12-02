package com.br.robo.pos;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {
	private Logger logger;

	@Before
	public void setup() {
		this.logger = new Logger();
	}

	@Test
	public void deveCriarUmLog() throws Exception {
		this.logger.write("test");
		File log = new File("logger/log.1.txt");
		assertTrue(log.exists());
	}

	@After
	public void clear() {
		File dirLog = new File("logger");
		for (File log : dirLog.listFiles()) {
			log.delete();
		}
	}
}
