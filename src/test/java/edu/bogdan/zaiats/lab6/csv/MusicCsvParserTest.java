package edu.bogdan.zaiats.lab6.csv;

import edu.bogdan.zaiats.lab6.music.Music;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MusicCsvParserTest {

    @Test
    void fromLine() {
        var line = "Foreword,Meteora,Linkin park,0:13,rock";

        var music = MusicCsvParser.fromLine(line);

        assertEquals(new Music(
                "Foreword", "Meteora", "Linkin park", "0:13", "rock"
        ), music);
    }

    @Test
    void notParsed() {
        var line = "Foreword,Meteor,Linkin park,rock";

        var music = MusicCsvParser.fromLine(line);

        assertNull(music);
    }

    @Test
    void toLine() {
        var music = new Music(
                "Foreword", "Meteora", "Linkin park", "0:13", "rock"
        );
        var line = "Foreword,Meteora,Linkin park,0:13,rock";
        assertEquals(line, MusicCsvParser.toLine(music));
    }
}