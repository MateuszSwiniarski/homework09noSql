package com.rodzyn.homework09nosql.service;

import com.rodzyn.homework09nosql.advise.Aspekt;
import com.rodzyn.homework09nosql.model.PersonNoSql;
import com.rodzyn.homework09nosql.model.PersonSql;
import com.rodzyn.homework09nosql.repository.PersonSqlRepo;
import com.rodzyn.homework09nosql.repository.PersonalNoSqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Service
public class PersonalService {

    private PersonSqlRepo personSqlRepo;
    private PersonalNoSqlRepo personalNoSqlRepo;

    @Autowired
    public PersonalService(PersonSqlRepo personSqlRepo, PersonalNoSqlRepo personalNoSqlRepo) {
        this.personSqlRepo = personSqlRepo;
        this.personalNoSqlRepo = personalNoSqlRepo;
    }

    @Aspekt
    @EventListener(ApplicationReadyEvent.class)
    public void saveSQLperson() throws FileNotFoundException {
        File fileCsv = new File("personal.csv");

        Scanner scanner = new Scanner(fileCsv);

        while (scanner.hasNext()){
            String[] person = (scanner.nextLine()).split(",");
            personSqlRepo.save(new PersonSql(person[1], person[2], person[3], person[4], person[5]));
        }
    }

    @Aspekt
    @EventListener(ApplicationReadyEvent.class)
    public void saveNoSQLperson() throws FileNotFoundException {
        File fileCsv = new File("personal.csv");

        Scanner scanner = new Scanner(fileCsv);

        while (scanner.hasNext()){
            String[] person = (scanner.nextLine()).split(",");
            personalNoSqlRepo.save(new PersonNoSql(person[1], person[2], person[3], person[4], person[5]));
        }
    }


    @Aspekt
    @EventListener(ApplicationReadyEvent.class)
    public List<PersonSql> personSqlList(){
        return personSqlRepo.findAll();
    }

    @Aspekt
    @EventListener(ApplicationReadyEvent.class)
    public List<PersonNoSql> personNoSqlList(){
        return personalNoSqlRepo.findAll();
    }
}
