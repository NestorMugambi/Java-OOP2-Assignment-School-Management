package com.example.management;
import com.example.management.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentReportApp extends JFrame {
    private List<Student> students;
    private JTextField nameField, mathsField ,englishField ,scienceField;
    private JEditorPane reportArea;


    public StudentReportApp() {
        students = new ArrayList<>();

        setTitle("Student Report App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Student Name:");
        nameField = new JTextField();

        JLabel mathsLabel = new JLabel("Math marks:");
        mathsField = new JTextField();

        JLabel englishLabel = new JLabel("English Marks:");
        englishField = new JTextField();

        JLabel scienceLabel = new JLabel(" Science Marks:");
        scienceField = new JTextField();


        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });
        reportArea = new JTextPane();
        reportArea.setEditable(false);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(mathsLabel);
        panel.add(mathsField);

        panel.add(englishLabel);
        panel.add(englishField);

        panel.add(scienceLabel);
        panel.add(scienceField);


        panel.add(addStudentButton);
        panel.add(generateReportButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);
    }

    private void addStudent() {
        String name = nameField.getText();
        String mathText = mathsField.getText();
        String englishText = englishField.getText();
        String scienceText = scienceField.getText();



        if (!name.isEmpty() && !mathText.isEmpty() && !englishText.isEmpty() && !scienceText.isEmpty()) {
            try {
                double mathGrade = Double.parseDouble(mathText);
                double englishGrade = Double.parseDouble(englishText);
                double scienceGrade = Double.parseDouble(scienceText);
                
                students.add(new Student(name, mathGrade, englishGrade, scienceGrade));
                nameField.setText("");
                mathsField.setText("");
                englishField.setText("");
                scienceField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid marks format. Please enter a number.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both student name and marks.");
        }
    }


    private void generateReport() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students to generate a report.");
            return;
        }

        StringBuilder report = new StringBuilder("<html><body><h2>Student Report:</h2><br>");

        for (Student student : students) {
            report.append("<b>Name: </b>").append(student.getName()).append("<br><br>");
            report.append("<b>Math grade: </b>").append(student.getMathGrade()).append("<br><br>");
            report.append("<b>English grade: </b>").append(student.getEnglishGrade()).append("<br><br>");
            report.append("<b>Science grade: </b>").append(student.getScienceGrade()).append("<br><br>");
            report.append("<b>total: </b>").append(student.CalculateTotal()).append("<br><br>");
            report.append("<b>average: </b>").append(student.calculateAverage()).append("<br><br><br>");

        }
        report.append("</body></html>");
        reportArea.setContentType("text/html");

        reportArea.setText(report.toString());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new StudentReportApp().setVisible(true);
        });
    }



}
