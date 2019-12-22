package com.example.demo;

import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start{

    private PersonService personService;

    @Autowired
    public Start(PersonService personService) {
        this.personService = personService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        String fileName = "MOCK_DATA.csv";
        //personService.readCsvFile(fileName);
       // System.out.println(personService.getPersonMongoDBList());
       // System.out.println(personService.getPersonMySQLList());

        //SAVE
        //personService.saveToMongoDB(personService.getPersonMongoDBList());
        //personService.saveToMySQL(personService.getPersonMySQLList());

        //READ
        //personService.getPersonMongoDBListFromDB();
       //personService.getPersonMySQLListFromDB().forEach(System.out::println);

    }

}
