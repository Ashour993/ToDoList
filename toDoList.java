import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoList {
    public static DefaultListModel<String> toDoListModel = new DefaultListModel<>();
    public static JList<String> toDoList;
    public static JTextField taskField;
    public static JButton addButton;
    public static JButton doneButton;
    public static DoneList doneListWindow;

    public ToDoList() {
        toDoList = new JList<>(toDoListModel);

        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel toDoLabel = new JLabel("The List of To-Do Tasks");
        JScrollPane scrollPane = new JScrollPane(toDoList);

        taskField = new JTextField();
        addButton = new JButton("Add Task");
        doneButton = new JButton("Send to Done");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(doneButton);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(toDoLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setLocation(100, 100);
        frame.setVisible(true);

        // Lägg till uppgift i To-Do List
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    toDoListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        // Skicka markerad uppgift till Done List
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (doneListWindow == null) {
                    doneListWindow = new DoneList();
                }

                java.util.List<String> selectedTasks = toDoList.getSelectedValuesList();
                for (String task : selectedTasks) {
                    DoneList.doneListModel.addElement(task);
                    toDoListModel.removeElement(task);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoList());
    }
}
