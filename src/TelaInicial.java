import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaInicial extends JPanel {
    private static final long serialVersionUID = 6529685098267757690L;
    public TelaInicial(GameExemple game) {
        setLayout(null);

        JButton novoJogoButton = new JButton("Novo Jogo");
        novoJogoButton.setBounds(412, 340, 200, 50);
        novoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chame o método da classe principal para continuar o jogo
                GameExemple game = (GameExemple) SwingUtilities.getWindowAncestor(TelaInicial.this);
                game.exibirTelaCadastroJogador();
            }
        });
        CarregamentoButton carregarJogoButton = new CarregamentoButton(game, this);
        carregarJogoButton.setText("Carregar Jogo");
        carregarJogoButton.setBounds(412, 450, 200, 50);
        add(novoJogoButton);
        add(carregarJogoButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // imagem do fundo do jogo usando paint component
        ImageIcon imageIcon = new ImageIcon("./imagens/menuInicialImagem.jpeg");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
