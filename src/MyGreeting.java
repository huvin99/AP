import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class MyGreeting extends Stage {

 private TextField txtName, txtName2;
 final ComboBox countrybox = new ComboBox();
 public MyGreeting() {
 this.setTitle("Entry Form");
 Scene scene = new Scene(new Group(),500,300);
 Label f_name = new Label("First Name:");
 Label L_name = new Label("Last Name:");
 txtName = new TextField();
 txtName2 = new TextField();
 final ImageView imv = new ImageView();
 Label labCountry = new Label("Choose the country:");
 
 
  
 countrybox.getItems().addAll(
     "Nepal",
      "Poland",
      "Georgia",
      "Israel",
      "Iran"
 );
 countrybox.setValue("");
 Button btnDone = new Button("Done");
 btnDone.setOnAction(e -> {
 String n = txtName.getText()+" "+txtName2.getText();
 String cu = (String) countrybox.getValue();
 MyParam.setName2(txtName2.getText());
 if(countrybox.getValue() =="Nepal"){
 String musicFile = "./data/sayonara.mp3";
 Media sound = new Media(new File(musicFile).toURI().toString());
 MediaPlayer mdPlayer = new MediaPlayer(sound);
 mdPlayer.play();
 
 }
 if(countrybox.getValue()=="Poland"){
 String musicFile = "./data/Poland.wav";
 Media sound = new Media(new File(musicFile).toURI().toString());
 MediaPlayer mdPlayer = new MediaPlayer(sound);
 mdPlayer.play();
 }
 if(countrybox.getValue()=="Georgia"){
 String musicFile = "./data/Georgia.wav";
 Media sound = new Media(new File(musicFile).toURI().toString());
 MediaPlayer mdPlayer = new MediaPlayer(sound);
 mdPlayer.play();

 }
 if(countrybox.getValue()=="Iran"){
 String musicFile = "./data/Iran.wav";
 Media sound = new Media(new File(musicFile).toURI().toString());
 MediaPlayer mdPlayer = new MediaPlayer(sound);
 mdPlayer.play();
 }
 if(countrybox.getValue()=="Israel"){
     
 }
 Contestant(cu,n);
 
 });
 
 GridPane grid = new GridPane(); 
 grid.setVgap(4);
 grid.setHgap(10); 
 grid.setPadding(new Insets(5,5,5,5));
 grid.add(f_name,0,0);
 grid.add(L_name,0,1); 
 grid.add(txtName,1,0); 
 grid.add(txtName2,1,1);
 grid.add(labCountry,0,6); 
 grid.add(countrybox,1,6);
 grid.add(btnDone,1,8);
 
 Group root = (Group)scene.getRoot();
 root.getChildren().add(grid); 
 this.setScene(scene);
 this.show();
 }

 public String getName() {
   return txtName.getText() + " " + txtName2.getText();
 }
 public String getCountry(){
     return (String) countrybox.getValue();
 }
 public  void Contestant(String s,String n){
        ImageView iv1 = new ImageView();
        final Pane root = new Pane();
        Label name = new Label(n);
        this.setTitle("Contestant Information");
        Button done = new Button("Done");
         if(s == "Israel"){
             String imagefile = "./data/Nepal.jpg";
             Image img1 = new Image(new File(imagefile).toURI().toString());
             iv1.setImage(img1);
             
         }
         if(s=="Iran"){
             String imagefile = "./data/Lihao.jpg";
             Image img2 = new Image(new File(imagefile).toURI().toString());
             
             iv1.setImage(img2);
         }
         if(s=="Nepal"){
             String imagefile = "./data/Afiq.jpg";
             Image img3 = new Image(new File(imagefile).toURI().toString());
             iv1.setImage(img3);
         }
         if(s=="Poland"){
             String imagefile = "./data/Pravin.jpg";
             Image img4 = new Image(new File(imagefile).toURI().toString()); 
             iv1.setImage(img4);
         }
         if(s=="Georgia"){
             String imagefile = "./data/Benny.jpg";
             Image img5 = new Image(new File(imagefile).toURI().toString());
             iv1.setImage(img5);
         }
         done.setOnAction(e ->{
            this.hide(); 
         });
         done.setLayoutX(210); 
         done.setLayoutY(500);
         iv1.setFitHeight(200);
         iv1.setFitWidth(200);
         iv1.setLayoutX(150);
         iv1.setLayoutY(100);
         name.setLayoutX(210);
         name.setLayoutY(350);
         root.getChildren().add(iv1);
         root.getChildren().add(name);
         root.getChildren().add(done);
         this.setScene(new Scene(root,500,600));
         this.show();
    }
}
