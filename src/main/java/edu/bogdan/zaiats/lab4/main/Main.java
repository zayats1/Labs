package edu.bogdan.zaiats.lab4.main;

import edu.bogdan.zaiats.lab4.console.MusicCsvParser;
import edu.bogdan.zaiats.lab4.console.Reader;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<String> lines = null;
        if (args.length < 1){
            System.out.println("no args?");
            return;
        }

        try {
          lines =  Reader.readFile(args[0]);
          System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        lines.forEach(
                line -> System.out.println(MusicCsvParser.fromLine(line))
        );
    }
}