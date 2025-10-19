package Facade;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import Inerfaces.Course;

public class StudentPortalFacade {
    private final List<Course> enrolledCourses = new ArrayList<>();
    private final Map<Course, String> progress = new HashMap<>();

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            progress.put(course, "Enrolled");
            System.out.println("Enrolled in course: " + course.getClass().getSimpleName());
        } else {
            System.out.println("Already enrolled in course: " + course.getClass().getSimpleName());
        }
        }


    public void startLearning(Course course) {
        if (enrolledCourses.contains(course)) {
            progress.put(course, "In Progress");
            System.out.println("Started learning course: " + course.getClass().getSimpleName());
            course.deliverContent();
        } else {
            System.out.println("Not enrolled in course: " + course.getClass().getSimpleName());
        }
    }

    public void completeCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            progress.put(course, "Completed");
            System.out.println("Completed course: " + course.getClass().getSimpleName());
            sendNotification(course);
        } else {
            System.out.println("Not enrolled in course: " + course.getClass().getSimpleName());
        }
    }

    public void sendNotification(Course course) {
        System.out.println("Notification: You have completed the course " + course.getClass().getSimpleName() + "!\n");
    }

    public void showProgress() {
        System.out.println("Course Progress:");
        for (Map.Entry<Course, String> entry : progress.entrySet()) {
            System.out.println(" - " + entry.getKey().getClass().getSimpleName() + ": " + entry.getValue());
        }
        System.out.println();
    }
}

