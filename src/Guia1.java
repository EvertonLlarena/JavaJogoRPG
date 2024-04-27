import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Guia1 extends JPanel {

    private GameExemple game;

    public Guia1(GameExemple game){
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

        GerenciadorDeDialogos dialogosGuia1 = new GerenciadorDeDialogos(new String[]{
                "Olá, eu sou o personagem 1.",
                "Legal te conhecer! Eu sou o personagem 2."

        });

        game.dialogoText.setText(dialogosGuia1.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dialogosGuia1.hasNextDialogo()) {
                    dialogosGuia1.avancarDialogo();
                    game.dialogoText.setText(dialogosGuia1.getDialogoAtual());
                } else {
                    ImageIcon armadilhaIcon = new ImageIcon("D:\\outroJavaJogo/imagens/armadilha.png");
                    JLabel armadilha = new JLabel(armadilhaIcon);
                    armadilha.setBounds(285, 440, armadilhaIcon.getIconWidth(), armadilhaIcon.getIconHeight());
                    armadilha.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu ARMADILHA como seu item!");
                            game.inventoryLabel.setText("Inventário: Espada, Armadilha");

                            if(game.botaoContinuarAtual != null){
                                remove(game.botaoContinuarAtual);
                            }

                            JButton botao1 = new JButton("Continuar");
                            botao1.setBounds(850, 300, 150, 70);
                            botao1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "Armadilha";
                                    game.exibirBatalha1();
                                }
                            });
                            add(botao1);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.botaoContinuarAtual = botao1;

                        }
                    });

                    ImageIcon armaduraIcon = new ImageIcon("D:\\outroJavaJogo/imagens/armadura.png");
                    JLabel armadura = new JLabel(armaduraIcon);
                    armadura.setBounds(435, 440, armaduraIcon.getIconWidth(), armaduraIcon.getIconHeight());
                    armadura.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu ARMADURA como seu item!");
                            game.inventoryLabel.setText("Inventário: Espada, Armadura");

                            if(game.botaoContinuarAtual != null){
                                remove(game.botaoContinuarAtual);
                            }

                            JButton botao2 = new JButton("Continuar");
                            botao2.setBounds(850, 460, 150, 70);
                            botao2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "Armadura";
                                    game.exibirBatalha1();
                                }
                            });
                            add(botao2);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.botaoContinuarAtual = botao2;

                        }
                    });

                    ImageIcon coxaIcon = new ImageIcon("D:\\outroJavaJogo/imagens/coxaDeGalinha.png");
                    JLabel coxa = new JLabel(coxaIcon);
                    coxa.setBounds(585, 440, coxaIcon.getIconWidth(), coxaIcon.getIconHeight());
                    coxa.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu COXA DE GALINHA como seu item!");
                            game.inventoryLabel.setText("Inventário: Espada, Coxa de galinha");

                            if(game.botaoContinuarAtual != null){
                                game.remove(game.botaoContinuarAtual);
                            }

                            JButton botao3 = new JButton("Continuar");
                            botao3.setBounds(850, 680, 150, 70);
                            botao3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "Coxa de galinha";
                                    game.exibirBatalha1();
                                }
                            });
                            add(botao3);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.botaoContinuarAtual = botao3;

                        }
                    });
                    add(armadilha);
                    add(armadura);
                    add(coxa);

                    revalidate();
                    repaint();
                    requestFocus();

                }

                }
            });



    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // imagem do fundo do jogo usando paint component
        ImageIcon imageIcon = new ImageIcon("D:\\outroJavaJogo/imagens/conversaGuia1.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
