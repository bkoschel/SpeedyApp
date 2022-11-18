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
        return new JMenuItem("Save Exercise Log");
    }

    private static JMenuItem loadMenuItem() {
        return new JMenuItem("Load Exercise Log");
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

    private JPanel createTitlesAndText() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel titleTitle = createTitle();
        JPanel dateTitle = createDate();
        JPanel distanceTitle = createDistance();
        JPanel durationTitle = createDuration();
        JPanel paceTitle = createPace();
        JPanel elevationTitle = createElevation();
        JPanel typeTitle = createActivity();
        panel.add(titleTitle);
        panel.add(typeTitle);
        panel.add(dateTitle);
        panel.add(distanceTitle);
        panel.add(durationTitle);
        panel.add(paceTitle);
        panel.add(elevationTitle);
        return panel;
    }

    private JPanel createTitle() {
        JPanel titleTitle = createBorderTitles("Title", title);
        return titleTitle;
    }

    private JPanel createDate() {
        JPanel dateTitle = createBorderTitles("Date", date);
        return dateTitle;
    }

    private JPanel createDistance() {
        JPanel distanceTitle = createBorderTitles("Distance", distance);
        return distanceTitle;
    }

    private JPanel createDuration() {
        JPanel durationTitle = createBorderTitles("Duration", duration);
        return durationTitle;
    }

    private JPanel createPace() {
        JPanel paceTitle = createBorderTitles("Pace", pace);
        return paceTitle;
    }

    private JPanel createElevation() {
        JPanel elevationTitle = createBorderTitles("Elevation", elevation);
        return elevationTitle;
    }

    private JPanel createActivity() {
        JPanel activityTitle = createBorderTitles("Activity Type", activity);
        return activityTitle;
    }

    private JPanel createBorderTitles(String title, JTextField textField) {
        JPanel titledBorders = new JPanel();
        titledBorders.setLayout(new BoxLayout(titledBorders, BoxLayout.Y_AXIS));
        TitledBorder titled;
        titled = BorderFactory.createTitledBorder(title);
        addCompForBorder(titled, titledBorders, textField);
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

    private void displayActivity(String title) {
        for (Exercise e: exerciseLog.getExerciseLog()) {
            if (e.getTitle().equals(title)) {
                JTextArea exercise = new JTextArea("\nActivity Title: " + e.getTitle()
                                                 + "\nDate: " + e.getDate()
                                                 + "\nDistance: " + e.getDistance()
                                                 + "\nDuration: " + e.getDuration()
                                                 + "\nPace: " + e.getPace()
                                                 + "\nElevation: " + e.getElevation()
                                                 + "\nActivity Type: " + e.getActivity());
                activityDisplayPanel.add(exercise);
            }
        }

    }


    private JPanel createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.setBackground(Color.green);
        return buttonPanel;
    }

    private void createAddExerciseButton() {

    }


    static void addCompForBorder(Border border,
                                 Container container,
                                 JTextField textField) {
        JPanel comp = new JPanel(new GridLayout(1, 1), false);
        textField = new JTextField();
        // textField.addActionListener(addExerciseListener);
        //textField.getDocument().addDocumentListener(addExerciseListener);
        comp.add(textField);
        comp.setBorder(border);

        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(comp);
    }



    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

     
}
