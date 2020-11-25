import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Animation;
import javafx.scene.paint.Color;
import java.util.*;
import javafx.event.EventType;
public class MyTest extends Application {
  private File myf2 = new File("./data", "result.txt");
 private File myf = new File("./data", "questions.txt");
 private int totQues = 0;
 private int activeQ = 1;
 private Label labQuesNo, labQues, labName;
 private String[] answers;
 private ImageView imgQues;
 private Label labA, labB, labC;
 private RadioButton radChoice1, radChoice2, radChoice3,rad;
 private ToggleGroup grpChoices;
 private Button btnPrev, btnNext, btnSubmit;
 private Pane mainPane;
 private Pane paneC;
 private Scene mainScene;
 private MyGreeting winGreeting;
 private MyFarewell winFarewell;
 private Timeline Timer;
 private Label labRemainingTime;
 private int minutes = 3;
 private int seconds = 1;
 private LinkedList<Question> quesList = new LinkedList<Question>();
 public void start(Stage mainStage) {
 mainStage.setTitle("Knowledge Test 1");
 Label labNameDesc = new Label("Name");
 labNameDesc.setLayoutX(25);
 labNameDesc.setLayoutY(25);
 labName = new Label("");
 labName.setLayoutX(75);
 labName.setLayoutY(25);
 labName.setStyle("-fx-pref-width: 100px;-fx-border-color:red;");
 labQuesNo = new Label("");
 labQuesNo.setLayoutX(25);
 labQuesNo.setLayoutY(75);
 labQuesNo.setStyle("-fx-font-family:serif;-fx-text-fill:#0000ff;");
labQues = new Label("");
 labQues.setLayoutX(25);
 labQues.setLayoutY(100);
 labQues.setStyle("-fx-font-size: 12pt;-fx-font-weight:bold;");
 imgQues = new ImageView();
 imgQues.setLayoutX(25);
 imgQues.setLayoutY(75);
 imgQues.setFitHeight(150);
 imgQues.setFitWidth(150);
 labA = new Label("A");
 labA.setLayoutX(25);
 radChoice1 = new RadioButton("");
 radChoice1.setLayoutX(50);
 labB = new Label("B");
 labB.setLayoutX(25);
 radChoice2 = new RadioButton("");
 radChoice2.setLayoutX(50);
 labC = new Label("C");
 labC.setLayoutX(25);
 radChoice3 = new RadioButton("");
 radChoice3.setLayoutX(50);
 grpChoices = new ToggleGroup();
 labRemainingTime = new Label();
 labRemainingTime.setLayoutX(250);
 labRemainingTime.setLayoutY(75);
 labRemainingTime.setText("0");
 labRemainingTime.setTextFill(Color.BLUE);
 startTimer(); //calling the startTimer function
 radChoice1.setToggleGroup(grpChoices);
 radChoice2.setToggleGroup(grpChoices);
 radChoice3.setToggleGroup(grpChoices);
 paneC = new Pane();
 paneC.setLayoutX(25);
 paneC.setLayoutY(75);
 paneC.getChildren().add(imgQues);
 paneC.getChildren().add(labA);
 paneC.getChildren().add(radChoice1);
 paneC.getChildren().add(labB);
 paneC.getChildren().add(radChoice2);
 paneC.getChildren().add(labC);
 paneC.getChildren().add(radChoice3);
 btnPrev = new Button("Prev");
 btnPrev.setLayoutX(25);
 btnPrev.setLayoutY(550);
 btnPrev.setStyle("-fx-pref-width: 75px;");
 btnPrev.setDisable(true);
 btnNext = new Button("Next");
 btnNext.setLayoutX(125);
 btnNext.setLayoutY(550);
 btnNext.setStyle("-fx-pref-width: 75px;");
 btnSubmit = new Button("Submit");
 btnSubmit.setLayoutX(300);
 btnSubmit.setLayoutY(550);
 btnSubmit.setStyle("-fx-pref-width: 75px;");
 readFromFile();
  answers = new String[totQues];
 radChoice1.setOnAction(e -> {
 quesList.get(activeQ-1).setSelected(0, true);
 quesList.get(activeQ-1).setSelected(1, false);
 quesList.get(activeQ-1).setSelected(2, false);
 });
 radChoice2.setOnAction(e -> {
 quesList.get(activeQ-1).setSelected(0, false);
 quesList.get(activeQ-1).setSelected(1, true);
 quesList.get(activeQ-1).setSelected(2, false);
 });
 radChoice3.setOnAction(e -> {
 quesList.get(activeQ-1).setSelected(0, false);
 quesList.get(activeQ-1).setSelected(1, false);
 quesList.get(activeQ-1).setSelected(2, true);
 });
 if (totQues == 1)
 btnNext.setDisable(true);
 btnNext.setOnAction(e -> {
 save_answer();
 activeQ++;
 btnPrev.setDisable(false);
 if (activeQ == totQues)
 btnNext.setDisable(true);
 reloadQues();
 });
 btnPrev.setOnAction(e -> {
 activeQ--;
 save_answer();
 btnNext.setDisable(false);
 if (activeQ == 1)
 btnPrev.setDisable(true);
 reloadQues();
 });
 btnSubmit.setOnAction(e -> {
 winFarewell.setName(labName.getText());
 mainStage.hide();
 winFarewell.showStage();
 submit_answer();
 });
 mainPane = new Pane();
 mainPane.getChildren().add(labNameDesc);
 mainPane.getChildren().add(labName);
 mainPane.getChildren().add(labQuesNo);
 mainPane.getChildren().add(labQues);
 mainPane.getChildren().add(labRemainingTime);
 mainPane.getChildren().add(paneC);
 mainPane.getChildren().add(btnNext);
 mainPane.getChildren().add(btnPrev);
 mainPane.getChildren().add(btnSubmit);
 mainScene = new Scene(mainPane, 400, 600);
 mainStage.setScene(mainScene);
 reloadQues();
 winGreeting = new MyGreeting();
 winGreeting.setOnHiding(e -> {
 labName.setText(winGreeting.getName());
 mainStage.show();
 });
 winFarewell = new MyFarewell();
 }
 public void reloadQues() {
 labQuesNo.setText("Question " + Integer.toString(activeQ));
 labQues.setText(quesList.get(activeQ-1).getTheQues());
 radChoice1.setText(quesList.get(activeQ-1).getChoice(0));
 radChoice2.setText(quesList.get(activeQ-1).getChoice(1));
 radChoice3.setText(quesList.get(activeQ-1).getChoice(2));
 imgQues.setImage(null);
 if (quesList.get(activeQ-1).getType() == 1) {
 labA.setLayoutY(75);
 radChoice1.setLayoutY(75);
 labB.setLayoutY(125);
 radChoice2.setLayoutY(125);
 labC.setLayoutY(175);
 radChoice3.setLayoutY(175);
 }
 if (quesList.get(activeQ-1).getType() == 2) {
 File pFile = new File("data/" + quesList.get(activeQ-1).getQuesPic());
 Image img = new Image(pFile.toURI().toString());
 imgQues.setImage(img);
 labA.setLayoutY(275);
 radChoice1.setLayoutY(275);
 labB.setLayoutY(325);
 radChoice2.setLayoutY(325);
 labC.setLayoutY(375);
 radChoice3.setLayoutY(375);
 }
 radChoice1.setSelected(quesList.get(activeQ-1).getSelected(0));
 radChoice2.setSelected(quesList.get(activeQ-1).getSelected(1));
 radChoice3.setSelected(quesList.get(activeQ-1).getSelected(2));
 }
 public void readFromFile() {
 Scanner sfile;
 int type;
 char answer;
 String theQues;
 String choices[] = new String[4];
 String quesPic;
 Question ques;
 try {
 sfile = new Scanner(myf);
 String aLine = sfile.nextLine();
 Scanner sline = new Scanner(aLine);
 totQues = Integer.parseInt(sline.next());
 for (int k = 1; k <= totQues; k++) {
 aLine = sfile.nextLine();
 sline = new Scanner(aLine);
 sline.useDelimiter(":");
 type = Integer.parseInt(sline.next());
 answer = sline.next().charAt(0);
 theQues = sline.next();
 quesPic = "";
 if (type == 2)
 quesPic = sline.next();
 choices[0] = sline.next();
 choices[1] = sline.next();
 choices[2] = sline.next();
 sline.close();
 ques = new Question(type, answer, theQues, choices, quesPic);
 quesList.add(ques);
 }
 sfile.close();
 }
 catch (FileNotFoundException e) {
 System.out.println("File to read " + myf + " not found!");
 }
 }
public void startTimer() {
Timer = new Timeline(new KeyFrame(Duration.ZERO, e -> {
seconds--; // Creats a new timeline for the timer, the number of seconds at every given second is reduced
// If seconds is less than 10, then it will format it by adding a 0 
if (seconds < 10) {
    labRemainingTime.setText("Time Remaining: " + minutes + ":0" + seconds);
}
else {
     labRemainingTime.setText("Time Remaining: " + minutes + ":" + seconds);
}          
if (seconds <= 0) {
if (minutes == 1) {// If there is 1 minute left, then the timer will change to red to indicate a warning
    labRemainingTime.setTextFill(Color.RED);
    seconds=60;
    minutes=0;
}               
// If the minutes is 0 then the timer will stop
else if (minutes == 0) {
    Timer.stop();
    btnNext.setDisable(true);
    btnPrev.setDisable(true);
    btnSubmit.setOnAction(f ->{
        submit_answer();
    });
}
else {
    seconds=60;
    minutes--;
}}}),
new KeyFrame(Duration.seconds(1)));
Timer.setCycleCount(Animation.INDEFINITE);
Timer.play();
}

public void save_answer(){
     rad = (RadioButton)grpChoices.getSelectedToggle();
     if(rad != null){
         answers[activeQ] = rad.getId();
     }
}
public void submit_answer(){
     try {
            // write the answers to results.txt
            PrintWriter pw = new PrintWriter(new FileWriter(myf2, true));
            BufferedWriter output = new BufferedWriter(pw);
            output.write(winGreeting.getName());
            output.write(":");
            int correctAnswers = 0;
            for (int i = 0; i < totQues; i++) {
                output.write(":");
                if(answers[i] != null) {
                    // checks if the answer for each question is correct, and increases correct answer counter
                    
                    output.write(answers[i]);
                }
                else {
                    output.write("x");
                }
            }
            output.write(":");
            // outputs the number of correct answers for the candidate at the end of the line
            output.write(Integer.toString(correctAnswers));
            output.newLine();
            output.close();
        }
        catch(IOException e) {
            System.out.println("File not found");
        }
}
 public static void main(String args[]) {
 Application.launch(args);
 }
}






