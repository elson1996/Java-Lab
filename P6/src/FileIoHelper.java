import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class FileIoHelper {
		private File inputFile;
		private File outputFile;
		private JProgressBar progressBar;
		public boolean stopCopy = false;
	public FileIoHelper(String input, String output, JProgressBar progressBar) {
		inputFile = new File(input);
		outputFile = new File(output);
		this.progressBar = progressBar;
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
	}
	
	public void copy() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		long fileLength = inputFile.length();
		System.out.println("len = " + fileLength);
		
		try {
			in = new FileInputStream(inputFile);
			out = new FileOutputStream(outputFile);
			int c;
			int bytesRead = 0;
			while ((c = in.read()) != -1) {
//				if(stopCopy)
//					break;
				System.out.print((char)c);
				out.write(c);
				bytesRead += 1;
				float per = bytesRead*100/fileLength;
				progressBar.setValue((int) per);
				progressBar.setString((int) per + "/100");
				try {
					  Thread.sleep(1000);
					} catch (InterruptedException ie) {
					    //Handle exception
					}
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	void displayCopied(JTextArea jta) throws FileNotFoundException	{
		Scanner fileScanner = new Scanner(new FileReader(outputFile));
		System.out.println("in");
		while(fileScanner.hasNext()){
			jta.append(fileScanner.next() + " ");
		}
		fileScanner.close();
	}
}
