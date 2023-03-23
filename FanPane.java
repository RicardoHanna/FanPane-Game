package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class FanPane extends Pane{
	
	private double w=200,h=200;
     private Arc[] blades = new Arc[4];
     double increment = 5;
     public double startAngle=30;
     public double radius=Math.min(w, h)*0.45;
     private Circle c=new Circle(w/2,h/2,radius);

   public FanPane() {

       c.setFill(Color.WHITE);
         c.setStroke(Color.BLACK);
         this.getChildren().add(c);

         double bladeRadius = radius * 0.9;
         for (int i = 0; i < blades.length; i++) {
             blades[i] = new Arc(
                     c.getCenterX(), c.getCenterY(), 
                     bladeRadius, bladeRadius, 
                     (i * 90) + startAngle, 35);
             blades[i].setFill(Color.RED);
             blades[i].setType(ArcType.ROUND);
             this.getChildren().add(blades[i]);
         }

        
       // this.getChildren().addAll(blades);


     }
   
   /* void spin() {
	   for(Arc blade:blades) {
		   double prevStartAngle=blade.getStartAngle();
		   blade.setStartAngle(prevStartAngle+increment);
	   }
   }*/


   void spin() {
      setStartAngle(this.startAngle+increment);
     }

     public void setStartAngle(double d) {
    	 startAngle=d;
    	 setValues();
     }


	private void setValues() {
		radius=Math.min(w, h)*0.45;
		c.setRadius(radius);
		c.setCenterX(w/2);
		c.setCenterY(h/2);
		for(int i=0;i<4;i++) {
			blades[i].setRadiusX(radius*0.9);
			blades[i].setRadiusY(radius*0.9);
	        blades[i].setCenterX(w/2);
	        blades[i].setCenterY(h/2);
	        blades[i].setStartAngle( i * 90 + startAngle);
		}
		
	}
	
	public void setW() {
		this.w=this.getWidth();
		this.setValues();
	}
     
	public void setH() {
		this.h=this.getHeight();
		this.setValues();
	}
	
     
 }


