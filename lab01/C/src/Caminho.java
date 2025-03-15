import java.util.ArrayList;

public class Caminho {
    private ArrayList<Ponto> pontoArrayList;
    public Caminho(){
        this.pontoArrayList = new ArrayList<Ponto>();
    }
    public void add(Ponto ponto){
        pontoArrayList.add(ponto);
    }
    public double comprimento() {
        double res = 0.0;
        for (int i = 0; i < pontoArrayList.size() - 1; i++) //aqui tem i - 1 pq ao aceder ao ultimo index quando se faz i + 1 vai para fora de bound
        {
            res += pontoArrayList.get(i).dist(pontoArrayList.get(i+1));
        }
        return res;
    }
}
