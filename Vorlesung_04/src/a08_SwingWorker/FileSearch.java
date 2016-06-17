package a08_SwingWorker;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileSearch {
	private File file;
	public FileSearch(File file) {
		super();
		this.file = file;
	}

	public static void main(String[] args) {
		// Testing only
		File f = new File(args[0]);
		String search = args[1];
		System.out.printf("Result of searching for %s in %s was %b\n", search,
				f.getName(), new FileSearch(f).find(search));
	}

	public long find(String searchString) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		long result = 0;
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(file));
			while (in.hasNextLine()) {
				if (in.nextLine().indexOf(searchString) > 0) {
					result++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) { /* ignore */
			}
		}
		return result;
	}
}