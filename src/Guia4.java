import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Guia4 extends JPanel {

    private GameExemple game;

    public Guia4(GameExemple game){
        this.game = game;
        setLayout(null);

        game.hpPlayerLabel = new JLabel();
        game.hpPlayerLabel.setBounds(10, 10, 100, 20);
        game.hpPlayerLabel.setForeground(Color.RED);

        game.inventoryLabel = new JLabel("Inventário: Espada ");
        game.inventoryLabel.setBounds(10, 30, 200, 20);
        game.inventoryLabel.setForeground(Color.RED);

        add(game.hpPlayerLabel);
        add(game.inventoryLabel);
        game.playerStatus();

        game.dialogoText = new JTextArea();
        game.dialogoText.setBounds(150, 50, 400, 50);
        //dialogoText.setBackground(new Color(0, 0, 0, 140));
        game.dialogoText.setForeground(Color.WHITE);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);

        add(game.dialogoText);

        GerenciadorDeDialogos dialogosGuia4 = new GerenciadorDeDialogos(new String[]{
                "Olá, eu sou o personagem 1.",
                "Legal te conhecer! Eu sou o personagem 2."

        });

        game.dialogoText.setText(dialogosGuia4.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dialogosGuia4.hasNextDialogo()) {
                    dialogosGuia4.avancarDialogo();
                    game.dialogoText.setText(dialogosGuia4.getDialogoAtual());
                } else {
                    JButton continua = new JButton("Continuar");
                    continua.setBounds(850, 680, 150, 70);
                    continua.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            game.exibirFim();
                        }
                    });
                    repaint();//evita botao escondido!!!
                    add(continua);
                }

            }
        });



    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // imagem do fundo do jogo usando paint component
        ImageIcon imageIcon = new ImageIcon("D:\\outroJavaJogo/imagens/conversaGuia4.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}