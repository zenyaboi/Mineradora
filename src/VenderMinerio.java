public class VenderMinerio extends EstadoAbstrato<Vendedor>{
    public VenderMinerio(Vendedor personagem) {
        super(personagem);
    }

    @Override
    public void entrar() {
        System.out.println("Vendedor começou a vender os minérios...");
    }

    @Override
    public void executar() {
        if(getPersonagem().getMinerioEstocado() - 3 >= 0) {
            getPersonagem().addMinerioEstocado(-3);
            getPersonagem().setMinerioVendido(3);
            getPersonagem().imprimirStatus();
        }
        else {
            getPersonagem().setMinerioVendido(getPersonagem().getMinerioEstocado());
            getPersonagem().addMinerioEstocado(-getPersonagem().getMinerioEstocado() );
            getPersonagem().imprimirStatus();
        }

        if(getPersonagem().getMinerioEstocado() <= 0) {
            getPersonagem().setEstado(new EsperarMinerios(getPersonagem() ));
        }
    }

    @Override
    public void sair() {
        System.out.println("Entregas realizadas!");
    }
}
