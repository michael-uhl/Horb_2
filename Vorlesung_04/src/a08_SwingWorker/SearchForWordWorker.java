package a08_SwingWorker;

import java.io.File;
import java.util.List;

import javax.swing.SwingWorker;

public class SearchForWordWorker extends SwingWorker<Integer, String> {

	private final String word;
	private final File[] documents;
	private final Informable informable;

	public SearchForWordWorker(String word, File[] documents, Informable informable) {
		this.word = word;
		this.documents = documents;
		this.informable = informable;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		int matches = 0;
		for (int i = 0, size = documents.length; i < size; i++) {
			// Update the status: the keep an eye on thing
			publish("Searching file: " + documents[i]);
			
			matches += new FileSearch(documents[i]).find(word);

			// update the progress
			setProgress((i + 1) * 100 / size);
		}

		return matches;
	}

	@Override
	protected void process(List<String> chunks) {
		for (String message : chunks) {
			informable.messageChanged(message);
		}
	}
}