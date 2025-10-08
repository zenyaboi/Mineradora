public class Descansar extends EstadoAbstrato<Minerador>{
    public Descansar(Minerador personagem) {
        super(personagem);
    }

    @Override
    public void entrar() {
        System.out.println("O minerador foi descansar...");
    }

    @Override
    public void executar() {
        getPersonagem().addCansaco(-4);



        getPersonagem().imprimirStatus();

        if(getPersonagem().getCansaco() <= 0) {
            if(getPersonagem().getMinerio() > 20) {
                getPersonagem().setEstado(new Entregar(getPersonagem() ));
            }
            else {
                getPersonagem().setEstado(new Minerar(getPersonagem() ));
            }
        }
    }

    @Override
    public void sair() {
        System.out.println("O minerador descansou, voltando ao trabalho!");
    }
}
