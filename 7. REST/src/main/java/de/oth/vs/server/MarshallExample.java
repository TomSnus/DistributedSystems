package de.oth.vs.server;

import de.oth.vs.entity.Address;
import de.oth.vs.entity.Student;
import javax.xml.bind.*;
import java.io.File;

/**
 * Created by Jon on 29.05.2017.
 */
public class MarshallExample {

    public static void main(String[] args)  {

        try {
            System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");
            JAXBContext context = JAXBContext.newInstance(Student.class);
            JAXB.marshal(new Student(666, "Max", 250, new Address("Test", "Regensburg")), new File("student.xml"));
            Student example = JAXB.unmarshal("D:/Drive/6. Semester/Allgemeine Informatik_6.Semester/VS/DistributedSystems/student.xml", Student.class);
            System.out.println(example);

            //JSON
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty("eclipselink.media-type", "application/json");
            //  marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
            marshaller.marshal(example, System.out);
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
