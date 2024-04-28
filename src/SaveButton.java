import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;

public class SaveButton extends JButton{
    public SaveButton(GameExemple game, MasterClass cenario){
        this.setText("SAIR");
        this.setBounds(914, 1, 100, 50);
        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    game.getContentPane().removeAll();

                    TelaInicial menuInicial = new TelaInicial(game);
                    game.setContentPane(menuInicial);

                    game.repaint();
                    game.revalidate();
                    
                    FileOutputStream arq = new FileOutputStream("./Saves/" + game.nomeJogador + "-save.arq");
                    ObjectOutputStream obj = new ObjectOutputStream(arq);
                    obj.writeObject(cenario);
                    
                    obj.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
