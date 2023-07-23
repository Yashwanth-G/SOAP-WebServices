package com.jaxbconvertion;

import com.example.Gender;
import com.example.Patient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JAXBDemo {
    public static void main(String[] args) {


        try {
            JAXBContext context = JAXBContext.newInstance(Patient.class);

            Marshaller marshaller = context.createMarshaller();

            Patient patient = new Patient();
            patient.setAge(23);
            patient.setGender(Gender.valueOf("M"));

            StringWriter writer = new StringWriter();
            marshaller.marshal(patient, writer);

            System.out.println(writer.toString());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }
}
