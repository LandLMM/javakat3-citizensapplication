package pl.sdacademy.citizens.model;

import java.util.*;

/**
 * Contains information about single CSV file line.
 */
public class CsvLine implements Iterable<String>  {
    private final List<String> elements;

    public CsvLine() {
        this.elements = new ArrayList<>();
    }

    public CsvLine(CsvLine csvLine) {
        this.elements = new ArrayList<>(csvLine.getElements());
    }

    /**
     * Appends current line with new value
     * @param value to be added
     */
    public void addElement(String value) {
        elements.add(value);
    }

    /**
     * Retrieves value at specific index of line.
     * @param position 0-based index of value
     * @return @{@link String} value, or null in no element found
     */
    public String getElementAt(int position) {
        if (position < elements.size()) {
            return elements.get(position);
        }
        return null;
    }

    /**
     * Returns copy of all elements in this line.
     * @return @{@link List} of @{@link String} elements, never null. Might return 0-length collection.
     */
    public List<String> getElements() {
        return new ArrayList<>(elements);
    }

    /**
     * Attempts to split provided line and create CsvLine from its values.
     * @param textLine comma-separated values
     * @return
     */
    public static CsvLine fromTextLine(String textLine) {
        String[] splittedLine = textLine.split(",");
        CsvLine csvLine = new CsvLine();
        for (String lineElement : splittedLine) {
            csvLine.addElement(lineElement);
        }
        return csvLine;
    }

    public String toTextLine() {
        StringJoiner lineJoiner = new StringJoiner(",");
        for (String lineElement : elements) {
            lineJoiner.add(lineElement);
        }
        return lineJoiner.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }
}
