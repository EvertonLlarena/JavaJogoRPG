import java.io.File;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarregamentoButton extends JButton{
    public CarregamentoButton(GameExemple game, TelaInicial menu){
        
        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                File savesFolder = new File("./Saves");
                File[] saves = savesFolder.listFiles();
                if(saves.length != 0){
                    menu.removeAll();
                    int y = 300;
                    for(File save : saves){
                        final File saveFile = save; // Referência final para o arquivo
                        CarregarSaveButton button = new CarregarSaveButton(saveFile, game);
                        button.setText(save.getName());
                        button.setBounds(437, y, 150, 50);
                        y += 60;

                        menu.add(button);
                    }
                    menu.repaint();
                    menu.revalidate();
                }
                else{}
            }
        });
    }
}
