package classes.operacoes;

public class Subtracao {
    
    private int x;
    private int y;

    public Subtracao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int subtracao() {
        return this.x - this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
