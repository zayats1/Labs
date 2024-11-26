package edu.bogdan.zaiats.lab6.storage;

import java.io.IOException;
import java.io.FileWriter;

public class Writer {
    public static void write(String filename, String data)  throws IOException {
        try (var writer = new FileWriter(filename)) {
            writer.write(data);
        }
    }
}
