package Mentors;
import Inerfaces.Mentor;

public class MathMentor implements Mentor {
    @Override
    public void assist() {
        System.out.println("Your mentor is David Khamitskiy");
    }
}