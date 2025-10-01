// File: SocialMedia.java
class Post {
    String author, content, time;

    public Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println(author + " posted: " + content + " at " + time);
    }
}

class InstagramPost extends Post {
    int likes;
    public InstagramPost(String a, String c, String t, int likes) {
        super(a, c, t);
        this.likes = likes;
    }
    @Override
    public void display() {
        System.out.println("[Instagram] " + author + ": " + content + " ❤️ " + likes + " likes");
    }
}

class TwitterPost extends Post {
    int retweets;
    public TwitterPost(String a, String c, String t, int r) {
        super(a, c, t);
        this.retweets = r;
    }
    @Override
    public void display() {
        System.out.println("[Twitter] " + content + " (" + content.length() + " chars) 🔁 " + retweets + " retweets");
    }
}

class LinkedInPost extends Post {
    int connections;
    public LinkedInPost(String a, String c, String t, int conn) {
        super(a, c, t);
        this.connections = conn;
    }
    @Override
    public void display() {
        System.out.println("[LinkedIn] " + author + " shared: " + content + " 🔗 Connections: " + connections);
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        Post p1 = new InstagramPost("Alice", "Enjoying coffee!", "10:00AM", 120);
        Post p2 = new TwitterPost("Bob", "Java > Python?", "11:30AM", 50);
        Post p3 = new LinkedInPost("Charlie", "Hiring developers!", "12:00PM", 200);

        p1.display();
        p2.display();
        p3.display();
    }
}
