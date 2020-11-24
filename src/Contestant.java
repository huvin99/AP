

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        Scene scene = new Scene(new Group(),500,300);
        Group root = (Group)scene.getRoot();
        GridPane grid = new GridPane();
        Label name = new Label(n);
         if(s == "Israel"){
             String imagefile = "./data/Nepal.jpg";
             Image img1 = new Image(new File(imagefile).toURI().toString());
             iv1.setImage(img1);
             iv1.setFitHeight(100);
             iv1.setFitWidth(100);
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
         grid.setVgap(4);
         grid.setHgap(10); 
         grid.setPadding(new Insets(5,5,5,5));
         grid.add(iv1,1,0);
         grid.add(name,2,0);
         root.getChildren().add(grid);
         this.setScene(scene);
         this.show();
    }
}
