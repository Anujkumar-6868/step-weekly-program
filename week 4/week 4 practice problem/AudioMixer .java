public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor
    public AudioMixer() {
        this("StandardMix-8", 8, false);
    }

    // Two-parameter constructor
    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false);
    }

    // Three-parameter constructor
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }

    // Main constructor
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;
        System.out.println("AudioMixer " + mixerModel + " initialized.");
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        AudioMixer m1 = new AudioMixer(); // no-arg
        AudioMixer m2 = new AudioMixer("ProMix-16", 16); // two-arg
        AudioMixer m3 = new AudioMixer("BTMix-12", 12, true); // three-arg
        AudioMixer m4 = new AudioMixer("MaxMix-24", 24, true, 150.0); // full

        m1.connectDevice("Microphone");
        m2.connectDevice("Keyboard");
        m3.connectDevice("Guitar");
        m4.connectDevice("Drum Machine");

        m1.displayMixerStatus();
        m2.displayMixerStatus();
        m3.displayMixerStatus();
        m4.displayMixerStatus();

        System.out.println("\nNote: Constructors executed in chained order (no-arg → 3-param → full).");
    }
}
