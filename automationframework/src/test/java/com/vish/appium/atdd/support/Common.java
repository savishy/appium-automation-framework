package com.vish.appium.atdd.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

public class Common {
	/**
	 * Executes a command and returns output.<p>
	 * Waits for a timeout, for the command to exit. 
	 * <i>If command does not finish within timeout, this method will abort the command.
	 * </i>
	 * @param command command string to execute.
	 * @param timeout set a timeout for which method should wait for the command to finish.
	 * @param failOnError if true, parse the output throw exception if output contains error.
	 * @param silent set to true to not dump anything to logs. 
	 * @return the output of the command.
	 * @throws IOException if the command output contained the word "error"
	 * @throws ExecuteException
	 * @throws InterruptedException
	 */
	public static String exec(String command, boolean failOnError, boolean silent) 
			throws IOException,ExecuteException, InterruptedException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		CommandLine commandline = CommandLine.parse(command);
		DefaultExecutor exec = new DefaultExecutor();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		exec.setStreamHandler(streamHandler);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

		exec.execute(commandline,resultHandler);
		if (!silent) System.out.println("Command Executed: " + command);

		//wait for command to terminate up till a timeout
		resultHandler.waitFor(30000);
		//dump output
		if (!silent) System.out.println("Output:" + outputStream.toString());
		//after process complete, get exit value
		int exitValue = -1;
		resultHandler.onProcessComplete(exitValue);
		if (!silent) System.out.println("command exit value:" + exitValue);
		if (failOnError)
			if (outputStream.toString().toLowerCase().trim().contains("error"))
				throw new IOException ("exec error:" + outputStream.toString());

		return outputStream.toString();
	}

}
