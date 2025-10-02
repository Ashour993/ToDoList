import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import java.awt.BorderLayout;
public class doneList {

    public static DefaultListModel<String> doneListModel;
    public static JList<String> doneList;

    public doneList() {

        doneListModel = new DefaultListModel<>();
        doneList = new JList<>(doneListModel);

        JFrame frame = new JFrame ("Done List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);    

        JPanel mainpanel = new JPanel(new BorderLayout());
        JLabel donelabel = new JLabel("The List of completed tasks");
        JScrollPane donescrollpane = new JScrollPane(doneList);

        mainpanel.add(donelabel,BorderLayout.NORTH);
        mainpanel.add(donescrollpane, BorderLayout.CENTER);
        frame.add(mainpanel);
        frame.setLocation(1100, 100);
        frame.setVisible(true);

        
        
        

        



    }

    
}