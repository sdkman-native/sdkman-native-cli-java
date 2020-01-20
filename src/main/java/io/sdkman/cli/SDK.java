package io.sdkman.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "sdk", //
		subcommands = { //
                List.class,//
                Default.class
		})
public class SDK implements Runnable {

    public static final String DEFAULT_API = "https://api.sdkman.io/2";

	public void run() {
	}

    public static void main(String[] args) {
		new CommandLine(new SDK()).execute(args);
	}

    public static String readURL(String url) {
        try {
            StringBuffer data = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(DEFAULT_API + url).openStream()));
            String line = "";
            while(line != null) {
                data.append(line + "\n");
                line = br.readLine();
            }
            return data.toString();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return "";
        }
    }

}
