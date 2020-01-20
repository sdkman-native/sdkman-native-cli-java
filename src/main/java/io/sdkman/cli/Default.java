package io.sdkman.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "default")
public class Default implements Runnable {

    @Parameters(index = "0")
    private String candidate = "";

    public void run() {
        System.out.println("Fetching Default... " + candidate);

        String url = "/candidates/default/" + candidate;
        System.out.println("URL: " + url);

        String defaultVersion = SDK.readURL(url);
        System.out.println(defaultVersion);
    }

}