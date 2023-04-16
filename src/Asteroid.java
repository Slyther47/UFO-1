import GLOOP.*;
public class Asteroid{
    private GLKugel kugel;
    private Ufo dasUfo;

    public Asteroid(Ufo pUfo, GLTextur pTex){
        int x = (int)(Math.random()*3000 - 1500);
        int y = (int)(Math.random()*4000);
        int z = (int)(Math.random()*3000 - 1500);
        kugel = new GLKugel(x,y,z, 50, pTex);
        kugel.setzeSkalierung(1,Math.random()+0.3,Math.random()+0.3);
        dasUfo = pUfo;
    }

    public void bewegeDichDuHS(){
        kugel.verschiebe(0,-2,0);
        kugel.drehe(0.1,0.1,0.1);

        if (kugel.gibY()< -300) this.zuruecksetzen();
        if (this.getroffen()) dasUfo.explodiere();
    }

    private boolean getroffen(){
        double abstand = Math.sqrt(Math.pow( kugel.gibX()-dasUfo.gibX(), 2 ) + Math.pow( kugel.gibY()-dasUfo.gibY(), 2 ) + Math.pow( kugel.gibZ()-dasUfo.gibZ(), 2 ));
        if (abstand<80) return true;
        else return false;
    }

    private void zuruecksetzen(){
        int x = (int)(Math.random()*3000 - 1500);
        int z = (int)(Math.random()*3000 - 1500);
        kugel.setzePosition(x,4000,z);
        kugel.setzeSkalierung(1,Math.random()+0.3,Math.random()+0.3);
    }
}
