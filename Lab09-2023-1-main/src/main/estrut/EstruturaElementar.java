package estrut;
public interface EstruturaElementar {
    //Métodos Consultivos
    public boolean buscaElemento(int valor);
    public int minimo();
    public int maximo();

    //Metodos Modificadores
    public void insereElemento(int valor);
    public void remove(int valor);
    // Método para obter a altura de uma árvor

}
