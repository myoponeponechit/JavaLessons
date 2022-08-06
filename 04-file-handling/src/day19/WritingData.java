package day19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

public class WritingData {
	
	public static void main(String[] args) throws IOException {
		var path = Path.of("src/cities.txt");
		
		//fileWrite(path);
		//fileWriteString(Path.of("student.txt"));
		//BufferWriter(Path.of("tester1.txt"));
		//readWithChannel();
		//readLarFileWithChannel();
		//writeWithChannel();
		writeLarDataWithChannel();
	}

	private static void writeLarDataWithChannel() {
		
		String data = """
				If I say that my someone special,
				everybody know that is you.
				""";
		try(RandomAccessFile file = new RandomAccessFile("data-1.txt", "rw")){
			
			FileChannel channel = file.getChannel();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024*8);
			
			buffer.put(data.getBytes());
			buffer.clear();
			System.out.println("Save....");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void writeWithChannel() throws FileNotFoundException, IOException {
		String data = """
					I'm not stupid girl!
					You understand?
				""";
		try(RandomAccessFile file = new RandomAccessFile("data.txt", "rw")) {
			// 1
			FileChannel channel = file.getChannel();
			
			// 2
			byte[] content = data.getBytes();
			ByteBuffer buffer = ByteBuffer.allocate(content.length);
			
			// 3 (write data to buffer from java)
			buffer.put(content);
			buffer.flip();
			
			// 5
			channel.write(buffer);
			System.out.println("Save Success....");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void readLarFileWithChannel() {
		
		try(FileChannel channel = FileChannel.open(Path.of("src/employee.txt"), StandardOpenOption.READ)) {
			int bufferSize = 1024;
			if(bufferSize > channel.size())
				bufferSize = (int)channel.size();
			
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			
			while(channel.read(buffer) > 0) { // return -1 if there is no data
				buffer.flip();
				String data = new String(buffer.array(), 0, buffer.limit());
				System.out.println("Content:\n" + data);
				buffer.clear();
			}
		}
		catch (Exception e) {
			
		}
	}

	private static void readWithChannel() {
		try(RandomAccessFile inputFile = new RandomAccessFile("src/employee.txt", "r")) {
			// get file channel
			FileChannel channel = inputFile.getChannel();
			long fileSize = channel.size();
			
			// create buffer
			ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
			
			// read data from channel to buffer
			channel.read(buffer);
			
			// prepare to read data from buffer
			buffer.flip();
			String data = new String(buffer.array(), 0, buffer.limit());
			System.out.println(data);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void BufferWriter(Path of) {
		
		try(BufferedWriter writer = Files.newBufferedWriter(of)) {
			// open
			// operations...
			// close
			writer.write("BufferWriter is the simplest way of writing textual data to a File.");
			writer.write("\nIt supports buffering");
			writer.newLine();
			//writer.close();
			writer.flush();
			writer.write("This is end line.");
			System.out.println("Save.....");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fileWriteString(Path of) throws IOException {
		String data = """
				Name: AungAung
				Address: Yangon
				Age: 26
				""";
		Files.writeString(of, data);
		System.out.println("Save....");
	}

	private static void fileWrite(Path path) throws IOException {
		List<String> data = List.of("Yangon", "Mandalay", "Pyin Oo Lwin");
		
		Files.write(path, data);
		
		Files.write(path, "Monywa".getBytes(), StandardOpenOption.APPEND);
	}
}
