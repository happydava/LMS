package Decorators;
import Inerfaces.*;

public class KabinetDecorator implements Kabinet {
    private final Course course;
    private final Kabinet kabinet;

    public KabinetDecorator(Course course, Kabinet kabinet) {
        this.course = course;
        this.kabinet = kabinet;
    }

    @Override
    public void addKabinet() {
        course.deliverContent();
        kabinet.addKabinet();
    }
}
