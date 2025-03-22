import java.lang.reflect.Constructor;
import java.util.*;

public class Cliente {

    public static String capital(String s) {
            if (s == null || s.isEmpty())   return s;
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<FiguraGeometrica> figuras = new ArrayList<>();

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha.isEmpty()) break;

            String[] partes = linha.split(" ", 2);
            try {
                Class<?> classe = Class.forName(capital(partes[0]));
                Constructor<?> construtor = classe.getConstructor(String.class);
                FiguraGeometrica figura = (FiguraGeometrica) construtor.newInstance(partes[1]);

                // Verifica colisão com figuras existentes
                for (int i = 0; i < figuras.size(); i++) {
                    if (figuras.get(i).colideCom(figura)) {
                        System.out.println("Colisao na posicao " + i);
                        System.exit(0);
                    }
                }

                figuras.add(figura);
            } catch (Exception e)   {/*Erros já tratados nos construtores*/}
        }

        System.out.println("Sem colisoes");
        sc.close();
    }
}
