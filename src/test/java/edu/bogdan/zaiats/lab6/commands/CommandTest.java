package edu.bogdan.zaiats.lab6.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getName() {
        var command = new Quit();
        assertEquals(command.getName(), Quit.class.getSimpleName());
    }
}