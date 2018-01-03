package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.CsvFile;
import pl.sdacademy.citizens.model.CsvLine;
import pl.sdacademy.citizens.model.PersonSummary;

import java.io.*;
import java.util.List;

public class PersonSummaryWriter {

    public void writeToFile(File outputFile, List<PersonSummary> persons) {
        CsvFile csvFile = new CsvFile();
        for (PersonSummary personSummary : persons) {
            CsvLine csvLine = new CsvLine();
            csvLine.addElement(personSummary.getId().toString());
            csvLine.addElement(personSummary.getName());
            csvLine.addElement(personSummary.getLastName());
            csvLine.addElement(personSummary.getAge().toString());
            csvLine.addElement(personSummary.getDogCount().toString());
            csvLine.addElement(personSummary.getCatCount().toString());
            csvLine.addElement(personSummary.getParrotCount().toString());
            csvLine.addElement(personSummary.getFishCount().toString());
            csvFile.addLine(csvLine);
        }
        csvFile.toFile(outputFile);
    }
}
