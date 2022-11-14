package oop.blueprints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class textHandle {
    public static String ReadInput() throws IOException {
        BufferedReader ConsoleText = new BufferedReader(new InputStreamReader(System.in));
        return ConsoleText.readLine();
    }
}

