package Certificates;
import Inerfaces.Certificate;

public class MathCertificate implements Certificate {
    @Override
    public void addCertificate() {
        System.out.println("Math Certificate added.");
    }
}
