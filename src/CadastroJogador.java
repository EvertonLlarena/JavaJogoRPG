import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CadastroJogador extends JPanel {

    private GameExemple game;
    public CadastroJogador(GameExemple game) {
        this.game = game;
        setLayout(null);

        JTextField nomeTextField = new JTextField("Insira seu nome aqui");
        nomeTextField.setBounds(412, 340, 200, 30);
        add(nomeTextField);

        JButton iniciarJogoButton = new JButton("Iniciar Jogo");
        iniciarJogoButton.setBounds(412, 400, 200, 50);
        iniciarJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.nomeJogador = nomeTextField.getText();
                game.exibirPrologo();
            }
        });
        add(iniciarJogoButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imageIcon = new ImageIcon("./imagens/menuInicialImagem.jpeg");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
