package edu.bogdan.zaiats.lab6.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<String> readFile(String filename) throws FileNotFoundException {
        var lines = new ArrayList<String>();
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            lines.add(line.stripTrailing());
        }
        myReader.close();
        return lines;
    }
}
