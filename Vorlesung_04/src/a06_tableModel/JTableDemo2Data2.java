package a06_tableModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class JTableDemo2Data2 extends AbstractTableModel implements TableModel {

	private int size;
	private Map<String, String> data;

	// Konstruktor
	public JTableDemo2Data2(int size) {
		this.size = size;
		this.data = new HashMap<String, String>();
	}
	
	// Methoden für das TableModel-Interface
	public int getRowCount() {
		return size;
	}

	public int getColumnCount() {
		return size;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		String key = "[" + rowIndex + "," + columnIndex + "]";
		String value = (String) data.get(key);
		return value == null ? "-" : value;
	}
	
	// Zusätzliche Methoden
	public void printData() {
		Iterator<Map.Entry<String, String>> e = data.entrySet().iterator();
		while (e.hasNext()) {
			Map.Entry<String, String> entry = e.next();
			System.out.println("At " + entry.getKey() + ": " + entry.getValue());
		}
	}
}
