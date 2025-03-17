package studentpayment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JFrame {
    private JTextField firstNameField, lastNameField, addressField, idField;
    private JComboBox<String> studentTypeBox;
    private JTextField labHoursField, lectureHoursField, researchHoursField;
    private JLabel resultLabel;

    public PaymentGUI() {
        setTitle("Student Payment System");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Student Type:"));
        studentTypeBox = new JComboBox<>(new String[]{"UTA", "MTA", "PhDTAR"});
        add(studentTypeBox);

        add(new JLabel("Lab Hours:"));
        labHoursField = new JTextField();
        add(labHoursField);

        add(new JLabel("Lecture Hours:"));
        lectureHoursField = new JTextField();
        add(lectureHoursField);

        add(new JLabel("Research Hours (PhDTAR only):"));
        researchHoursField = new JTextField();
        add(researchHoursField);

        JButton calculateButton = new JButton("Calculate Monthly Payment");
        add(calculateButton);

        JButton calculateNineMonthButton = new JButton("Calculate Nine-Month Payment");
        add(calculateNineMonthButton);

        resultLabel = new JLabel("Payment: ");
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePayment(false);
            }
        });

        calculateNineMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePayment(true);
            }
        });
    }

    private void calculatePayment(boolean isNineMonth) {
        try {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String address = addressField.getText().trim();
            String id = idField.getText().trim();
            String type = (String) studentTypeBox.getSelectedItem();
           
            int labHours = Integer.parseInt(labHoursField.getText().trim().isEmpty() ? "0" : labHoursField.getText().trim());
            int lectureHours = Integer.parseInt(lectureHoursField.getText().trim().isEmpty() ? "0" : lectureHoursField.getText().trim());
            int researchHours = researchHoursField.getText().trim().isEmpty() ? 0 : Integer.parseInt(researchHoursField.getText().trim());
           
            Student student;
            if (type.equals("UTA")) {
                student = new UTA(lastName, firstName, address, id, labHours);
            } else if (type.equals("MTA")) {
                student = new MTA(lastName, firstName, address, id, labHours, lectureHours);
            } else {
                student = new PhDTAR(lastName, firstName, address, id, labHours, lectureHours, researchHours);
            }
           
            double payment = isNineMonth ? student.calculateNineMonthPayment() : student.calculateMonthlyPayment();
            // resultLabel.setText((isNineMonth ? "Nine-Month Payment: $" : "Monthly Payment: $") + payment);
            String result = "<html>Name: " + firstName+ " " + lastName+ 
                            "<br>ID: " + id + 
                            "<br>Address: " + address +
                            "<br>Student Type: " + student.getStudentType()+
                            "<br>" + (isNineMonth ? "Nine-Month Payment: $" : "Monthly Payment: $") +
                            String.format("%.2f", payment) + "</html>";
            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for hours.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaymentGUI().setVisible(true));
    }
}