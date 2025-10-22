package Courses;

import Interfaces.Course;

public class ProgrammingCourse implements Course {
    private boolean completed = false;

    @Override
    public void deliverContent() {
        System.out.println("Delivering Programming Course content...");
    }

    @Override
    public void complete() {
        this.completed = true;
    }

    @Override
    public String getName() {
        return "Programming Course";
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }
}
