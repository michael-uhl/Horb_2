package a06_tableModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class JTableDemo2Data extends AbstractTableModel {
	private static final long serialVersionUID = -1861962920049038969L;

	private int size;
	private Map<String, String> data;

	// Konstruktor
	public JTableDemo2Data(int size) {
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

	public String getColumnName(int columnIndex) {
		return "C" + columnIndex;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return rowIndex < size && columnIndex < size;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		String key = "[" + rowIndex + "," + columnIndex + "]";
		String value = (String) data.get(key);
		return value == null ? "-" : value;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String key = "[" + rowIndex + "," + columnIndex + "]";
		String value = (String) aValue;
		if (value.length() <= 0) {
			data.remove(key);
		} else {
			data.put(key, value);
		}
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
