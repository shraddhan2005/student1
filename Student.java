import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void displayNameAndAge(String dobStr) {
        LocalDate dob = null;
        try {
            if (dobStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                // Format: YYYY-MM-DD
                dob = LocalDate.parse(dobStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } else if (dobStr.matches("\\d{2}-\\d{2}-\\d{4}")) {
                // Format: DD-MM-YYYY
                dob = LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } else {
                System.out.println("Invalid date format");
                return;
            }

            LocalDate today = LocalDate.now();
            int age = Period.between(dob, today).getYears();

            System.out.println("Student Name: " + name);
            System.out.println("Age: " + age);

        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }
}
