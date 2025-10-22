package Decorators;

import Interfaces.Course;

public class CertificateDecorator implements Course {
    private Course course;

    public CertificateDecorator(Course course) {
        this.course = course;
    }

    @Override
    public void deliverContent() {
        course.deliverContent();
        System.out.println("Certificate will be issued upon completion.");
    }

    @Override
    public void complete() {
        course.complete();
    }

    @Override
    public String getName() {
        return course.getName();
    }

    @Override
    public boolean isCompleted() {
        return course.isCompleted();
    }
}
