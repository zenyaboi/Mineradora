public abstract class EstadoAbstrato<T> implements Estados{

    private T personagem;

    public EstadoAbstrato(T personagem){
        this.personagem = personagem;
    }

    @Override
    public T getPersonagem() {
        return personagem;
    }

    @Override
    public abstract void entrar();

    @Override
    public abstract void executar();

    @Override
    public void sair() {}
}
