package edu.bogdan.zaiats.lab6.csv;


import edu.bogdan.zaiats.lab6.music.Music;

public class MusicCsvParser {
    public static Music fromLine(String line) {
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

    public static String toLine(Music music) {
        return String.join(",",
                music.name(),
                music.album(),
                music.author(),
                music.duration(),
                music.style());
    }
}
