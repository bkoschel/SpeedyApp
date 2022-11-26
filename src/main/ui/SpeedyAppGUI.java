package ui;

import model.*;
import model.Event;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

// many methods used in this class were from the Tutorials and Demos found at
// https://docs.oracle.com/javase/tutorial/uiswing/index.html
// constructs a GUI for the SpeedyApp
public class SpeedyAppGUI implements ListSelectionListener {

    private JList<String> list;
    private final DefaultListModel<String> listModel;

    private JPanel mainPanel;
    private JFrame frame;
    private JTextPane exercisePane;

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
    private JButton save;
    private JButton load;
    private AddExerciseListener addExerciseListener;

    private static final String JSON_FILE = "./data/exerciseLog.json";
    private final JsonReader jsonReader;
    private final JsonWriter jsonWriter;

    private JFrame gifFrame;
    private JLabel gifLabel;
    private JPanel gifPanel;

    private final Color customColor;

    // EFFECTS: constructs a SpeedyApp interface
    public SpeedyAppGUI() {
        listModel = new DefaultListModel<>();
        exerciseLog = new ExerciseLog();

        jsonReader = new JsonReader(JSON_FILE);
        jsonWriter = new JsonWriter(JSON_FILE);

        customColor = new Color(98,216,172);

        createGUI();
    }

    // MODIFIES: this
    // EFFECTS: creates a JFrame, initializes all  components of the Speedy app and
    // adds them to the JFrame
    public void createGUI() {
        frame = new JFrame("SpeedyApp");

        createStartUpAnimation();
        initiateButtons();
        initializeJTextFields();
        createMainPanel();

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(logEvents());
    }


