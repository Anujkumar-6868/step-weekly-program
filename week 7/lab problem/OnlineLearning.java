// File: OnlineLearning.java
class Course {
    String title, instructor;
    public Course(String title, String instructor) {
        this.title = title; this.instructor = instructor;
    }
    public void showProgress() {
        System.out.println("Generic course progress.");
    }
}

class VideoCourse extends Course {
    int completionPercent; double watchTime;
    public VideoCourse(String t, String i, int cp, double wt) {
        super(t, i); completionPercent = cp; watchTime = wt;
    }
    @Override
    public void showProgress() {
        System.out.println(title + " (Video) -> " + completionPercent + "% watched, Time: " + watchTime + " hrs");
    }
}

class InteractiveCourse extends Course {
    int quizScore; int projectsCompleted;
    public InteractiveCourse(String t, String i, int qs, int pc) {
        super(t, i); quizScore = qs; projectsCompleted = pc;
    }
    @Override
    public void showProgress() {
        System.out.println(title + " (Interactive) -> Quiz: " + quizScore + "%, Projects: " + projectsCompleted);
    }
}

public class OnlineLearning {
    public static void main(String[] args) {
        Course c1 = new VideoCourse("Java Basics", "Dr. A", 75, 5);
        Course c2 = new InteractiveCourse("Data Structures", "Prof. B", 85, 3);

        c1.showProgress();  // overridden
        c2.showProgress();
    }
}

