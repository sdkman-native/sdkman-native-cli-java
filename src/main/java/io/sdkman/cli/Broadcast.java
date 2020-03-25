package io.sdkman.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "broadcast")
public class Broadcast implements Runnable {

    public void run() {
        System.out.println("Fetching broadcast... ");

        String url = "/broadcast/latest";
        System.out.println("URL: " + url);

        String broadcastMessage = SDK.readURL(url);
        System.out.println(broadcastMessage);
    }

}