package com.teccart.exohitball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Random;

public class AlienSolarSystem extends View {
    private ImageView imageView;
    private Random random;
    private ArrayList<AstreCeleste> astres;
    private Paint textPaint;
    private Context context;
    private boolean fin;
    private Bitmap background;
    private Bitmap backgroundanime;
    private boolean playBtnState;
    private int screenW;
    private int screenH;
    private vaisseauspatial vs;

    public AlienSolarSystem(Context context) {
        super(context);
        this.context = context;
        fin = false;
        random = new Random();
        astres = new ArrayList<>();
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(20);
        textPaint.setAntiAlias(true);
        //background = BitmapFactory.decodeResource(getResources(),R.drawable.nebula);
        //backgroundanime = BitmapFactory.decodeResource(getResources(),R.drawable.bga);
        fetchAstresFromDatabase();

    }

    private void fetchAstresFromDatabase() {
        myAstreCelesteTableDataGateWay dataGateway = new myAstreCelesteTableDataGateWay(context);
        dataGateway.Open();
        dataGateway.deleteAllAstreCeleste();
        dataGateway.InsertAstreCeleste();
        astres = dataGateway.selectAllAstreCeleste();
        // Initialiser le vaisseau spatial
        vs= new vaisseauspatial(context,astres);
        dataGateway.Close();

    }

    private void createAstres() {
        for (int i = 0; i < 5; i++) {
            AstreCeleste astre = new AstreCeleste("Astre " + i, 30, Color.BLACK,"astre" + i);
            astre.setPosX(random.nextInt(500));
            astre.setPosY(random.nextInt(500));
            astres.add(astre);
        }
    }

    private int isAllAstresTouched() {
        for (AstreCeleste astre : astres) {
            if (astre.getStatus()==0) {
                return 1;
            }
        }
        return 1;
    }

    private Bitmap getAstreBitmap(String nomImageAstre) {
        int resId = getResources().getIdentifier(nomImageAstre, "drawable", context.getPackageName());
        if (resId != 0) {
            return BitmapFactory.decodeResource(getResources(), resId);
        } else {
            return null;
        }
    }

    /*@Override
    protected void onDraw(Canvas canvas) {



        super.onDraw(canvas);
        int averageSize = 200; // Taille moyenne fixe
        int minDistance = averageSize + 20; // Marge minimale entre chaque astre

        // Parcourir chaque astre
        for (int i = 0; i < astres.size(); i++) {
            AstreCeleste astre = astres.get(i);
            Paint astrePaint = new Paint();
            astrePaint.setAntiAlias(true);
            if (astre.getStatus() == 1) {
                astrePaint.setColor(Color.GREEN);
            } else {
                astrePaint.setColor(astre.getCouleur());
            }
            Bitmap astreBitmap = getAstreBitmap(astre.getNomimage());
            if (astreBitmap != null) {
                boolean overlapping;
                do {
                    overlapping = false;
                    // Générer une position aléatoire pour l'astre
                    int posX = random.nextInt(canvas.getWidth() - averageSize);
                    int posY = random.nextInt(canvas.getHeight() - averageSize);
                    // Vérifier s'il y a des chevauchements avec les astres déjà positionnés
                    for (int j = 0; j < i; j++) {
                        AstreCeleste otherAstre = astres.get(j);
                        // Vérifier le chevauchement avec les astres précédemment positionnés
                        if (Rect.intersects(new Rect(posX, posY, posX + averageSize, posY + averageSize),
                                new Rect(otherAstre.getPosX(), otherAstre.getPosY(), otherAstre.getPosX() + averageSize, otherAstre.getPosY() + averageSize))) {
                            overlapping = true;
                            break;
                        }
                    }
                    // Si l'astre chevauche avec un astre précédemment positionné, réessayer avec une nouvelle position
                    if (!overlapping) {
                        astre.setPosX(posX);
                        astre.setPosY(posY);
                    }
                } while (overlapping);

                // Redimensionner le bitmap à une taille moyenne
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(astreBitmap, averageSize, averageSize, false);
                Rect dstRect = new Rect(astre.getPosX(), astre.getPosY(), astre.getPosX() + averageSize, astre.getPosY() + averageSize);
                canvas.drawBitmap(resizedBitmap, null, dstRect, astrePaint);
            }
        }
    }*/
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        // Dessiner le vaisseau spatial
        vs.draw(canvas);

