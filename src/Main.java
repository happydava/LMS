import Courses.MathCourse;
import Courses.ProgrammingCourse;
import Decorators.CertificateDecorator;
import Decorators.GamificationDecorator;
import Decorators.MentorSupportDecorator;
import Facade.Student;
import Interfaces.Course;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Студент вводит имя
        System.out.println("Enter your name: ");
        String studentName = scanner.nextLine();

        // Создаем студента
        Student student = new Student(studentName);

        // Меню
        while (true) {
            System.out.println("\n---- Student Education System ----");
            System.out.println("1. Enroll in a course");
            System.out.println("2. Start learning");
            System.out.println("3. Complete a course");
            System.out.println("4. View certificates");
            System.out.println("5. Save student data");
            System.out.println("6. Load student data");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    enrollInCourse(scanner, student);
                    break;
                case 2:
                    startLearning(scanner, student);
                    break;
                case 3:
                    completeCourse(scanner, student);
                    break;
                case 4:
                    viewCertificates(student);
                    break;
                case 5:
                    System.out.print("Enter filename to save: ");
                    String saveFilename = scanner.nextLine();
                    student.saveToFile(saveFilename);
                    break;
                case 6:
                    System.out.print("Enter filename to load: ");
                    String loadFilename = scanner.nextLine();
                    Student loadedStudent = Student.loadFromFile(loadFilename);
                    if (loadedStudent != null) {
                        student = loadedStudent;
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void enrollInCourse(Scanner scanner, Student student) {
        System.out.println("\nSelect a course to enroll in:");
        System.out.println("1. Math Course");
        System.out.println("2. Programming Course");
        System.out.print("Enter your choice: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Course course = null;
        if (courseChoice == 1) {
            course = new MathCourse();
        } else if (courseChoice == 2) {
            course = new ProgrammingCourse();
        } else {
            System.out.println("Invalid course choice.");
            return;
        }

        // Выбираем декораторы
        System.out.println("\nSelect decorators for the course:");
        System.out.println("1. Gamification (adds points)");
        System.out.println("2. Mentor Support");
        System.out.println("3. Certificate");
        System.out.println("4. None");
        System.out.print("Enter your choice (multiple options allowed, comma separated): ");
        String decoratorChoice = scanner.nextLine();

        Course tempCourse = course;

        String[] choices = decoratorChoice.split(",");
        for (String choice : choices) {
            switch (choice.trim()) {
                case "1":
                    tempCourse = new GamificationDecorator(tempCourse);
                    break;
                case "2":
                    tempCourse = new MentorSupportDecorator(tempCourse);
                    break;
                case "3":
                    tempCourse = new CertificateDecorator(tempCourse);
                    break;
                default:
                    System.out.println("Invalid decorator choice.");
                    break;
            }
        }

        student.enrollCourse(tempCourse);
    }

    private static void startLearning(Scanner scanner, Student student) {
        if (student.getEnrolledCourses().isEmpty()) {
            System.out.println("\nYou are not enrolled in any courses.");
            return;
        }

        System.out.println("\nSelect a course to start learning:");
        for (int i = 0; i < student.getEnrolledCourses().size(); i++) {
            System.out.println((i + 1) + ". " + student.getEnrolledCourses().get(i).getName());
        }
        System.out.print("Enter your choice: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (courseChoice < 1 || courseChoice > student.getEnrolledCourses().size()) {
            System.out.println("Invalid course choice.");
            return;
        }

        Course selectedCourse = student.getEnrolledCourses().get(courseChoice - 1);
        selectedCourse.deliverContent();
    }

    private static void completeCourse(Scanner scanner, Student student) {
        if (student.getEnrolledCourses().isEmpty()) {
            System.out.println("\nYou are not enrolled in any courses.");
            return;
        }

        System.out.println("\nSelect a course to complete:");
        for (int i = 0; i < student.getEnrolledCourses().size(); i++) {
            System.out.println((i + 1) + ". " + student.getEnrolledCourses().get(i).getName());
        }
        System.out.print("Enter your choice: ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (courseChoice < 1 || courseChoice > student.getEnrolledCourses().size()) {
            System.out.println("Invalid course choice.");
            return;
        }

        Course selectedCourse = student.getEnrolledCourses().get(courseChoice - 1);
        student.completeCourse(selectedCourse);
    }

    private static void viewCertificates(Student student) {
        if (student.getCertificates().isEmpty()) {
            System.out.println("\nYou have no certificates yet.");
        } else {
            System.out.println("\nYour certificates:");
            for (String certificate : student.getCertificates()) {
                System.out.println("- " + certificate);
            }
        }
    }
}
