package Decorators;
import Interfaces.Course;

public abstract class CourseDecorator implements Course {
    private final Course course;

    public CourseDecorator(Course course) {
        this.course = course;
    }

    @Override
    public void deliverContent() {
        course.deliverContent();
    }
}
