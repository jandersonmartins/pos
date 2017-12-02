package com.br.robo.pos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	private File file;
	private static int count = 0;

	public Logger() {
		this.file = new File("logger/log." + (++Logger.count) + ".txt");
	}

	public void write(String txt) throws IOException {
		FileWriter fileWriter = new FileWriter(this.file, true);
		fileWriter.write(txt);
		fileWriter.close();
	}
}
