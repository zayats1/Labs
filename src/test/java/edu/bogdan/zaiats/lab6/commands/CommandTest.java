package edu.bogdan.zaiats.lab6.commands;

import edu.bogdan.zaiats.lab6.service.MusicService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getName() {
        var command = new Add(new MusicService());
        assertEquals("Add", command.getName());
    }
}