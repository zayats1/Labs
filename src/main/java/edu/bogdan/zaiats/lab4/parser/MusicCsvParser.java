package edu.bogdan.zaiats.lab4.parser;


import edu.bogdan.zaiats.lab4.music.Music;

public class MusicCsvParser {
   public static Music fromLine(String line){
        var data = line.split(",");
        if (data.length != 5) {
            return null;
        }
       return new Music(
               data[0],
               data[1],
               data[2],
               data[3],
               data[4]
               );
    }
}
