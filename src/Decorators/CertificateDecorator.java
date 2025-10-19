package Decorators;
import Inerfaces.*;

public class CertificateDecorator implements Certificate {
    private final Course course;
    private final Certificate certificate;

    public CertificateDecorator (Course course, Certificate certificate) {
        this.certificate = certificate;
        this.course = course;
    }

    @Override
    public void addCertificate() {
        course.deliverContent();
        certificate.addCertificate();

    }

}
