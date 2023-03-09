import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    // editor components
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel fontLabel;
    JSpinner fontSizeSpinner;
    JButton fontColorButton;
    JComboBox fontBox;
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

        // colors button
        fontColorButton = new JButton("Color");
        fontColorButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontBox = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Calibri");

        this.add(fontLabel);
        this.add(fontSizeSpinner);
        this.add(fontColorButton);
        this.add(fontBox);
        this.add(scrollPane);
        this.setVisible(true);
        //to center the window on lunch
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fontColorButton) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose a color", Color.black);

            textArea.setForeground(color);
        }

        if(e.getSource()==fontBox) {
            textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }
    }
}
