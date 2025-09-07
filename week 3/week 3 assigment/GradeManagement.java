// Assignment4_GradeManagement.java
class Subject {
    String code, name;
    int credits;
    String instructor;

    Subject(String c, String n, int cr, String i) {
        code = c; name = n; credits = cr; instructor = i;
    }
}

class Student {
    String studentId, studentName, className;
    String[] subjects;
    double[][] marks; 
    double gpa;

    static int totalStudents = 0;
    static String schoolName = "Sunrise School";

    Student(String id, String name, String cls, String[] subs) {
        studentId = id; studentName = name; className = cls;
        subjects = subs;
        marks = new double[subs.length][3]; 
        totalStudents++;
    }

    void addMarks(String subject, double m1, double m2, double m3) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                marks[i][0] = m1; marks[i][1] = m2; marks[i][2] = m3;
            }
        }
    }

    void calculateGPA() {
        double total = 0; int count = 0;
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        gpa = total / count / 10; 
    }

    void generateReportCard() {
        System.out.println("\nReport Card: " + studentName);
        System.out.println("GPA: " + gpa);
    }
}

public class GradeManagement {
    public static void main(String[] args) {
        String[] subs = {"Math", "Science", "English"};
        Student s1 = new Student("S1", "Ravi", "10A", subs);
        s1.addMarks("Math", 80, 90, 85);
        s1.addMarks("Science", 75, 70, 80);
        s1.addMarks("English", 88, 92, 85);
        s1.calculateGPA();
        s1.generateReportCard();
    }
}
