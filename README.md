# *Speedy*: A Digital Exercise Log

 *Speedy* is a Java based exercise diary used to log runs, cycling and swimming data. Athletes will be able to add 
 workout statistics like distance, duration, speed, and average heart rate. This will allow users to track their 
 workouts over time and see improvements in their fitness. This project is of interest to me
because I am a runner and I enjoy being able to track my progress in my favourite sport.

## User Stories:
- **As a User I want to be able to:** add a run to my exercise log.
- **As a User I want to be able to:** add a bike ride to my exercise log.
- **As a User I want to be able to:** add a swim to my exercise log.
- **As a User I want to be able to:** view my exercise log
- **As a User I want to be able to:** select a particular activity and view its data.
- **As a User I want to be able to:** remove a run, bike or swim from my exercise log using the activity's title.
- **As a User I want to be able to:** add data such as date, distance, duration and pace to a run/bike/swim 
  entry.
- **As a User I want to be able to:** edit the data of a run, bike or swim in my exercise log.
- **As a User I want to be able to:** give my exercises fun names (e.g. The Coquitlam Crunch).
- **As a User I want to be able to:** view my average pace for all my bike rides, runs, and swims.
- **As a User I want to be able to:** view my total distance for all my bike rides, runs, and swims.
- **As a User I want to be able to:** view my total elevation for all my bike rides and runs (swims do not apply)

- **As a User I want to be able to:** save their exercise log.
- **As a User I want to be able to:** load an exercise log


# Instructions for Grader

- You can generate the first required event related to adding Xs to a Y (add an exercise to the exercise log) by:
  - carefully fill out the text fields required to create an exercise based on their specifications
  - hit tab after every input or click on the next text box
  - click the add exercise button at the bottom of the screen
- You can generate the second required event related to adding Xs to a Y (remove an exercise from the exercise log) by:
  - click on the exercise you wish to remove
  - click the remove exercise button at the bottom of the screen
- You can locate my visual component by running the program
- You can save the state of my application by clicking the save button and then closing the program
- You can reload the state of my application by clicking the load button


# Phase 4: Task 2
Tempo Run was added to the exercise log.
Short Swim was added to the exercise log.
Short Swim was removed to the exercise log.
Bike Ride was added to the exercise log.
Bike Ride was removed to the exercise log.
Tempo Run was removed to the exercise log.

# Phase 4: Task 3 
If I had more time to work on this project I would change a few things. Firstly, there is a lot of duplication in 
almost all of my code. I would fix this by making the Exercise class abstract. I would then use the Composite Design 
Pattern to simplify and organize my code. I would make ExerciseLog be the Composite, Exercise be the Component and any 
of the exercise (such as Bike or Swim) be the Leaves. 
