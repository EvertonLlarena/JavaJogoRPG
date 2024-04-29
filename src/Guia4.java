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
        game.hpPlayerLabel.setFont(new Font("Arial", Font.BOLD, 20));

        ImageIcon espadaIcon = new ImageIcon("./imagens/espada.png");
        JLabel espada = new JLabel(espadaIcon);
        espada.setBounds(18, 70, espadaIcon.getIconWidth(), espadaIcon.getIconHeight());
        game.inventoryLabel = new JLabel("Inventário:  ");
        game.inventoryLabel.setBounds(10, 30, 120, 50);
        game.inventoryLabel.setForeground(Color.RED);
        game.inventoryLabel.setFont(new Font("Arial", Font.BOLD, 20));

        add(game.hpPlayerLabel);
        add(game.inventoryLabel);
        add(espada);
        game.playerStatus();

        game.dialogoText = new JTextArea();
        game.dialogoText.setBounds(150, 50, 800, 250);
        game.dialogoText.setForeground(Color.ORANGE);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);

        add(game.dialogoText);

        GerenciadorDeDialogos dialogosGuia4 = new GerenciadorDeDialogos(new String[]{
                "Guia: Meu parabéns, meu caro jovem. Você conseguiu derrotar todos os monstros que ainda restavam por essas montanhas." +
                        "Agora você pode voltar para casa, e eu irei seguir em minha trilha sem destino.",
                ""+game.nomeJogador+": Sabe, o meu avô me disse uma vez que quando se navega sem destino, nenhum vento é favorável."+
                        " Obrigado por guiar meu caminho.",
                "Guia: Olha só, parece que o nosso pequeno jovem cresceu! Boa sorte em sua vida, meu caro rapaz, "+
                        "me sinto em paz por saber que seu destino não será o mesmo que o meu.",
                ""+game.nomeJogador+": O que você quiz dizer com is... Espere! Não vá ainda!",
                "O espiríto guia seguiu seu caminho rapidamente, até não ser mais possível avistá-lo."

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
        ImageIcon imageIcon = new ImageIcon("./imagens/conversaGuia4.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}