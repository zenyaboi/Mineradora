public class Minerar extends EstadoAbstrato<Minerador> {

    public Minerar(Minerador personagem) {
        super(personagem);
    }

    @Override
    public void entrar() {
        System.out.println("Minerador foi minerar...");
    }

    @Override
    public void executar() {
        getPersonagem().addMinerio(5);
        getPersonagem().addCansaco(2);
        getPersonagem().imprimirStatus();

        if(getPersonagem().getCansaco() > 12){
            getPersonagem().setEstado(new Descansar(getPersonagem() ));
        }
        if(getPersonagem().getMinerio() > 20){
            getPersonagem().setEstado(new Entregar(getPersonagem() ));
        }
    }
}
