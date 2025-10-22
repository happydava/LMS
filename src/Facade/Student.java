package Facade;

import Courses.MathCourse;
import Decorators.CertificateDecorator;
import Interfaces.Course;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> enrolledCourses;
    private List<String> certificates;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.certificates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void completeCourse(Course course) {
        course.complete();
        if (course instanceof CertificateDecorator) {
            certificates.add("Certificate for " + course.getName());
        }
        System.out.println("Congratulations " + name + "! You have completed the course.");
    }

    public List<String> getCertificates() {
        return certificates;
    }

    // Сохранение в текстовый файл
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("name=" + name + "\n");
            for (Course course : enrolledCourses) {
                writer.write("course=" + course.getName() + "\n");
            }
            for (String cert : certificates) {
                writer.write("certificate=" + cert + "\n");
            }
            System.out.println("Student data saved.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Загрузка из текстового файла
    public static Student loadFromFile(String filename) {
        Student student = new Student("Default");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("name=")) {
                    student = new Student(line.substring(5));
                } else if (line.startsWith("course=")) {
                    String courseName = line.substring(7);
                    // Просто добавляем имя курса (декораторы не сохраняются)
                    student.enrollCourse(new MathCourse()); // Пример, можно расширить
                } else if (line.startsWith("certificate=")) {
                    student.getCertificates().add(line.substring(12));
                }
            }
            System.out.println("Student data loaded.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return student;
    }
}
