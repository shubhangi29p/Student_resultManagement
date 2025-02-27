package studentmanagemnent;

import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
public class StudentResultManagementSystem extends JFrame implements ActionListener {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JLabel nameLabel, rollNumberLabel, subjectLabel, marksLabel;
 private JTextField nameTextField, rollNumberTextField, marksTextField;
 private JComboBox<String> subjectComboBox;
 private JButton addResultButton, showResultButton;
 private JTextArea resultTextArea;
 private HashMap<String, HashMap<String, Integer>> studentData;
 private String[] subjectList = {"java", "python", "math", "cyber security", "c++"};
public StudentResultManagementSystem() {
 setTitle("Student Result Management System");
 setLayout(null);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 studentData = new HashMap<>();
 nameLabel = new JLabel("Name:");
 rollNumberLabel = new JLabel("Roll Number:");
 subjectLabel = new JLabel("Subject:");
 marksLabel = new JLabel("Marks");
 nameTextField = new JTextField();
 rollNumberTextField = new JTextField();
 marksTextField = new JTextField();
 subjectComboBox = new JComboBox<>(subjectList);
 addResultButton = new JButton("Add Result");
 showResultButton = new JButton("Show Results");
 resultTextArea = new JTextArea();
 nameLabel.setBounds(20, 20, 80, 25);
 rollNumberLabel.setBounds(20, 50, 80, 25);
 subjectLabel.setBounds(20, 80, 80, 25);
 marksLabel.setBounds(20, 110, 80, 25);
 nameTextField.setBounds(100, 20, 150, 25);
 rollNumberTextField.setBounds(100, 50, 150, 25);
 subjectComboBox.setBounds(100, 80, 150, 25);
 marksTextField.setBounds(100, 110, 150, 25);
 addResultButton.setBounds(20, 140, 120, 30);
 showResultButton.setBounds(150, 140, 120, 30);
 resultTextArea.setBounds(20, 180, 250, 150);
 addResultButton.addActionListener(this);
 showResultButton.addActionListener(this);
 add(nameLabel);
 add(rollNumberLabel);
 add(subjectLabel);
 add(marksLabel);
 add(nameTextField);
 add(rollNumberTextField);
 add(subjectComboBox);
 add(marksTextField);
 add(addResultButton);
 add(showResultButton);
 add(resultTextArea);
 setSize(300, 350);
 setVisible(true);
 }
 public void actionPerformed(ActionEvent e) {
if (e.getSource() == addResultButton) {
 String name = nameTextField.getText();
 String rollNumber = rollNumberTextField.getText();
 String subject = (String) subjectComboBox.getSelectedItem();
 String marksStr = marksTextField.getText();
 if (name.isEmpty() || rollNumber.isEmpty()) {
 JOptionPane.showMessageDialog(this, "Name and Roll Number are required fields.");
 } else if (subject.isEmpty() || marksStr.isEmpty()) {
 JOptionPane.showMessageDialog(this, "Subject and Marks are required fields.");
 } else {
 int marks = Integer.parseInt(marksStr);
 if (!studentData.containsKey(rollNumber)) {
 studentData.put(rollNumber, new HashMap<>());
 }
 studentData.get(rollNumber).put(subject, marks);
 nameTextField.setText("");
 rollNumberTextField.setText("");
 subjectComboBox.setSelectedIndex(0);
 marksTextField.setText("");
 }
 } else if (e.getSource() == showResultButton) {
 resultTextArea.setText("");
 for (String rollNumber : studentData.keySet()) {
resultTextArea.append("Roll Number: " + rollNumber + "\n");
 HashMap<String, Integer> subjects = studentData.get(rollNumber);
 int totalMarks = 0;
 for (String subject : subjects.keySet()) {
 int marks = subjects.get(subject);
 resultTextArea.append("Subject: " + subject + ", Marks: " + marks + "\n");
 totalMarks += marks;
 }
 double percentage = (double) totalMarks / (subjects.size() * 100) * 100;
 resultTextArea.append("Total Marks: " + totalMarks + ", Percentage: " + 
String.format("%.2f", percentage) + "%\n\n");
 }
 }
 }
 public static void main(String[] args) {
 new StudentResultManagementSystem();
 }
}