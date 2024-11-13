package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.music.Music;
import edu.bogdan.zaiats.lab6.parser.MusicCsvParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MusicCsvParserTest {

    @Test
    void fromLine() {
        var line = "Foreword,Meteora,Linkin park,0:13,rock";

        var music = MusicCsvParser.fromLine(line);

        assertEquals(music, new Music(
                "Foreword","Meteora","Linkin park","0:13","rock"
        ));
    }

    @Test
    void notParsed(){
        var line = "Foreword,Meteora,Linkin park,rock";

        var music = MusicCsvParser.fromLine(line);

        assertNull(music);
    }
}