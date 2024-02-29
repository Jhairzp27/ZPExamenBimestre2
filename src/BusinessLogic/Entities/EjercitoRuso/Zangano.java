package BusinessLogic.Entities.EjercitoRuso;

import BusinessLogic.Entities.ZPAlimento;

public class Zangano extends Hormiga {
    @Override
    public boolean comer(ZPAlimento alimento) {
        // TODO Auto-generated method stub
        return false;
    }
    private int fuerza; 
    private int rapidez; 
    public Zangano(String tipo) {
        super(tipo);
        //TODO Auto-generated constructor stub
    }
    public int getFuerza() {
        return fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public int getRapidez() {
        return rapidez;
    }
    public void setRapidez(int rapidez) {
        this.rapidez = rapidez;
    }
    
}
