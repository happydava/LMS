package Decorators;
import Inerfaces.*;

public class GamificationDecorator implements Gamification {
    private final Course course;
    private final Gamification gamification;

    public GamificationDecorator(Course course, Gamification gamification) {
        this.course = course;
        this.gamification = gamification;
    }

    @Override
    public void addGamification() {
        course.deliverContent();
        gamification.addGamification();
    }
}
