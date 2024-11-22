package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.music.Music;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MusicReaderTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    @Test
    void read() {
        try {
            var data = "Foreword\nMeteora\nLinkin park\n0:13\nrock\n";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            System.setOut(new PrintStream(new ByteArrayOutputStream()));
            var music  = MusicReader.read(System.in);
            assertTrue(music.isPresent());
            assertEquals(new Music(
                    "Foreword","Meteora","Linkin park","0:13","rock"
            ),music.get());
        } finally {
            System.setIn(System.in);
            System.setOut(System.out);
        }
    }
}