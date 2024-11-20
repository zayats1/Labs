package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.music.Music;
import edu.bogdan.zaiats.lab6.csv.MusicCsvParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MusicCsvParserTest {

    @Test
    void fromLine() {
        var line = "Foreword,Meteora,Linkin park,0:13,rock";

        var music = MusicCsvParser.fromLine(line);

        assertEquals(new Music(
                "Foreword","Meteora","Linkin park","0:13","rock"
        ), music);
    }

    @Test
    void notParsed(){
        var line = "Foreword,Meteor,Linkin park,rock";

        var music = MusicCsvParser.fromLine(line);

        assertNull(music);
    }
}