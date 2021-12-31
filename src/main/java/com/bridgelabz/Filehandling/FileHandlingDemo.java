package com.bridgelabz.Filehandling;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandlingDemo {
    final static String FILE_NAME = "AddressBookText.txt";
    final static String JSON_FILE_NAME = "AddressBookTest.json";

    public static void main(String[] args) {
        System.out.println("Hello world!");
        File txtFile = new File(FILE_NAME);
        File jsonFile = new File(JSON_FILE_NAME);
        try {
            if (txtFile.createNewFile()) {
                System.out.println("File is being created!!");
            } else {
                System.out.println("file is already being existed!!");
            }
            //writeTxtData(txtFile, getListOfContacts().toString());
            //writeJsonData(jsonFile, getListOfContacts());
            readTxtData(txtFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contact> getListOfContacts() {
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Shubham", "92994949493"));
        contacts.add(new Contact("Amit", "75757747474"));
        contacts.add(new Contact("Kunal", "923232343443"));
        contacts.add(new Contact("Shreya", "9212323232333"));
        return contacts;
    }

    public static void writeTxtData(File file, String data) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJsonData(File file, List<Contact> contacts) {
        try {

            //Contact contact = new Contact("Shubham", "8657473363");
            Gson gson = new Gson();
            String jsonString = gson.toJson(contacts);
            System.out.println("JsonString :: " + jsonString);
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(jsonString);
            System.out.println("Json data written");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTxtData(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner sc = new Scanner(fileReader);
            System.out.println("Reading operation ::");
            System.out.println(sc.nextLine());
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
