# APU Medical Centre Management System

A comprehensive Java Swing-based application designed to manage operations at the APU Medical Centre. This system handles appointments, user management, payments, feedback, and reporting for multiple user roles including doctors, patients, staff, and managers.

## Features

- **User Authentication**: Secure login system for different user roles
- **Appointment Management**: Schedule, view, and manage medical appointments
- **Patient Management**: Maintain patient records and histories
- **Doctor Management**: Profile management and appointment handling for doctors
- **Staff Operations**: Customer management, payments, and administrative tasks
- **Payment Processing**: Handle billing and payment records
- **Feedback System**: Collect and manage patient feedback and reviews
- **Reporting**: Generate reports on various aspects of the medical centre operations
- **Data Persistence**: File-based storage for records (appointments, payments, histories, etc.)

## Technologies Used

- **Java**: Core programming language
- **Swing**: GUI framework for desktop application
- **Maven**: Build and dependency management
- **File I/O**: Text file-based data storage

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6 or higher

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ayaanbhat0/APU-Medical-Centre-Management-System.git
   cd APU-Medical-Centre-Management-System
   ```

2. Build the project using Maven:
   ```bash
   mvn clean compile
   ```

## Usage

Run the application using Maven:

```bash
mvn exec:java -Dexec.mainClass="loginSystem"
```

Or compile and run manually:

```bash
javac *.java
java loginSystem
```

### User Roles

- **Manager**: Administrative access to all system features
- **Doctor**: Manage appointments, view patient histories, provide feedback
- **Staff**: Handle customer management, payments, and appointments
- **Patient**: View appointments, provide feedback, manage profile

## Project Structure

- `loginSystem.java` - Main login interface
- `Dashboard.java` - Main dashboard
- `DoctorMainPage.java` - Doctor's main interface
- `StaffPage.java` - Staff management interface
- `ManagerApp.java` - Manager interface
- Various form files (.form) - GUI layouts designed with NetBeans
- Text files (.txt) - Data storage files

## Data Files

The application uses text files for data persistence:
- `appointments.txt` - Appointment records
- `customer.txt` - Customer/patient data
- `doctor.txt` - Doctor information
- `staff.txt` - Staff data
- `manager.txt` - Manager data
- `payment.txt` - Payment records
- History and feedback files for various entities

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Developed as part of APU coursework
- Built using Object-Oriented Programming principles
- Designed with UML diagrams
