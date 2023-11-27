import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("Student data saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving student data to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Student data loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading student data from file: " + e.getMessage());
        }
    }
}

public class studentmngtsys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        int choice;

        do {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");

            System.out.print("Enter your choice (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // Remove Student
                    System.out.print("Enter roll number of the student to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    sms.removeStudent(removeRollNumber);
                    System.out.println("Student removed successfully.");
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter roll number of the student to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = sms.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Display All Students
                    sms.displayAllStudents();
                    break;

                case 5:
                    // Save to File
                    System.out.print("Enter the file name to save student data: ");
                    String saveFileName = scanner.nextLine();
                    sms.saveToFile(saveFileName);
                    break;

                case 6:
                    // Load from File
                    System.out.print("Enter the file name to load student data: ");
                    String loadFileName = scanner.nextLine();
                    sms.loadFromFile(loadFileName);
                    break;

                case 7:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }

        } while (choice != 7);
    }
}
