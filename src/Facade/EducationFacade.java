package Facade;

import Interfaces.Course;

public class EducationFacade {
    private Student student;

    public EducationFacade(Student student) {
        this.student = student;
    }

    public void enrollInCourse(Course course) {
        student.enrollCourse(course);
    }

    public void startLearning(Course course) {
        course.deliverContent();
    }

    public void completeCourse(Course course) {
        course.complete();
        student.completeCourse(course);
    }
}
