package com.codeclan.example.ComputerFiles;

import com.codeclan.example.ComputerFiles.models.File;
import com.codeclan.example.ComputerFiles.models.Folder;
import com.codeclan.example.ComputerFiles.models.User;
import com.codeclan.example.ComputerFiles.repositories.FileRepository;
import com.codeclan.example.ComputerFiles.repositories.FolderRepository;
import com.codeclan.example.ComputerFiles.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComputerFilesApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createFileAndFolderThenSave(){
		User user1 = new User ("Bob");
		Folder documents = new Folder("Documents");
		File wordDoc = new File("Important Data", ".doc", 25, documents);

		userRepository.save(user1);
		folderRepository.save(documents);
		fileRepository.save(wordDoc);

		documents.addUser(user1);
		user1.addFolder(documents);
		userRepository.save(user1);
		folderRepository.save(documents);



	}

}
