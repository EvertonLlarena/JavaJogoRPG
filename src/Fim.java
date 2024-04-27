import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Fim extends JPanel {
    private GameExemple game;

    public Fim(GameExemple game){
        this.game = game;
        setLayout(null);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // imagem do fundo do jogo usando paint component
        ImageIcon imageIcon = new ImageIcon("D:\\outroJavaJogo/imagens/prologo.jpeg");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
