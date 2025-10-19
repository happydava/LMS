package Decorators;
import Inerfaces.*;

public class MentorSupportDecorator implements Mentor {
    private final Course course;
    private final Mentor mentor;

    public MentorSupportDecorator(Course course, Mentor mentor) {
        this.course = course;
        this.mentor = mentor;
    }

    @Override
    public void assist() {
        course.deliverContent();
        mentor.assist();
    }
}



