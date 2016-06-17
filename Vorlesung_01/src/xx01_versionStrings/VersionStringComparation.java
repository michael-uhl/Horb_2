package xx01_versionStrings;

import java.util.Comparator;
import java.util.Scanner;

public class VersionStringComparation  implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		Scanner s1 = new Scanner(str1);
		Scanner s2 = new Scanner(str2);
		s1.useDelimiter("\\.");
		s2.useDelimiter("\\.");

		while(s1.hasNextInt() && s2.hasNextInt()) {
		    int v1 = s1.nextInt();
		    int v2 = s2.nextInt();
		    if(v1 < v2) {
		        return -1;
		    } else if(v1 > v2) {
		        return 1;
		    }
		}

		if(s1.hasNextInt()) return 1; //str1 has an additional lower-level version number
		return 0;
	}

	
 
}
