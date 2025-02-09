package com.arsha.fundamentals.exceptions;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ExceptionsHandling {

    public static void main(String[] args) {

        try {
            Files.readAllLines(Paths.get("non existing file"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            //System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }
    }
}
