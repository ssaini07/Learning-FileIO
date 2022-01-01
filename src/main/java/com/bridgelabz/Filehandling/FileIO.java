package com.bridgelabz.Filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {
        File file = new File("test.txt");

        //write your name and age to your file.
       /*
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            output.println("Shubham Saini");
            output.println(26);
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
            e.printStackTrace();
        }

        */
        //read form the file

        try {
            Scanner input = new Scanner(file);
            String name = input.nextLine();
            int age = input.nextInt();
            System.out.println("Reading operation ::");
            System.out.println(name);
            System.out.println(age);
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("please choose a different file");
        }

    }
}
