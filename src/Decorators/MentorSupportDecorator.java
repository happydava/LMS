package Decorators;

import Interfaces.Course;

public class MentorSupportDecorator implements Course {
    private Course course;

    public MentorSupportDecorator(Course course) {
        this.course = course;
    }

    @Override
    public void deliverContent() {
        course.deliverContent();
        System.out.println("Mentor support is available for this course.");
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
