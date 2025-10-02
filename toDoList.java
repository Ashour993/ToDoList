import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.BorderLayout;

public class toDoList {
   public static DefaultListModel<String> toDoListModel;
    public static JList<String> toDoList;


    public toDoList() {
        toDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(toDoListModel);

        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel mainpanel = new JPanel(new BorderLayout());
        JLabel toDolabel = new JLabel("The List of To-Do tasks");
        JScrollPane toDoscrollpane = new JScrollPane(toDoList);

        mainpanel.add(toDolabel, BorderLayout.NORTH);
        mainpanel.add(toDoscrollpane, BorderLayout.CENTER);
        frame.add(mainpanel);
        frame.setLocation(1100, 100);
        frame.setVisible(true);

    }

}
