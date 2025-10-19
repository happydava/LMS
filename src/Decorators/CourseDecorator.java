package Decorators;
import Inerfaces.Course;

public abstract class CourseDecorator implements Course {
    protected Course decoratedCourse;

    public CourseDecorator(Course course) {
        this.decoratedCourse = course;
    }

    public void deliverContent() {
        decoratedCourse.deliverContent();
    }
}
