import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    // editor components
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel fontLabel;
    JSpinner fontSizeSpinner;
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

        // font label and spinner
        fontLabel = new JLabel("Font: ");

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(100,25));
        fontSizeSpinner.setValue(18);
        fontSizeSpinner.addChangeListener(e -> textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue())));


        this.add(fontLabel);
        this.add(fontSizeSpinner);
        this.add(scrollPane);
        this.setVisible(true);
        //to center the window on lunch
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
