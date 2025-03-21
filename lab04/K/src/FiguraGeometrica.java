/*
 * Classe responsável pela generalização das figuras geometricas criadas
 * @author Rodrigo Linhas a83929.
 * @version 21/03/2025.
 * @inv Os metodos dentro desta classe tem que ser utilizados nas
 * @inv especializações
 */
abstract class FiguraGeometrica {
    /*
     * Metodo toString que irá ser usado nas outras classes
     */
    abstract public String toString();

    /*
     * Metodo translação que irá ser usado nas outras classes
     * @param dx translação do eixo x
     * @param dy translação do eixo y
     * @return novo objeto com a translação aplicada
     */
    abstract FiguraGeometrica translacao(int dx, int dy);
}