    // MODIFIES: this
    // EFFECTS: generates an exercise panel
    private JPanel createExercisePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(1,1));
        panel.setBackground(customColor);
        createExercisePane(panel);
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: initializes the exercise panel
    private void createExercisePane(JPanel panel) {
        exercisePane = new JTextPane();
        panel.add(exercisePane);
    }

    // MODIFIES: this
    // EFFECTS: initializes all buttons in the program
    private void initiateButtons() {
        createAddExerciseButton();
        createRemoveExerciseButton();
        saveButton();
        loadButton();
    }

    // MODIFIES: this
    // EFFECTS: constructs the main panel of the JFrame and adds each sub panel
    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanel.setLayout(new GridLayout(1,1));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel activityPanel = createActivityPanel();
        JPanel listPanel = createListPanel();
        JPanel buttonPanel = createButtonPanel();
        JPanel exercisePanel = createExercisePanel();

        mainPanel.add(activityPanel);
        mainPanel.add(listPanel);
        mainPanel.add(exercisePanel);
        mainPanel.add(buttonPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates a panel for an exercise to be added
    private JPanel createActivityPanel() {
        JPanel activityPanel = new JPanel();
        activityPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        activityPanel.setLayout(new GridLayout(1,1));
        activityPanel.setBackground(customColor);
        JPanel activityTitles = createTitlesAndText();
        activityPanel.add(activityTitles);
        return activityPanel;
    }

    // MODIFIES: this
    // EFFECTS: constructs the JTextFields and Titles for the exercise panel
    private JPanel createTitlesAndText() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        createTitle(panel);
        createDate(panel);
        createDistance(panel);
        createDuration(panel);
        createPace(panel);
        createElevation(panel);
        createActivity(panel);

        return panel;
    }

    // MODIFIES: this
    // EFFECTS: creates a JLabel for title and adds it to the panel
    public void createTitle(JPanel panel) {
        JLabel titleTitle = new JLabel("Title");
        panel.add(titleTitle);
        panel.add(this.title);
    }

    // MODIFIES: this
    // EFFECTS: creates a JLabel for date and adds it to the panel
    public void createDate(JPanel panel) {
        JLabel dateTitle = new JLabel("Date (mm/dd/yyy)");
        panel.add(dateTitle);
        panel.add(this.date);
    }

    // MODIFIES: this
    // EFFECTS: creates a JLabel for distance and adds it to the panel
    public void createDistance(JPanel panel) {
        JLabel distanceTitle = new JLabel("Distance in Kilometers (format as a decimal)");
        panel.add(distanceTitle);
        panel.add(this.distance);
    }

    // MODIFIES: this
    // EFFECTS: creates a JLabel for duration and adds it to the panel
    public void createDuration(JPanel panel) {
        JLabel durationTitle = new JLabel("Duration (format at HH:MM:SS)");
        panel.add(durationTitle);
        panel.add(this.duration);
    }

    // MODIFIES: this
    // EFFECTS: creates a JLabel for pace and adds it to the panel
    public void createPace(JPanel panel) {
        JLabel paceTitle = new JLabel("Pace in min/km (format as a decimal");
        panel.add(paceTitle);
        panel.add(this.pace);
    }

    // MODIFIES: this
    // EFFECTS: creates a JLabel for elevation and adds it to the panel
    public void createElevation(JPanel panel) {
        JLabel elevationTitle = new JLabel("Elevation in Meters (format as an integer)");
        panel.add(elevationTitle);
        panel.add(this.elevation);
    }

    // MODIFIES: this
    // EFFECTS: creates a JLabel for activity and adds it to the panel
    public void createActivity(JPanel panel) {
        JLabel typeTitle = new JLabel("Activity Type (type: bike, run, or swim)");
        panel.add(typeTitle);
        panel.add(this.activity);

    }

    // MODIFIES: this
    // EFFECTS: creates the exercise log list panel
    private JPanel createListPanel() {
        JPanel listPanel = new JPanel();
        listPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        listPanel.setLayout(new GridLayout(1,1));
        listPanel.setBackground(customColor);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane listPane = createList();
        listPanel.add(listPane);
        return listPanel;
    }

    // MODIFIES: this
    // EFFECTS: creates a list and assigns it to the exercise log scroll panel
    private JScrollPane createList() {
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        return new JScrollPane(list);
    }

    // MODIFIES: this
    // EFFECTS: creates a button panel containing all buttons
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.setBackground(customColor);
        buttonPanel.add(add);
        buttonPanel.add(remove);
        buttonPanel.add(save);
        buttonPanel.add(load);
        return buttonPanel;
    }

    // MODIFIES: this
    // EFFECTS: sets an action command and action listener to a button
    private void initializeButtons(JButton button, String string, ActionListener actionListener) {
        button.setActionCommand(string);
        button.addActionListener(actionListener);
    }

    // MODIFIES: this
    // EFFECTS: initializes the add exercise button and its listener
    private void createAddExerciseButton() {
        add = new JButton("Add Exercise");
        addExerciseListener = new AddExerciseListener(add);
        initializeButtons(add,"Add Exercise", addExerciseListener);
        add.setEnabled(false);
    }

    // MODIFIES: this
    // EFFECTS: initializes the remove exercise button and its listener
    private void createRemoveExerciseButton() {
        remove = new JButton("Remove Exercise");
        RemoveExerciseListener removeExerciseListener = new RemoveExerciseListener();
        initializeButtons(remove, "Remove Exercise", removeExerciseListener);
        remove.setEnabled(false);
    }

    // MODIFIES: this
    // EFFECTS: initializes the save button and adds its action listener
    private void saveButton() {
        save = new JButton("Save Exercise Log");
        SaveListener saveListener = new SaveListener();
        initializeButtons(save,"Save Exercise", saveListener);
        save.setEnabled(true);
    }

    // MODIFIES: this
    // EFFECTS: initializes the load button and adds its action listen
    private void loadButton() {
        load = new JButton("Load Exercise Log");
        LoadListener loadListener = new LoadListener();
        initializeButtons(load,"Load Exercise Log", loadListener);
        load.setEnabled(true);
    }

    // MODIFIES: this
    // EFFECTS: initializes text fields for each part of an exercise, title, date, distance, duration,
    //          pace, elevation and activity
    private void initializeJTextFields() {
        initializeTitleJTextField();
        initializeDateJTextField();
        initializeDistanceJTextField();
        initializeDurationJTextField();
        initializePaceJTextField();
        initializeElevationJTextField();
        initializeActivityJTextField();
    }

    // MODIFIES: this
    // EFFECTS: constructs the activity JTextField
    private void initializeActivityJTextField() {
        activity = new JTextField();
        activity.addActionListener(addExerciseListener);
        activity.getDocument().addDocumentListener(addExerciseListener);

    }

    // MODIFIES: this
    // EFFECTS: constructs the elevation JTextField
    private void initializeElevationJTextField() {
        elevation = new JTextField();
        elevation.addActionListener(addExerciseListener);
        elevation.getDocument().addDocumentListener(addExerciseListener);

    }

    // MODIFIES: this
    // EFFECTS: constructs the pace JTextField
    private void initializePaceJTextField() {
        pace = new JTextField();
        pace.addActionListener(addExerciseListener);
        pace.getDocument().addDocumentListener(addExerciseListener);

    }

    // MODIFIES: this
    // EFFECTS: constructs the duration JTextField
    private void initializeDurationJTextField() {
        duration = new JTextField();
        duration.addActionListener(addExerciseListener);
        duration.getDocument().addDocumentListener(addExerciseListener);

    }

    // MODIFIES: this
    // EFFECTS: constructs the distance JTextField
    private void initializeDistanceJTextField() {
        distance = new JTextField();
        distance.addActionListener(addExerciseListener);
        distance.getDocument().addDocumentListener(addExerciseListener);

    }

    // MODIFIES: this
    // EFFECTS: constructs the date JTextField
    private void initializeDateJTextField() {
        date = new JTextField();
        date.addActionListener(addExerciseListener);
        date.getDocument().addDocumentListener(addExerciseListener);

    }

    // MODIFIES: this
    // EFFECTS: constructs the title JTextField
    private void initializeTitleJTextField() {
        title = new JTextField();
        title.addActionListener(addExerciseListener);
        title.getDocument().addDocumentListener(addExerciseListener);

    }




    @Override
    // MODIFIES: this
    // EFFECTS: enables the remove button to be active
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            remove.setEnabled(list.getSelectedIndex() != -1);
            if (list.getSelectedIndex() == -1) {
                remove.setEnabled(false);
            } else {
                remove.setEnabled(true);
                displayExercise(listModel.get(list.getSelectedIndex()));
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: prints out the core parts of an exercise
    public void displayExercise(String title) {
        for (Exercise e: exerciseLog.getExerciseLog()) {
            if (e.getTitle().equals(title)) {
                String exercise = ("\nTitle: " + e.getTitle()
                        + "\nDate: " + e.getDate()
                        + "\nDistance: " + e.getDistance()
                        + "\nDuration: " + e.getDuration()
                        + "\nPace: " + e.getPace()
                        + "\nElevation: " + e.getElevation()
                        + "\nActivity: " + e.getActivity());
                exercisePane.setText(exercise);
            }
        }
    }

    // an action listener for the add button
    class AddExerciseListener implements ActionListener, DocumentListener {
        private boolean enabled = false;
        private final JButton button;

        // MODIFIES: this
        // EFFECTS: initiates the addExerciseButton
        public AddExerciseListener(JButton button) {
            this.button = button;
        }

        // MODIFIES: this
        // EFFECTS: assigns an exercise its activity type; adds an exercise of a given type to the beginning of the
        //          J list if the list is empty otherwise adds it to the end of the list; resets text fields
        //          makes the list visible
        @Override
        public void actionPerformed(ActionEvent e) {
            Exercise exercise;
            if (activity.getText().equals("bike")) {
                exercise = addBike();
            } else if (activity.getText().equals("swim")) {
                exercise = addSwim();
            } else {
                exercise = addRun();
            }

            exerciseLog.addExercise(exercise);

            int index = list.getSelectedIndex();
            if (index == -1) {
                index = 0;
            } else {
                index++;
            }

            listModel.insertElementAt(title.getText(), index);

            resetTextField();

            selectAndMakeVisible(index);
        }

        // MODIFIES: this
        // EFFECTS: resets the text fields
        public void resetTextField() {
            SpeedyAppGUI.this.title.requestFocusInWindow();
            SpeedyAppGUI.this.title.setText("");
            SpeedyAppGUI.this.date.requestFocusInWindow();
            SpeedyAppGUI.this.date.setText("");
            SpeedyAppGUI.this.distance.requestFocusInWindow();
            SpeedyAppGUI.this.distance.setText("");
            SpeedyAppGUI.this.duration.requestFocusInWindow();
            SpeedyAppGUI.this.duration.setText("");
            SpeedyAppGUI.this.pace.requestFocusInWindow();
            SpeedyAppGUI.this.pace.setText("");
            SpeedyAppGUI.this.elevation.requestFocusInWindow();
            SpeedyAppGUI.this.elevation.setText("");
            SpeedyAppGUI.this.activity.requestFocusInWindow();
            SpeedyAppGUI.this.activity.setText("");
        }

        // MODIFIES: this
        // EFFECTS: makes the list of exercises visible
        public void selectAndMakeVisible(int index) {
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        // MODIFIES: this
        // EFFECTS: constructs a swim instance
        public Swim addSwim() {
            Swim exercise = new Swim();
            exercise.setTitle(title.getText());
            exercise.setDate(date.getText());
            exercise.setDistance(Double.parseDouble(distance.getText()));
            exercise.setDuration(duration.getText());
            exercise.setPace(Double.parseDouble(pace.getText()));
            exercise.setElevation(Integer.parseInt(elevation.getText()));
            return exercise;
        }

        // MODIFIES: this
        // EFFECTS: constructs a bike instance
        public Bike addBike() {
            Bike exercise = new Bike();
            exercise.setTitle(title.getText());
            exercise.setDate(date.getText());
            exercise.setDistance(Double.parseDouble(distance.getText()));
            exercise.setDuration(duration.getText());
            exercise.setPace(Double.parseDouble(pace.getText()));
            exercise.setElevation(Integer.parseInt(elevation.getText()));
            return exercise;
        }

        // MODIFIES: this
        // EFFECTS: constructs a run instance
        public Run addRun() {
            Run exercise = new Run();
            exercise.setTitle(title.getText());
            exercise.setDate(date.getText());
            exercise.setDistance(Double.parseDouble(distance.getText()));
            exercise.setDuration(duration.getText());
            exercise.setPace(Double.parseDouble(pace.getText()));
            exercise.setElevation(Integer.parseInt(elevation.getText()));
            return exercise;
        }

        // MODIFIES: this
        // EFFECTS: creates a notification that something was inserted into the document
        @Override
        public void insertUpdate(DocumentEvent e) {
            if (!enabled) {
                button.setEnabled(true);
            }
        }

        // MODIFIES: this
        // EFFECTS: creates a notification that some part of the document has been removed
        @Override
        public void removeUpdate(DocumentEvent e) {
            emptyTextField(e);
        }

        // MODIFIES: this
        // EFFECTS: do not enable button unless text field is not empty
        private boolean emptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                enabled = false;
                return true;
            }
            return false;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            if (!emptyTextField(e)) {
                if (!enabled) {
                    button.setEnabled(true);
                }
            }
        }
    }

    // remove exercise listener
    class RemoveExerciseListener implements ActionListener {

        // MODIFIES: this
        // EFFECTS: removes a selected item from the list
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            listModel.remove(index);

            Exercise exercise = exerciseLog.getExerciseLog().get(index);
            exerciseLog.removeExercise(exercise);

            int size = listModel.getSize();


            if (size == 0) {
                remove.setEnabled(false);
                exercisePane.setText("");
                exercisePane.setVisible(true);
            } else {
                if (index == listModel.getSize()) {
                    index--;
                }

                selectAndMakeVisible(index);

            }


        }

        // MODIFIES: this
        // EFFECTS: makes the list of exercises visible
        public void selectAndMakeVisible(int index) {
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
    }

    // save button listener
    class SaveListener implements ActionListener {
        // MODIFIES: this
        // EFFECTS: when the save button is pressed opens, and writes to a JSON file of the current exercise log
        public void actionPerformed(ActionEvent e) {
            try {
                jsonWriter.open();
                jsonWriter.write(exerciseLog);
                jsonWriter.close();
            } catch (IOException i) {
                System.out.println("Unable to save to" + JSON_FILE + " Json file");
            }
        }
    }

    // load button listener
    class LoadListener implements ActionListener {
        // MODIFIES: this
        // EFFECTS: when the load button is pressed reads from a JSON file and loads the exercise log
        //          to display panel
        public void actionPerformed(ActionEvent e) {
            try {
                exerciseLog = jsonReader.read();
                for (Exercise exercise: exerciseLog.getExerciseLog()) {
                    listModel.insertElementAt(exercise.getTitle(), listModel.size());
                }
            } catch (IOException i) {
                System.out.println("Unable to load " + JSON_FILE);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a loading screen gif
    private void createStartUpAnimation() {
        gifFrame = new JFrame();
        createGif();

        gifFrame.add(gifPanel);
        gifFrame.pack();
        gifFrame.setLocationRelativeTo(null);
        gifFrame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates a gif
    private void createGif() {
        initializeGif();
        createGifLabel();
    }

    // MODIFIES: this
    // EFFECTS: creates a gif title
    private void createGifLabel() {
        JLabel label = new JLabel("SpeedyApp");
        label.setAlignmentX(0.5f);
        label.setAlignmentY(0.5f);
        gifPanel.add(label);
        gifLabel.setAlignmentX(0.5f);
        gifPanel.add(gifLabel);
    }

    // MODIFIES: this
    // EFFECTS: initializes the gif
    private void initializeGif() {
        ImageIcon gif = new ImageIcon("./data/hipster_runner.gif");
        gifLabel = new JLabel(gif);
        gifFrame = new JFrame();
        gifPanel = new JPanel();

        LayoutManager layoutManager = new OverlayLayout(gifPanel);
        gifPanel.setLayout(layoutManager);
    }

    private WindowAdapter logEvents() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (Event el: EventLog.getInstance()) {
                    System.out.println(el.getDescription());
                }
            }
        };
    }
}
