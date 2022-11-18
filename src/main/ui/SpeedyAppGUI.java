package ui;

import model.Exercise;
import model.ExerciseLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.SplitPaneUI;
import java.awt.*;

public class SpeedyAppGUI implements ListSelectionListener {

    private JFrame frame;
    private JList list;
    private DefaultListModel<String> listModel;

    private JPanel mainPanel;
    private JPanel activityPanel;
    private JPanel listPanel;
    private JPanel activityDisplayPanel;
    private JPanel buttonPanel;

    private ExerciseLog exerciseLog;
    private JTextField title;
    private JTextField date;
    private JTextField distance;
    private JTextField duration;
    private JTextField pace;
    private JTextField elevation;
    private JTextField activity;

    private JButton add;
    private JButton remove;

    private static String JSON_FILE = "./data/exerciseLog.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    public SpeedyAppGUI() {
        listModel = new DefaultListModel<>();
        exerciseLog = new ExerciseLog();

        jsonReader = new JsonReader(JSON_FILE);
        jsonWriter = new JsonWriter(JSON_FILE);

        createGUI();
    }

    public void createGUI() {
        this.frame = new JFrame("SpeedyApp");
        frame.setLocationRelativeTo(null);
        createMenu();
        mainPanel = createMainPanel();

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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

    private JPanel createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanel.setLayout(new GridLayout(1,1));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel activityPanel = createActivityPanel();
        JPanel listPanel = createListPanel();
        JPanel activityDisplay = createActivityDisplayPanel();
        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(activityPanel);
        mainPanel.add(listPanel);
        mainPanel.add(activityDisplay);
        mainPanel.add(buttonPanel);
        return mainPanel;
    }

    private JPanel createActivityPanel() {
        activityPanel = new JPanel();
        activityPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        activityPanel.setLayout(new GridLayout(1,1));
        activityPanel.setBackground(Color.BLUE);
        JPanel activityTitles = createTitlesAndText();
        activityPanel.add(activityTitles);
        return activityPanel;
    }

    private static JPanel createTitlesAndText() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel titleTitle = createBorderTitles("Title");
        JPanel typeTitle = createBorderTitles("Activity Type");
        JPanel dateTitle = createBorderTitles("Date");
        JPanel distanceTitle = createBorderTitles("Distance");
        JPanel durationTitle = createBorderTitles("Duration");
        JPanel paceTitle = createBorderTitles("Pace");
        JPanel elevationTitle = createBorderTitles("Elevation");
        panel.add(titleTitle);
        panel.add(typeTitle);
        panel.add(dateTitle);
        panel.add(distanceTitle);
        panel.add(durationTitle);
        panel.add(paceTitle);
        panel.add(elevationTitle);
        return panel;
    }

    private static JPanel createBorderTitles(String title) {
        JPanel titledBorders = new JPanel();
        titledBorders.setLayout(new BoxLayout(titledBorders,
                BoxLayout.Y_AXIS));
        TitledBorder titled;

        titled = BorderFactory.createTitledBorder(title);
        addCompForBorder(titled,
                titledBorders);
        return titledBorders;
    }

    private JPanel createListPanel() {
        listPanel = new JPanel();
        listPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        listPanel.setLayout(new GridLayout(1,1));
        listPanel.setBackground(Color.RED);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane listPane = createList();
        listPanel.add(listPane);
        return listPanel;
    }

    private JScrollPane createList() {
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        return new JScrollPane(list);
    }

    private JPanel createActivityDisplayPanel() {
        activityDisplayPanel = new JPanel();
        activityDisplayPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        activityDisplayPanel.setLayout(new GridLayout(1,1));
        activityDisplayPanel.setBackground(Color.PINK);
        return activityDisplayPanel;
    }


    private JPanel createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.setBackground(Color.green);
        return buttonPanel;
    }

    void addCompForTitledBorder(TitledBorder border,
                                int justification,
                                int position,
                                Container container) {
        border.setTitleJustification(justification);
        border.setTitlePosition(position);
        addCompForBorder(border, container);
    }

    static void addCompForBorder(Border border,
                                 Container container) {
        JPanel comp = new JPanel(new GridLayout(1, 1), false);
        JTextField title = new JTextField();
        comp.add(title);
        comp.setBorder(border);

        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(comp);
    }



    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

     
}
