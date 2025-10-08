public class Minerador implements Personagem {
    private int minerio = 0;
    private int cansaco = 0;

    private Vendedor vendedor;

    private EstadoAbstrato estado = new Minerar(this);

    public Minerador(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getMinerio() {
        return minerio;
    }

    public int getCansaco() {
        return cansaco;
    }

    public void addMinerio(int valor) {

        this.minerio += valor;
    }

    public void addCansaco(int valor) {

        this.cansaco += valor;
        this.cansaco = Math.max(this.cansaco, 0);
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public void imprimirStatus() {
        System.out.println("+---- Minerador ----+\nMinérios: "+minerio+"\nCansaço: "+cansaco);
    }

    @Override
    public void fazer() {
        estado.executar();
    }

    @Override
    public void setEstado(EstadoAbstrato estado) {
        this.estado.sair();
        this.estado = estado;
        this.estado.entrar();
    }
}