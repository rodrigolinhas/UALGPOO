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
            List<FiguraGeometrica> listfig = new ArrayList<FiguraGeometrica>();
            Constructor<?> constructor;
            Class<?> cl;
            FiguraGeometrica f;
            String s;
            String[] aos;
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                if (s.isEmpty())
                    break;
                aos = s.split(" ", 2);
                try {
                    cl = Class.forName(capital(aos[0]));
                    constructor = cl.getConstructor(String.class);
                    f = (FiguraGeometrica) constructor.newInstance(aos[1]);
                    listfig.add(f);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Não foi encontrada a classe: " +
                            cnfe.getMessage());
                } catch (Exception e)   {e.printStackTrace();}
            }
            for (FiguraGeometrica fig : listfig) {System.out.println(fig);}
            sc.close();
        }
}
