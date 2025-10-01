// File: SmartHome.java
abstract class SmartDevice { public abstract void control(); }

class SmartTV extends SmartDevice {
    public void control() { System.out.println("TV -> Channels & Streaming."); }
    public void setVolume() { System.out.println("Volume adjusted."); }
}
class SmartThermostat extends SmartDevice {
    public void control() { System.out.println("Thermostat -> Temperature controlled."); }
}
class SmartSecurity extends SmartDevice {
    public void control() { System.out.println("Security -> Cameras & Alarms."); }
}
class SmartKitchen extends SmartDevice {
    public void control() { System.out.println("Kitchen -> Cooking automation."); }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice[] devices = { new SmartTV(), new SmartThermostat(), new SmartSecurity() };
        
        for(SmartDevice d : devices) {
            d.control();
            if(d instanceof SmartTV) {
                ((SmartTV)d).setVolume();  // Safe downcasting
            }
        }
    }
}

