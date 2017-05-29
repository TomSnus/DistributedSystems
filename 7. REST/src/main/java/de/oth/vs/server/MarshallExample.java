package de.oth.vs.server;

import de.oth.vs.entity.Address;
import de.oth.vs.entity.Student;
import org.eclipse.persistence.jaxb.JAXBMarshaller;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Jon on 29.05.2017.
 */
public class MarshallExample {

    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Student.class);
        JAXB.marshal(new Student(666, "Max", 250, new Address("Test", "Regensburg")), new File("student.xml"));
        Student example = JAXB.unmarshal("D:/Drive/6. Semester/Allgemeine Informatik_6.Semester/VS/DistributedSystems/student.xml", Student.class);
        System.out.println(example);

    }
}
