/*
 * Classe responsável pela generalização das figuras geométricas criadas.
 * @author      Rodrigo Linhas a83929.
 * @version     21/03/2025.
 * @inv         Os métodos dentro desta classe devem ser utilizados nas especializações.
 */
abstract class FiguraGeometrica {
    /*
     * Método toString que será usado nas outras classes.
     * @return Representação em string da figura geométrica.
     */
    abstract public String toString();

    /*
     * Método translação que será usado nas outras classes.
     * @param dx Translação no eixo x.
     * @param dy Translação no eixo y.
     * @return Novo objeto com a translação aplicada.
     */
    abstract FiguraGeometrica translacao(int dx, int dy);

    /*
     * Método para verificar colisão entre figuras geométricas.
     * @param outra Figura geométrica a ser verificada.
     * @return true se houver colisão, false caso contrário.
     */
    abstract boolean colideCom(FiguraGeometrica outra);
}