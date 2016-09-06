package com.jbl.exception;

import java.io.PrintStream;

public class CopyException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
	}
}
