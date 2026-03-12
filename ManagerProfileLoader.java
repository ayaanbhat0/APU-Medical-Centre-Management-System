package Doctor;

public class Patient {
    private String id;
    private String name;
    private String treatment;

    public Patient(String id, String name, String treatment) {
        this.id = id;
        this.name = name;
        this.treatment = treatment;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getTreatment() { return treatment; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + treatment + ")";
    }
}