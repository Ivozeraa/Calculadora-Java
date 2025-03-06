package classes.operacoes;

public class Divisao {
    private int x;
    private int y;

    public Divisao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int divisao(){
        if(y == 0){
            System.out.println("Numero dividivel por 0");
            return 0;
        } else{
            return this.x / this.y;
        }
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    
}
