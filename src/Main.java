import Certificates.FizraCertificate;
import Certificates.MathCertificate;
import Certificates.PatternsCertificate;
import Courses.*;
import Facade.StudentPortalFacade;
import Gamifications.FizraGamification;
import Gamifications.MathGamification;
import Gamifications.PatternsGamification;
import Inerfaces.*;
import Kabinets.*;
import Mentors.*;

public class Main {
    public static void main(String[] args) {
        Mentor mathMentor = new MathMentor();
        Kabinet mathKabinet = new MathCabinet();
        Certificate MC = new MathCertificate();
        Gamification mathGamification = new MathGamification();
        Course mathCourse = new MathCourse(mathMentor, mathKabinet, MC, mathGamification);
        StudentPortalFacade portal = new StudentPortalFacade();
        System.out.println("--- Math Course ---");
        portal.enrollInCourse(mathCourse);
        portal.startLearning(mathCourse);
        portal.completeCourse(mathCourse);
        portal.showProgress();

        Mentor fizraMentor = new FizraMentor();
        Kabinet fizraKabinet = new FizraKabinet();
        Certificate fizraCertificate = new FizraCertificate();
        Gamification fizraGamification = new FizraGamification();
        Course fizraCourse = new Fizra(fizraMentor, fizraKabinet, fizraCertificate, fizraGamification);
        StudentPortalFacade portal2 = new StudentPortalFacade();
        System.out.println("\n--- Fizra Course ---");
        portal2.enrollInCourse(fizraCourse);
        portal2.startLearning(fizraCourse);
        portal2.completeCourse(fizraCourse);
        portal2.showProgress();


        Mentor PatternMentor = new PatternsMentor();
        Kabinet PatternKabinet = new PatternsKabinet();
        Certificate PatternCertificate = new PatternsCertificate();
        Gamification PatternGamification = new PatternsGamification();
        Course PatternCourse = new DesignPatterns(PatternMentor, PatternKabinet, PatternCertificate, PatternGamification);
        StudentPortalFacade portal3 = new StudentPortalFacade();
        System.out.println("\n--- Design Patterns Course ---");
        portal3.enrollInCourse(PatternCourse);
        portal3.startLearning(PatternCourse);
        portal3.completeCourse(PatternCourse);
        portal3.showProgress();

    }
}