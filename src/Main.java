import Certificates.FizraCertificate;
import Certificates.MathCertificate;
import Certificates.PatternsCertificate;
import Courses.*;
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
        System.out.println("--- Math Course ---");
        mathCourse.deliverContent();

        Mentor fizraMentor = new FizraMentor();
        Kabinet fizraKabinet = new FizraKabinet();
        Certificate fizraCertificate = new FizraCertificate();
        Gamification fizraGamification = new FizraGamification();
        Course fizraCourse = new Fizra(fizraMentor, fizraKabinet, fizraCertificate, fizraGamification);
        System.out.println("\n--- Fizra Course ---");
        fizraCourse.deliverContent();


        Mentor PatternMentor = new PatternsMentor();
        Kabinet PatternKabinet = new PatternsKabinet();
        Certificate PatternCertificate = new PatternsCertificate();
        Gamification PatternGamification = new PatternsGamification();
        Course PatternCourse = new DesignPatterns(PatternMentor, PatternKabinet, PatternCertificate, PatternGamification);
        System.out.println("\n--- Design Patterns Course ---");
        PatternCourse.deliverContent();
    }
}