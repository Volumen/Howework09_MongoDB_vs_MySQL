package com.example.demo.service;

import com.example.demo.aspect.MyAnnotation;
import com.example.demo.model.PersonMongoDB;
import com.example.demo.model.PersonMySQL;
import com.example.demo.repository.PersonMongoDBRepository;
import com.example.demo.repository.PersonMySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonMongoDBRepository personMongoDBRepository;
    private PersonMySQLRepository personMySQLRepository;
    private List<PersonMongoDB> personMongoDBList;
    private List<PersonMySQL> personMySQLList;

    @Autowired
    public PersonService(PersonMongoDBRepository personMongoDBRepository, PersonMySQLRepository personMySQLRepository) {
        this.personMongoDBRepository = personMongoDBRepository;
        this.personMySQLRepository = personMySQLRepository;
    }

    @MyAnnotation
    public void readCsvFile(String fileName) {

        personMongoDBList = new ArrayList<>();
        personMySQLList = new ArrayList<>();

        //Path filePath = Paths.get(fileName);
        File file = new File(fileName);
        String line = "";
        try (
               // BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
               // line = bufferedReader.readLine();

                while ((line = bufferedReader.readLine()) != null) {

                String[] str = line.split(",");

                personMongoDBList.add(createMongoDBPerson(str));
                personMySQLList.add(createMySQLPerson(str));

                }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public PersonMongoDB createMongoDBPerson(String[] data)
    {
        PersonMongoDB personMongoDB = new PersonMongoDB();
        personMongoDB.setId(data[0]);
        personMongoDB.setName(data[1]);
        personMongoDB.setSecondName(data[2]);
        personMongoDB.setEmail(data[3]);
        personMongoDB.setGender(data[4]);
        personMongoDB.setIp_address(data[5]);

        return personMongoDB;
    }
    public PersonMySQL createMySQLPerson(String[] data)
    {
        PersonMySQL personMySQL = new PersonMySQL();
        personMySQL.setId(data[0]);
        personMySQL.setName(data[1]);
        personMySQL.setSecondName(data[2]);
        personMySQL.setEmail(data[3]);
        personMySQL.setGender(data[4]);
        personMySQL.setIp_address(data[5]);

        return personMySQL;
    }
    @MyAnnotation
    public void saveToMongoDB(List<PersonMongoDB> personMongoDBS)
    {
        personMongoDBRepository.saveAll(personMongoDBS);
    }
    @MyAnnotation
    public void saveToMySQL(List<PersonMySQL> personMySQLS)
    {
        personMySQLRepository.saveAll(personMySQLS);
    }

    @MyAnnotation
    public List<PersonMongoDB> getPersonMongoDBListFromDB() {
        return personMongoDBRepository.findAll();
    }
    @MyAnnotation
    public List<PersonMySQL> getPersonMySQLListFromDB() {
        return personMySQLRepository.findAll();
    }

    public List<PersonMongoDB> getPersonMongoDBList() {
        return personMongoDBList;
    }

    public List<PersonMySQL> getPersonMySQLList() {
        return personMySQLList;
    }
}
