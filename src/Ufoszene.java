import GLOOP.*;
public class Ufoszene {
    GLKamera kamera;
    GLLicht licht;
    GLTastatur tastatur;
    GLHimmel himmel;
    GLTafel t1;

    Ufo Ufo;
    Asteroid[] asteroid;

    int Time = 0;
    int Score = 0;

    public Ufoszene(){
        kamera = new GLSchwenkkamera();
        kamera.setzePosition(0,-600,200);
        kamera.setzeBlickpunkt(0,0,200);
        kamera.setzeScheitelrichtung(0,0,1);

        licht  = new GLLicht(-5000,-10000,0);
        tastatur = new GLTastatur();
        himmel = new GLHimmel("C:/Users/slyth/IdeaProjects/UFO-1/src/img/Sterne.jpg");
        t1 = new GLTafel(0,0,0,100,50);
        t1.drehe(90,0,0);
        t1.verschiebe(-480,0,500);
        t1.setzeText("Score: " + Score,50);
        Ufo = new Ufo();

        GLTextur tex = new GLTextur("src/img/Krater.jpg");
        asteroid = new Asteroid[70];
        for (int i=0; i<70; i++){
            asteroid[i] = new Asteroid(Ufo, tex);
        }
        fuehreAus();
    }

    public void fuehreAus(){
        while(!tastatur.esc()){
            if (tastatur.istGedrueckt('a') && Ufo.gibX() > -501) {
                Ufo.bewegeLinks();
                kamera.verschiebe(-1,0,0);
                t1.verschiebe(-1,0,0);
            }
            if (tastatur.istGedrueckt('d') && Ufo.gibX() < 501) {
                Ufo.bewegeRechts();
                kamera.verschiebe(1,0,0);
                t1.verschiebe(1,0,0);
            }
            if (tastatur.istGedrueckt('s') && Ufo.gibZ() > -401) {
                Ufo.bewegeUnten();
                kamera.verschiebe(0,0,-1);
                t1.verschiebe(0,0,-1);
            }
            if (tastatur.istGedrueckt('w') && Ufo.gibZ() < 401) {
                Ufo.bewegeOben();
                kamera.verschiebe(0,0,1);
                t1.verschiebe(0,0,1);
            }

            for (int i=0; i<70; i++) {
                asteroid[i].bewegeDichDuHS();
            }
            Time++;
            if (Time % 200 == 0) {
                Score++;
                t1.setzeText("Score: " + Score,50);
            }
            Sys.warte();
        }
        Sys.beenden();
    }
}