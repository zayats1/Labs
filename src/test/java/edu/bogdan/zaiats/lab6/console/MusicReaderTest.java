package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.music.Music;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MusicReaderTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    @BeforeEach
    void before() {
        var data = "Foreword\nMeteora\nLinkin park\n0:13\nrock\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @AfterEach
    void after() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void read() {
        var music = MusicReader.read(System.in);
        assertTrue(music.isPresent());
        assertEquals(new Music(
                "Foreword", "Meteora", "Linkin park", "0:13", "rock"
        ), music.get());
        music = MusicReader.read(new ByteArrayInputStream("".getBytes()));
        assertFalse(music.isPresent());
    }
}