package Decorators;

import Interfaces.Course;

public class GamificationDecorator implements Course {
    private Course course;
    private int points = 0;

    public GamificationDecorator(Course course) {
        this.course = course;
    }

    @Override
    public void deliverContent() {
        course.deliverContent();
        points += 10;
        System.out.println("Earned 10 points! Total points: " + points);
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
