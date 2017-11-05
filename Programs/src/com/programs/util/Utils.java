package com.programs.util;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Utils {

	public static Console getConsole() {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("No Console: Non interactive Mode!");
		}
		return console;

	}

	public static BufferedReader getReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}

	public static Scanner getScanner() {
		return new Scanner(System.in);
	}

}
