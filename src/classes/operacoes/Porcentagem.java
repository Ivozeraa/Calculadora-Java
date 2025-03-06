package classes.operacoes;

public class Porcentagem {
    
    private double x;
    private double y;

    public Porcentagem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Metodo principal
    public double porcentagem(){
        return (this.x / 100) * this.y;
    }


    //Getters e setters
    public double getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

}
