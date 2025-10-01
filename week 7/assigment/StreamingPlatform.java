// File: StreamingPlatform.java
class Content {
    void play() {
        System.out.println("Playing content...");
    }
}

class Movie extends Content {
    void movieFeatures() {
        System.out.println("Movie: Ratings, duration, subtitles available.");
    }
}

class TVSeries extends Content {
    void seriesFeatures() {
        System.out.println("TV Series: Seasons, episodes, next episode suggestion.");
    }
}

class Documentary extends Content {
    void docFeatures() {
        System.out.println("Documentary: Educational tags and related content.");
    }
}

public class StreamingPlatform {
    public static void main(String[] args) {
        Content c = new TVSeries();  // Upcasting

        c.play();

        // Downcasting
        if (c instanceof TVSeries) {
            TVSeries s = (TVSeries) c;
            s.seriesFeatures();
        }
    }
}