        // Vérifier si un astre est touché
        /*
        boolean astreTouche = false;
        for (AstreCeleste astre : astres) {
            if (isTouchInsideAstre(screenW, screenH, astre)) {
                astreTouche = true;
                break;
            }
        }

        // Afficher l'arrière-plan en conséquence
        if (playBtnState) {
            // Afficher l'arrière-plan spécifique pour les astres touchés
            // Dessiner l'arrière-plan spécifique ici
            canvas.drawBitmap(backgroundanime, 0, 0, null);
        } else {
            // Afficher l'arrière-plan par défaut
            // Dessiner l'arrière-plan par défaut ici
            canvas.drawBitmap(background, 0, 0, null);
        }*/

        int averageSize = 200; // Taille moyenne fixe
        int minDistance = averageSize + 20; // Marge minimale entre chaque astre

        // Parcourir chaque astre
        for (int i = 0; i < astres.size(); i++) {
            AstreCeleste astre = astres.get(i);
            Paint astrePaint = new Paint();
            astrePaint.setAntiAlias(true);
            if (astre.getStatus() == 1) {
                astrePaint.setColor(Color.GREEN);
            } else {
                astrePaint.setColor(astre.getCouleur());
            }
            Bitmap astreBitmap = getAstreBitmap(astre.getNomimage());
            if (astreBitmap != null) {
                boolean overlapping;
                do {
                    overlapping = false;
                    // Générer une position aléatoire pour l'astre
                    int posX = random.nextInt(canvas.getWidth() - averageSize);
                    int posY = random.nextInt(canvas.getHeight() - averageSize);
                    // Vérifier s'il y a des chevauchements avec les astres déjà positionnés
                    for (int j = 0; j < i; j++) {
                        AstreCeleste otherAstre = astres.get(j);
                        // Vérifier le chevauchement avec les astres précédemment positionnés
                        if (Rect.intersects(new Rect(posX, posY, posX + averageSize, posY + averageSize),
                                new Rect(otherAstre.getPosX(), otherAstre.getPosY(), otherAstre.getPosX() + averageSize, otherAstre.getPosY() + averageSize))) {
                            overlapping = true;
                            break;
                        }
                    }
                    // Si l'astre chevauche avec un astre précédemment positionné, réessayer avec une nouvelle position
                    if (!overlapping) {
                        astre.setPosX(posX);
                        astre.setPosY(posY);
                    }
                } while (overlapping);

                // Redimensionner le bitmap à une taille moyenne
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(astreBitmap, averageSize, averageSize, false);
                Rect dstRect = new Rect(astre.getPosX(), astre.getPosY(), astre.getPosX() + averageSize, astre.getPosY() + averageSize);
                canvas.drawBitmap(resizedBitmap, null, dstRect, astrePaint);
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        vs.onTouchEvent(event);

        /*int action = event.getAction();
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                for (AstreCeleste astre : astres) {
                    if (isTouchInsideAstre(touchX, touchY, astre)) {
                        playBtnState = false;
                        // Afficher le nom et la position de l'astre touché
                        Toast.makeText(context, "Nom: " + astre.getName() + ", Position: (" + astre.getPosX() + ", " + astre.getPosY() + ")", Toast.LENGTH_SHORT).show();
                        break;

                    }
                }
                break;
            case MotionEvent.ACTION_UP:

                playBtnState = true;

                break;
            case MotionEvent.ACTION_MOVE:
                playBtnState = true;

                break;


        }
        //invalidate();*/
        return true;
    }

    private boolean isTouchInsideAstre(int touchX, int touchY, AstreCeleste astre) {
        return touchX >= astre.getPosX() && touchX <= astre.getPosX() + astre.getTaille() &&
                touchY >= astre.getPosY() && touchY <= astre.getPosY() + astre.getTaille();
    }

}

