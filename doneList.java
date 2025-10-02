import javax.swing.*;
import java.awt.*;

public class DoneList {
    public static DefaultListModel<String> doneListModel = new DefaultListModel<>();
    public static JList<String> doneList;

    public DoneList() {
        doneList = new JList<>(doneListModel);

        JFrame frame = new JFrame("Done List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel doneLabel = new JLabel("The List of Completed Tasks");
        JScrollPane scrollPane = new JScrollPane(doneList);

        mainPanel.add(doneLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setLocation(1100, 100);
        frame.setVisible(true);
    }
}
