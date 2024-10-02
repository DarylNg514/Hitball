package com.teccart.exohitball;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class vaisseauspatial extends View {

  //  private Bitmap vaisseauBitmap;

    private int vaisseauX;

    public int getPosX() {
        return vaisseauX;
    }

    public void setPosX(int vaisseauX) {
        this.vaisseauX = vaisseauX;
    }

    public int getPosY() {
        return vaisseauY;
    }

    public void setPosY(int vaisseauY) {
        this.vaisseauY = vaisseauY;
    }

    private int vaisseauY;
    private int vaisseauSpeed = 10;
    private Paint paint;
    private int vaisseauRadius = 20;

    private ArrayList<AstreCeleste> astres;

    public vaisseauspatial(Context context, ArrayList<AstreCeleste> astres) {
        super(context);
        this.astres = astres;
       // vaisseauBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ves);
        vaisseauX = 100; // Position initiale du vaisseau
        vaisseauY = 100;
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Dessiner le vaisseau à la position spécifiée par les coordonnées de la souris
        canvas.drawCircle(getPosX(),  getPosY(), vaisseauRadius, paint);
    }

   @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // Capturer les mouvements du doigt
                // Mettre à jour les coordonnées du vaisseau avec les coordonnées de toucher
                setPosX(touchX);
                setPosY(touchY);
                // Vérifier les collisions avec les astres
                checkCollisions(touchX,touchY);
                // Redessiner la vue
                break;
            /*case MotionEvent.ACTION_MOVE: // Capturer les mouvements du doigt
                // Mettre à jour les coordonnées du vaisseau avec les coordonnées de toucher
                setPosX(touchX);
                setPosY(touchY);
                // Vérifier les collisions avec les astres
                checkCollisions();
                // Redessiner la vue
                invalidate();
                break;*/
        }
       invalidate();
       return true;
    }

    private void checkCollisions(int touchX,int touchY) {
        /*for (AstreCeleste astre : astres) {
            if (astre.getStatus() == 0) {
                // Vérifier si le vaisseau spatial est en collision avec l'astre
                if (getPosX() < astre.getPosX() + astre.getTaille() &&
                        getPosX() + vaisseauRadius * 2 > astre.getPosX() &&
                        getPosY() < astre.getPosY() + astre.getTaille() &&
                        getPosX() + vaisseauRadius * 2 > astre.getPosY()) {
                    // Collision détectée, afficher les informations de l'astre dans un Toast
                    Toast.makeText(getContext(), "Astre: " + astre.getName(), Toast.LENGTH_SHORT).show();
                    // Mettre à jour le statut de l'astre si nécessaire
                    astre.setStatus(1);
                }
            }
        }*/

        for (AstreCeleste astre : astres) {
            if (isTouchInsideAstre(touchX, touchY, astre)) {
                //playBtnState = false;
                // Afficher le nom et la position de l'astre touché
                Toast.makeText(getContext(), "Nom: " + astre.getName() + ", Position: (" + astre.getPosX() + ", " + astre.getPosY() + ")", Toast.LENGTH_SHORT).show();
                break;

            }
        }
    }
    private boolean isTouchInsideAstre(int touchX, int touchY, AstreCeleste astre) {
        return touchX >= astre.getPosX() && touchX <= astre.getPosX() + astre.getTaille() &&
                touchY >= astre.getPosY() && touchY <= astre.getPosY() + astre.getTaille();
    }

}
