package edu.bogdan.zaiats.lab6.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getName() {
        var command = new Help();
        assertEquals(command.getName(), Help.class.getSimpleName());
    }
}