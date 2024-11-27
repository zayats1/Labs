package edu.bogdan.zaiats.lab6.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MusicServiceTest {

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
    void addRecord() {

    }

    @Test
    void show() {
    }

    @Test
    void removeRecord() {
    }

    @Test
    void load() {
    }

    @Test
    void save() {
    }

    @Test
    void findRecord() {

    }
}