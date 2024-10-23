package edu.bogdan.zaiats.lab4.console;

import edu.bogdan.zaiats.lab4.music.Music;
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
}