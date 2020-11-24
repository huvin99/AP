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
 final HBox pic = new HBox();
 final ImageView imv = new ImageView();
 Label labCountry = new Label("Choose the country:");
  
 countrybox.getItems().addAll(
     "Italy",
      "Poland",
      "Georgia",
      "Israel",
      "Germany"
 );
 countrybox.setValue("");
 Button btnDone = new Button("Done");
 btnDone.setOnAction(e -> {
 MyParam.setName2(txtName2.getText());
 if(countrybox.getValue() =="Italy"){
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
 GridPane grid1 = new GridPane(); 
 grid1.setVgap(4); 
 grid1.setHgap(10);
 grid1.setPadding(new Insets(5,5,5,5));
 }
 
 this.hide();
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
}