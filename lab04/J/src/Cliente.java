import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public static String capital(String s) {
            if (s == null || s.isEmpty())   return s;
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<FiguraGeometrica> listfig = new ArrayList<>();
        String s;

        // Ler figura
        if (sc.hasNextLine()) {
            s = sc.nextLine();
            if (!s.isEmpty()) {
                String[] aos = s.split(" ", 2);
                try {
                    Class<?> cl = Class.forName(capital(aos[0]));
                    Constructor<?> constructor = cl.getConstructor(String.class);
                    FiguraGeometrica f = (FiguraGeometrica) constructor.newInstance(aos[1]);
                    listfig.add(f);
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        // Ler deslocamento dx e dy
        if (sc.hasNextLine()) {
            s = sc.nextLine();
            String[] deslocamento = s.split(" ");
            if (deslocamento.length == 2) {
                int dx = Integer.parseInt(deslocamento[0]);
                int dy = Integer.parseInt(deslocamento[1]);
                // Aplicar translação
                if (!listfig.isEmpty()) {
                    FiguraGeometrica figTransladada = listfig.get(0).translacao(dx, dy);
                    System.out.println(figTransladada);
                }
            }
        }
        sc.close();
    }
}
