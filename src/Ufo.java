import GLOOP.*;
public class Ufo {
    private GLTorus rumpf;
    private GLKugel cockpit;
    private GLKegel fluegel1, fluegel2;

    public Ufo(){
        rumpf = new GLTorus(0,0,0,50,20);
        rumpf.skaliere (1.5,1.5,0.9);
        rumpf.setzeQualitaet(24);
    }

    public void bewegeLinks(){
        if (rumpf.gibX() > -501) {
            rumpf.verschiebe(-1, 0, 0);
        }
    }

    public void bewegeRechts(){
        if (rumpf.gibX() < 501) {
            rumpf.verschiebe(1, 0, 0);
        }
    }

    public void bewegeUnten(){
        if (rumpf.gibZ() > -401) {
            rumpf.verschiebe(0, 0, -1);
        }
    }

    public void bewegeOben(){
        if (rumpf.gibZ() < 401) {
            rumpf.verschiebe(0, 0, 1);
        }
    }

    public void explodiere(){
        double z = Math.random();
        for (int i=0; i< 2000; i++){
            rumpf.verschiebe(-z,z,z);
            rumpf.drehe(-z,z,z);
            Sys.warte();
        }
        Sys.beenden();
    }

    public double gibX(){
        return rumpf.gibX();
    }

    public double gibY(){
        return rumpf.gibY();
    }

    public double gibZ(){
        return rumpf.gibZ();
    }

}