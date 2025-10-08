public class Vendedor implements Personagem {

    private int minerioEstocado = 0;
    private int minerioVendido = 0;
    private EstadoAbstrato estado = new EsperarMinerios(this);

    public Vendedor() {}

    @Override
    public void imprimirStatus() {
        System.out.println("+---- Vendedor ----+\nMinérios vendidos: " + minerioVendido + "\nMinérios no estoque: "+ minerioEstocado);
    }

    public int getMinerioEstocado() {
        return minerioEstocado;
    }

    public int getMinerioVendido() {
        return minerioVendido;
    }

    public void addMinerioEstocado(int value) {
        minerioEstocado += value;
        minerioEstocado = Math.max(minerioEstocado, 0);
    }

    public void setMinerioVendido(int value) {
        minerioVendido = value;
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
