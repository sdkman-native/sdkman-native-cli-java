package io.sdkman.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "list")
public class List implements Runnable {

    @Parameters(index = "0", arity = "*")
    private String candidate = "";

    public void run() {
        System.out.println("Listing... " + candidate);

        String url = "";
        if (candidate == "") {
            url = "/candidates/list";
        } else {
            url = "/candidates/" + candidate + "/Linux64/versions/list?current=&installed=";
        }
        System.out.println("URL: " + url);

        String list = SDK.readURL(url);
        System.out.println(list);

    }

}