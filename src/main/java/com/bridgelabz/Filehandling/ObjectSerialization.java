package com.bridgelabz.Filehandling;

import java.io.*;
import java.util.ArrayList;

public class ObjectSerialization {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //In serialization, we have ObjectInputStream class and ObjectOutputStream class.

        File file = new File("students.txt");
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Shubham", 9.5));
        students.add(new Student("Meghna", 8.5));
        students.add(new Student("Charu", 7.8));
        students.add(new Student("Shreya", 9.5));
        students.add(new Student("Amit", 7.5));

        //serialize the collection of students.
        // Creating stream
        FileOutputStream foo = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(foo);
        for (Student s : students) {
            output.writeObject(s);
        }
        output.close();
        foo.close();

        //Deserialize the collection of students.
        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream input = new ObjectInputStream(fi);
        ArrayList<Student> students2 = new ArrayList<Student>();
        try {
            while (true) {
                //it basically returns an object here we need to cast that object
                // Student before assign it to a type Student 
                Student s = (Student) input.readObject();
                students2.add(s);
            }
        } catch (EOFException ex) {
        }
        for (Student s : students2) {
            System.out.println(s);
        }

    }
}
