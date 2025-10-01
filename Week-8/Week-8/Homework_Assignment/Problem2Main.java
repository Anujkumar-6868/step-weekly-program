public class Problem2Main {
    interface Playable {
        void play();
        void pause();
    }

    static class MusicPlayer implements Playable {
        public void play() { System.out.println("Music playing..."); }
        public void pause() { System.out.println("Music paused."); }
    }

    static class VideoPlayer implements Playable {
        public void play() { System.out.println("Video playing..."); }
        public void pause() { System.out.println("Video paused."); }
    }

    public static void main(String[] args) {
        Playable p1 = new MusicPlayer();
        p1.play();
        p1.pause();

        Playable p2 = new VideoPlayer();
        p2.play();
        p2.pause();
    }
}
