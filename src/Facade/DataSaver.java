package Facade;

import Facade.Student;
import java.io.*;

public class DataSaver {
    public static void saveStudentData(Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(student.getName() + "_data"))) {
            oos.writeObject(student);
            System.out.println("Student data saved.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static Student loadStudentData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student student = (Student) ois.readObject();
            System.out.println("Student data loaded.");
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return null;
        }
    }
}
