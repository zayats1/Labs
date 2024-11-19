package edu.bogdan.zaiats.lab6.commands;

import edu.bogdan.zaiats.lab6.service.MusicService;

public abstract class MusicServiceCommand implements Command {
    protected final MusicService service;
    public MusicServiceCommand(MusicService service) {
          this.service = service;
    }
}
