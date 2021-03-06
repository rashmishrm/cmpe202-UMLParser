package com.sjsu.umlgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class AspectRunner {

    private String executeCommand(String command) {

	final StringBuffer output = new StringBuffer();
	Process p;
	try {
	    p = Runtime.getRuntime().exec(command);
	    p.waitFor();
	    final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    output.append("@startuml" + "\n");
	    String line = "";
	    while ((line = reader.readLine()) != null) {

		if (line.contains("ASPECJ_TRACE:")) {
		    line = line.replace("ASPECJ_TRACE:", "");
		    output.append(line + "\n");
		}

	    }
	    output.append("@enduml");

	} catch (final Exception e) {
	    e.printStackTrace();
	}

	return output.toString();

    }

    public String run(String folder) {
	final String file = new File(".").getAbsolutePath();


	final String newFile = file.replace("/.", "");

	final String fileRunner = newFile + "/aspectj/runner.sh";
	final String aspectLib = newFile + "/aspectj/lib";
	final String interceptorPath = newFile + "/aspectj";

	final String command = "sh  " + fileRunner + " " + folder
		+ " " + aspectLib + " " + interceptorPath + " MethodInterceptor.aj";
	return executeCommand(command);

    }

    public static void main(String[] args) {
	final AspectRunner runner = new AspectRunner();
	final String folder = "/Users/rashmisharma/Documents/Spring_2017/cmpe202/personal-project/umlparser/uml-sequence-test";

	System.out.println(runner.run(folder));
    }

}
