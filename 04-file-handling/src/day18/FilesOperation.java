package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

public class FilesOperation {
	
	public static void main(String[] args) throws IOException {
		//createFile();
		//createDirectory();
		//deleteFile();
		//deleteDirectories();
		//copy();
		//move();// cut
		//browseWith_list();
		browseWith_walk();
	}

	private static void browseWith_walk() throws IOException {
		var path = Path.of(".");
		
		try(Stream<Path> files = Files.walk(path)) {
//			System.out.println("--- All files and directories ---");
//			files.forEach(System.out::println);
			
//			System.out.println("--- Only Directories ---");
//			files
//				//.filter(p -> Files.isDirectory(p))
//				.filter(Files::isDirectory)
//				.forEach(System.out::println);
			
			System.out.println("--- Only java file ---");
			files.filter(p -> p.toString().contains(".java"))
			   		.forEach(System.out::println);
		}
	}

	private static void browseWith_list() {
		var path = Path.of(".");
		try(Stream<Path> fileList = Files.list(path)) {
			fileList.forEach(System.out::println);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void move() throws IOException {
		var path = Path.of("src/day18/test.txt");
		var dest = Path.of("src/readme.txt");
		
		Files.move(path, dest, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("File moving success");
	}

	private static void copy() throws IOException {
		var source = Path.of("src/day18/test.txt");
		var dest = Path.of("src/day18/another.txt");
		
		//Files.copy(source, dest); // first time = copy, second time = exception
		Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING); // first time = copy, second time = replace 
		System.out.println("Copy success");
	}

	private static void deleteDirectories() throws IOException {
		// delete empty directory
//		Path path = Path.of("./test");
//		Path path = Path.of("./data"); // error
//		var deletedDir = Files.deleteIfExists(path);
//		if(deletedDir) {
//			System.out.println("Delete Success");
//		}
//		else {
//			System.out.println("Something is wrong!");
//		}
		
		// delete directory that has sub-folders
		Path path = Path.of("./data");
		if(Files.exists(path)) {
			Files.walk(path) // List<Path>
				.map(p -> p.toFile()) // convert part to file
				.forEach(f -> f.delete()); // delete all files
			Files.delete(path);
			System.out.println("Delete Success");
		}
		else {
			System.out.println("Something is wrong!");
		}
	}

	private static void deleteFile() throws IOException {
		Path path = Path.of("src/day18/redme.txt");
		boolean fileDeleted = Files.deleteIfExists(path);
		if(fileDeleted) {
			System.out.println("Delete success!");
		}
		else {
			System.out.println("Something is wrong!");
		}
	}

	private static void createDirectory() throws IOException {
		Path path = Path.of("src/test");
		if(Files.notExists(path)) {
			Files.createDirectory(path);
			System.out.println("New directory has been created!");
		}
		else {
			System.out.println("This directory already exists!");
		}
	}

	private static void createFile() throws IOException {
		// define location
		Path path = Path.of("src/day18/redme.txt");
		if(Files.exists(path)) {
			System.out.println("File already exists!");
		}
		else {
			Files.createFile(path);
			System.out.println("Created file!");
		}
	}
}
