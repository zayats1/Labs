package edu.bogdan.zaiats.lab6.music;

public record Music(String name, String album, String author, String duration, String style) {
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", album='" + album + '\'' +
                ", author='" + author + '\'' +
                ", duration='" + duration + '\'' +
                ", style='" + style + '\'';
    }
}
