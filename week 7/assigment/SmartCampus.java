// File: SmartCampus.java
class Device {
    void status() {
        System.out.println("Device is online.");
    }
}

class SmartClassroom extends Device {
    void control() {
        System.out.println("Classroom: Lights, AC, Projectors controlled.");
    }
}

class SmartLab extends Device {
    void manage() {
        System.out.println("Lab: Equipment & Safety systems managed.");
    }
}

class SmartLibrary extends Device {
    void track() {
        System.out.println("Library: Occupancy & book availability tracked.");
    }
}

public class SmartCampus {
    public static void main(String[] args) {
        Device[] devices = { new SmartClassroom(), new SmartLab(), new SmartLibrary() };

        for (Device d : devices) {
            d.status();

            if (d instanceof SmartClassroom) {
                ((SmartClassroom) d).control();
            } else if (d instanceof SmartLab) {
                ((SmartLab) d).manage();
            } else if (d instanceof SmartLibrary) {
                ((SmartLibrary) d).track();
            }
        }
    }
}

