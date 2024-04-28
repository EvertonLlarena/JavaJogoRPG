import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;

public class CarregarSaveButton extends JButton{
    public CarregarSaveButton(File saveFile, GameExemple game){
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    FileInputStream arq = new FileInputStream(saveFile.getPath());
                    ObjectInputStream obj = new ObjectInputStream(arq);
                    MasterClass cenario = (MasterClass) obj.readObject();
                    String nomeDoCenario = cenario.nomeDoCenario;
                    game.nomeJogador = cenario.nomeDoPersonagem;
                    cenario.reloadCenario(game, nomeDoCenario);
                    obj.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
