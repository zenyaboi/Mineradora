import java.util.ArrayList;
import java.util.List;

public class GerenciadorAgentes {
    List<Personagem> personagens = new ArrayList<Personagem>();

    public void IniciarLoop() {
        personagens.add(new Vendedor());
        personagens.add(new Minerador((Vendedor) personagens.get(0)));

        while(true) {
            for (int i = personagens.size() - 1; i >= 0; i--) {
                personagens.get(i).fazer();
            }
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
