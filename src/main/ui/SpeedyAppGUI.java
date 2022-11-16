package ui;

import model.ExerciseLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;

public class SpeedyAppGUI {

    private JFrame frame;
    private JList list;
    private DefaultListModel<String> listModel;

    private ExerciseLog exerciseLog;

    private static String JSON_FILE = "./data/exerciseLog.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    public SpeedyAppGUI() {
        createGUI();

    }

    public void createGUI() {
        this.frame = new JFrame("SpeedyApp");
        frame.setLocationRelativeTo(null);
        createMenu();
        JPanel activityPanel = createActivityPanel();
        JPanel listPanel = createListPanel();

        frame.add(activityPanel, BorderLayout.PAGE_START);
        frame.add(listPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel createActivityPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(1,1));
        panel.setBackground(Color.BLUE);
        return panel;
    }

    private static JPanel createListPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(1,1));
        panel.setBackground(Color.RED);
        return panel;
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem save = saveMenuItem();
        JMenuItem load = loadMenuItem();
        menu.add(save);
        menu.add(load);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    private static JMenuItem saveMenuItem() {
        JMenuItem save = new JMenuItem("Save Exercise Log");
        return save;
    }

    private static JMenuItem loadMenuItem() {
        JMenuItem load = new JMenuItem("Load Exercise Log");
        return load;
    }

}
