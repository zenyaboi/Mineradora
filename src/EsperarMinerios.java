public class EsperarMinerios extends EstadoAbstrato<Vendedor> {
    public EsperarMinerios(Vendedor personagem) {
        super(personagem);
    }

    @Override
    public void entrar() {
        System.out.println("O vendedor agora está aguardando algum minério ser entregue...");
    }

    @Override
    public void executar() {
        System.out.println("+---- Vendedor ----+");
        System.out.println("O vendedor está esperando minérios...");
        getPersonagem().setMinerioVendido(0);

        if(getPersonagem().getMinerioEstocado() > 0) {
            getPersonagem().setEstado(new VenderMinerio(getPersonagem() ));
        }
    }
}
