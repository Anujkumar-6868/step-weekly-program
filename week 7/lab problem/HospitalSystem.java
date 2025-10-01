// File: HospitalSystem.java
class MedicalStaff {
    public void commonDuty() { System.out.println("Common duty: Shift scheduling & payroll."); }
}
class Doctor extends MedicalStaff {
    public void diagnose() { System.out.println("Doctor diagnosing patient."); }
}
class Nurse extends MedicalStaff {
    public void assist() { System.out.println("Nurse assisting procedure."); }
}
class Technician extends MedicalStaff {
    public void test() { System.out.println("Technician running tests."); }
}
class Administrator extends MedicalStaff {
    public void manageRecords() { System.out.println("Administrator managing records."); }
}

public class HospitalSystem {
    public static void main(String[] args) {
        MedicalStaff staff = new Doctor();  // Upcasting
        staff.commonDuty();  // Only parent methods directly accessible
        // staff.diagnose(); // ❌ Not allowed (compile-time error)
    }
}

