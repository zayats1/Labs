package edu.bogdan.zaiats.lab6.storage;

import edu.bogdan.zaiats.lab6.music.Music;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Writer {
    public boolean write(String filename, String data)  {
        try {
            try (var writer = new FileWriter(filename)) {
                writer.write(data);
            }
        } catch (IOException e){
            System.out.println(e.toString());
            return  false;
        }

        return true;
    }
}
