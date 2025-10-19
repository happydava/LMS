package Courses;
import Inerfaces.*;

public class DesignPatterns implements Course {
    private Mentor mentor;
    private Kabinet kabinet;
    private Certificate certificate;
    private Gamification gamification;

    public DesignPatterns(Mentor mentor, Kabinet kabinet, Certificate certificate, Gamification gamification) {
        this.mentor = mentor;
        this.kabinet = kabinet;
        this.certificate = certificate;
        this.gamification = gamification;
    }

    @Override
    public void deliverContent() {
        System.out.println("Adding Design Patterns course content");
        mentor.assist();
        kabinet.addKabinet();
        certificate.addCertificate();
        gamification.addGamification();
    }
}
