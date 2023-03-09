import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    // editor components
    JTextArea textArea;
    JScrollPane scrollPane;
    Editor(){
        this.setTitle("CodeClause_Editor");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        //Text area Component
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(750, 550));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        //default font
        textArea.setFont(new Font("Calibri", Font.PLAIN, 18));

        //scroll pane component
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(750,550));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        
        this.add(scrollPane);
        this.setVisible(true);
        //to center the window on lunch
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
