package pl.sdacademy.citizens.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Contains information about whole CSV file
 */
public class CsvFile implements Iterable<CsvLine> {
    private final static String NEW_LINE = System.lineSeparator();
    private final List<CsvLine> lines;

    public CsvFile() {
        lines = new ArrayList<>();
    }

    /**
     * Appends this file with new CSV line
     * @param line to be added
     */
    public void addLine(CsvLine line) {
        lines.add(line);
    }

    /**
     * Returns line at specified position
     * @param lineNumber 0-based index
     * @return Found @{@link CsvLine} or null if not found
     */
    public CsvLine getLineAt(int lineNumber) {
        if (lineNumber < lines.size()) {
            return lines.get(lineNumber);
        }
        return null;
    }

    public List<CsvLine> getLines() {
        return new ArrayList<>(lines);
    }

    /**
     * Attempts to read provided file in order to convert it to CSV File representation
     * @param inputLocation file that contains data.
     * @return Cnverted file, never null. File might actually does not contain any data.
     */
    public static CsvFile fromFile(File inputLocation) {
        CsvFile convertedFile = new CsvFile();
        try (FileReader inputStream = new FileReader(inputLocation)) {
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                convertedFile.addLine(CsvLine.fromTextLine(readLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  convertedFile;
    }

    /**
     * Attempts to save current instance of CSV file into a File
     * @param outputLocation file that will be created.
     */
    public void toFile(File outputLocation) {
        try (OutputStream outputStream = new FileOutputStream(outputLocation)) {
            for (CsvLine line : lines) {
                outputStream.write((line.toTextLine() + NEW_LINE).getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<CsvLine> iterator() {
        return lines.iterator();
    }
}
