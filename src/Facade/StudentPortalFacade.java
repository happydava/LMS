package Facade;

import Interfaces.Course;

public class StudentPortalFacade {
    private Facade.Student student;

    public StudentPortalFacade(Facade.Student student) {
        this.student = student;
    }

    public void enrollInCourse(Course course) {
        student.enrollCourse(course);
    }

    public void startLearning(Course course) {
        course.deliverContent(); // Вызов метода deliverContent()
    }

    public void completeCourse(Course course) {
        course.complete(); // Устанавливаем статус завершения
        student.completeCourse(course); // Добавляем в завершённые
    }
}
