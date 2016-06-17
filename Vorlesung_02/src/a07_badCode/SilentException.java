package a07_badCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class SilentException {
	public static void main(String[] args) {
		try {
			FileChannel in = new FileInputStream("/home/source.bin").getChannel();
			FileChannel out = new FileOutputStream("/home/target.bin").getChannel();
			in.transferTo(0, in.size(), out);
		} catch (IOException ex) {
			// Hier wird absichtlich nichts gemacht nach dem Motto: Wenn man
			// keinen Fehler sieht, ist auch keiner passiert :-(
		}
	}
}
