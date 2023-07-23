package com.jaxbconvertion;

import com.example.Gender;
import com.example.Patient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
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

            // Serialization
            marshaller.marshal(patient, writer);
            System.out.println(writer.toString());


            // De-Serialization
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Patient result = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
            System.out.println(result.getAge());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }
}
