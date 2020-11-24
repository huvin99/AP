

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Contestant extends Stage{
    public Contestant(String s,String n){
        ImageView iv1 = new ImageView();
        final Pane root = new Pane();
        Label name = new Label(n);
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
