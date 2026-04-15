package Staff;

public class StaffAppointment {
    private String bookingId;
    private String customerId;
    private String customerName;
    private String customerPhone;
    private String doctorId;
    private String doctorName;
    private String doctorPhone;
    private String appointmentTime;

    public StaffAppointment(String bookingId, String customerId, String customerName,
                            String customerPhone, String doctorId, String doctorName,
                            String doctorPhone, String appointmentTime) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
        this.appointmentTime = appointmentTime;
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getCustomerPhone() { return customerPhone; }
    public String getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public String getDoctorPhone() { return doctorPhone; }
    public String getAppointmentTime() { return appointmentTime; }

    public String toFileString() {
        return bookingId + "," + customerId + "," + customerName + "," + customerPhone + ","
                + doctorId + "," + doctorName + "," + doctorPhone + "," + appointmentTime;
    }

    public static StaffAppointment fromFileString(String line) {
        String[] parts = line.split(",");
        return new StaffAppointment(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                parts[7]
        );
    }
}
