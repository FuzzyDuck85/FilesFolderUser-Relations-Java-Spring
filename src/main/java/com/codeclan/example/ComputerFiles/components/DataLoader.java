package com.codeclan.example.ComputerFiles.components;

import com.codeclan.example.ComputerFiles.models.File;
import com.codeclan.example.ComputerFiles.models.Folder;
import com.codeclan.example.ComputerFiles.models.User;
import com.codeclan.example.ComputerFiles.repositories.FileRepository;
import com.codeclan.example.ComputerFiles.repositories.FolderRepository;
import com.codeclan.example.ComputerFiles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Folder wordDocs = new Folder("Word Documents");
        folderRepository.save(wordDocs);
        Folder presentations = new Folder("PowerPoint Documents");
        folderRepository.save(presentations);
        Folder financial = new Folder("Excel Documents");
        folderRepository.save(financial);
        Folder projects = new Folder("Client Project");
        folderRepository.save(projects);

        User dogbert = new User ("Dogbert");
        userRepository.save(dogbert);
        User pointy = new User ("Pointy-haired Boss");
        userRepository.save(pointy);
        User catbert = new User("Catbert");
        userRepository.save(catbert);
        User asok = new User ("Asok");
        userRepository.save(asok);
        User wally = new User ("Wally");
        userRepository.save(wally);
        User alice = new User ("Alice");
        userRepository.save(alice);
        User dilbert = new User ("Dilbert");
        userRepository.save(dilbert);

        File wordDoc = new File("Important Confidential Employee Data", ".doc", 25, wordDocs);
        fileRepository.save(wordDoc);
        File enemyList = new File("List of all my Enemies", ".txt", 956, wordDocs);
        fileRepository.save(enemyList);
        File getMonies = new File("How to get Money from Investors", "ppt", 40, presentations);
        fileRepository.save(getMonies);
        File finances = new File("Company Financies", ".xls", 53, financial);
        fileRepository.save(finances);
        File project = new File("The Big Project", ".js", 456, projects);
        fileRepository.save(project);

        financial.addUser(pointy);
        financial.addUser(alice);
        userRepository.save(pointy);
        userRepository.save(alice);
        folderRepository.save(financial);

        projects.addUser(dilbert);
        projects.addUser(wally);
        projects.addUser(dogbert);
        userRepository.save(dilbert);
        userRepository.save(wally);
        userRepository.save(dogbert);
        folderRepository.save(projects);

        wordDocs.addUser(asok);
        wordDocs.addUser(dogbert);
        userRepository.save(asok);
        userRepository.save(dogbert);
        folderRepository.save(wordDocs);

        presentations.addUser(alice);
        presentations.addUser(catbert);
        presentations.addUser(pointy);
        presentations.addUser(dilbert);
        userRepository.save(alice);
        userRepository.save(catbert);
        userRepository.save(pointy);
        userRepository.save(dilbert);
        folderRepository.save(presentations);


    }
}
