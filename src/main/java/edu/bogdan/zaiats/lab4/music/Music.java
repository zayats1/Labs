package edu.bogdan.zaiats.lab4.music;

public record Music(String name, String album, String author,String style, int duration) {
    @Override
    public String toString() {
        var duration_s  = duration % 60;
        var duration_m = duration/60 - duration_s;
        return "Music{" +
                "name='" + name + '\'' +
                ", album='" + album + '\'' +
                ", author='" + author + '\'' +
                ", style='" + style + '\'' +
                ", duration=" + duration_m + ":" + duration_s +
                '}';
    }
}
