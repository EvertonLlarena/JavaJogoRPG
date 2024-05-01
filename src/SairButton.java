import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SairButton extends JButton{
    public SairButton(GameExemple game){
        this.setText("SAIR");
        this.setBounds(924, 0, 100, 50);
        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.getContentPane().removeAll();

                TelaInicial menuInicial = new TelaInicial(game);
                game.setContentPane(menuInicial);

                game.repaint();
                game.revalidate();
            }
        });
    }
}
