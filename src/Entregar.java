public class Entregar extends EstadoAbstrato<Minerador>{
    public Entregar(Minerador personagem) {
        super(personagem);
    }

    @Override
    public void entrar() {
        System.out.println("Minerador saiu para entregas...");
    }

    @Override
    public void executar() {
        if(getPersonagem().getMinerio() - 5 >= 0) {
            getPersonagem().addMinerio(-5);
            getPersonagem().getVendedor().addMinerioEstocado(5);
        }
        else {
            getPersonagem().getVendedor().addMinerioEstocado(getPersonagem().getMinerio());
            getPersonagem().addMinerio(-getPersonagem().getMinerio());
        }
        getPersonagem().addCansaco(1);
        getPersonagem().imprimirStatus();

        if(getPersonagem().getCansaco() > 12) {
            getPersonagem().setEstado(new Descansar(getPersonagem() ));
        }
        if(getPersonagem().getMinerio() <= 0) {
            getPersonagem().setEstado(new Minerar(getPersonagem() ));
        }
    }
}
