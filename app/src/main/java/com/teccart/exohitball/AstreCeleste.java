package com.teccart.exohitball;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class AstreCeleste {

    private int posX;

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private int posY;
    private Paint crayon;
    private Random alea;
    private int radius;
    private String name;
    private  int taille;
    private int   couleur;
    private int status;

    private String  nomimage;

    private static final int[] palette = {Color.WHITE, Color.GREEN,Color.RED,Color.BLUE};

    public AstreCeleste(String name, int taille, int couleur, String nomimage){
        this.name= name;
        this.taille=taille;
        this.couleur=couleur;
        //this.status=status;
        this.crayon = new Paint();
        this.nomimage=nomimage;
        this.status = 0;

        alea = new Random();
        posX = alea.nextInt(500);
        posY = alea.nextInt(500);

        crayon = new Paint();
        crayon.setAntiAlias(true);
        crayon.setColor(palette[alea.nextInt(3)]);

        radius = 30;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

     public int getStatus(){return this.status;}
   public void setStatus(int state) {
       this.status = state;
      /*if(!this.status){
    crayon.setColor(Color.TRANSPARENT);
 }*/
   }

    public String getNomimage() {
        return nomimage;
    }

    public void setNomimage(String nomimage) {
        this.nomimage = nomimage;
    }



    //public int getStatus(){return this.status;}
    /*public void    setStatus(int state){
        this.status= state;

//      if(! this.status){
//          crayon.setColor(Color.TRANSPARENT);
//      }

    }*/

    public int getPosX(){
        return this.posX;
    }
    public int getPosY() {return this.posY;}
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(posX, posY, taille, crayon);
    }

}



/*

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class AstreCeleste {


    private int posX;
    private int posY;

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private Paint crayon;
    private Random alea;
    private int Id;
    private String NomAstre;
    private int TailleAstre;
    private int CouleurAstre;
    private boolean StatusAstre;
    private String NomImageAstre;
    private static final int[] palette = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.YELLOW};



    public AstreCeleste(int Id,String nomAstre, int tailleAstre, int couleurAstre, boolean statusAstre, String nomImageAstre) {
        this.Id = Id;
        NomAstre = nomAstre;
        CouleurAstre = couleurAstre;
        NomImageAstre = nomImageAstre;

        StatusAstre = true;
        alea = new Random();
        posX = alea.nextInt(500);
        posY = alea.nextInt(500);

        crayon = new Paint();
        crayon.setAntiAlias(true);
        crayon.setColor(palette[alea.nextInt(3)]);

        TailleAstre = 30;
    }

    public String getNomAstre() {
        return NomAstre;
    }

    public void setNomAstre(String nomAstre) {
        NomAstre = nomAstre;
    }

    public int getTailleAstre() {
        return TailleAstre;
    }

    public void setTailleAstre(int tailleAstre) {
        TailleAstre = tailleAstre;
    }

    public int getCouleurAstre() {
        return CouleurAstre;
    }

    public void setCouleurAstre(int couleurAstre) {
        CouleurAstre = couleurAstre;
    }

    public boolean isStatusAstre() {
        return StatusAstre;
    }

    public void setStatusAstre(boolean statusAstre) {
        StatusAstre = statusAstre;

        if (!this.StatusAstre)
        {
            crayon.setColor(Color.TRANSPARENT);
        }
    }

    public String getNomImageAstre() {
        return NomImageAstre;
    }

    public void setNomImageAstre(String nomImageAstre) {
        NomImageAstre = nomImageAstre;
    }

    public int getPosX()
    {

        return this.posX;
    }

    public int getPosY()
    {
        return
                this.posY;
    }



    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(posX, posY, TailleAstre, crayon);
    }


}





* import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

public class AstreCeleste {

    private int posX;
    private int posY;
    private Paint crayon;
    private int Id;
    private String NomAstre;
    private int TailleAstre;
    private int CouleurAstre;
    private boolean StatusAstre;
    private String NomImageAstre;
    private static final int[] palette = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW};

    public AstreCeleste(int Id, String nomAstre, int tailleAstre, int couleurAstre, boolean statusAstre, String nomImageAstre) {
        this.Id = Id;
        NomAstre = nomAstre;
        TailleAstre = tailleAstre;
        CouleurAstre = couleurAstre;
        NomImageAstre = nomImageAstre;
        StatusAstre = statusAstre;
        Random alea = new Random();
        posX = alea.nextInt(500);
        posY = alea.nextInt(500);
        crayon = new Paint();
        crayon.setAntiAlias(true);
        crayon.setColor(palette[alea.nextInt(4)]); // Correction de l'indice max
    }

    public String getNomAstre() {
        return NomAstre;
    }

    public void setNomAstre(String nomAstre) {
        NomAstre = nomAstre;
    }

    public int getTailleAstre() {
        return TailleAstre;
    }

    public void setTailleAstre(int tailleAstre) {
        TailleAstre = tailleAstre;
    }

    public int getCouleurAstre() {
        return CouleurAstre;
    }

    public void setCouleurAstre(int couleurAstre) {
        CouleurAstre = couleurAstre;
    }

    public boolean isStatusAstre() {
        return StatusAstre;
    }

    public void setStatusAstre(boolean statusAstre) {
        StatusAstre = statusAstre;
        if (!this.StatusAstre) {
            crayon.setColor(Color.TRANSPARENT);
        }
    }

    public String getNomImageAstre() {
        return NomImageAstre;
    }

    public void setNomImageAstre(String nomImageAstre) {
        NomImageAstre = nomImageAstre;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(posX, posY, TailleAstre, crayon);
    }
}

*
* */
