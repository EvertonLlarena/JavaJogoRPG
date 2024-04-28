import javax.swing.JPanel;

public class MasterClass extends JPanel{
    public String nomeDoCenario;
    public String nomeDoPersonagem;

    public void reloadCenario(GameExemple game, String nomeDoCenario){
        game.getContentPane().removeAll();

        if(nomeDoCenario.equals("Guia1")){
            Guia1 guia1 = new Guia1(game);
            game.setContentPane(guia1);
        }

        if(nomeDoCenario.equals("Guia2")){
            Guia2 guia2 = new Guia2(game);
            game.setContentPane(guia2);
        }

        if(nomeDoCenario.equals("Guia3")){
            Guia3 guia3 = new Guia3(game);
            game.setContentPane(guia3);
        }

        game.repaint();
        game.revalidate();
    }
}