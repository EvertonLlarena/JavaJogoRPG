import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Guia2 extends JPanel {

    private GameExemple game;

    public Guia2(GameExemple game){
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
        game.dialogoText.setBounds(150, 50, 800, 250);
        game.dialogoText.setForeground(Color.ORANGE);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);

        add(game.dialogoText);

        GerenciadorDeDialogos dialogosGuia2 = new GerenciadorDeDialogos(new String[]{
                "Guia: Muito bem, jovem guerreiro! Você sobreviveu ao encontro contra o aterrorizante Wendingo.",
                ""+game.nomeJogador+": Arg, olá de novo. Você sussurra baixinho: 'Obrigado pela ajuda'.",
                "Guia: Disponha. Agora voce enfrentará uma monstra maligna, cheia de ódio e rancor dentro de si. Esse ser se chama Yuki-Onna!",
                "Deixe me contar um pouco sobre a história dela: ",
                "Nem todos que tentaram fugir da nevasca conseguiram. O clima ficou confuso, e o ambiente como um labirinto.",
                "Uma moça e seu grupo estavam nessa situação, até ela ter se machucado na peregrinação."+
                        "Seus companheiros, vendo-a como um estorvo e desperdício de recursos, abandonaram-na.",
                "Ela morreu sozinha e em agonia, querendo apenas que sua dor parasse",
                ""+game.nomeJogador+": Tenso!",
                "Guia: Bom, contra ela eu posso lhe ajudar oferecendo mais 3 itens, escolha-os sabiamente: "

        });

        game.dialogoText.setText(dialogosGuia2.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dialogosGuia2.hasNextDialogo()) {
                    dialogosGuia2.avancarDialogo();
                    game.dialogoText.setText(dialogosGuia2.getDialogoAtual());
                } else {
                    ImageIcon velaIcon = new ImageIcon("D:\\outroJavaJogo/imagens/velaCerimonial.png");
                    JLabel velaCerimonial = new JLabel(velaIcon);
                    velaCerimonial.setBounds(285, 440, velaIcon.getIconWidth(), velaIcon.getIconHeight());
                    velaCerimonial.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu VELA CERIMONIAL como seu item! Efeito: bom contra aparições.");
                            game.inventoryLabel.setText("Inventário: Espada, Vela cerimonial");

                            if(game.botaoContinuarAtual != null){
                                remove(game.botaoContinuarAtual);
                            }

                            JButton botao1 = new JButton("Continuar");
                            botao1.setBounds(850, 300, 150, 70);
                            botao1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "Vela cerimonial";
                                    game.exibirBatalha2();
                                }
                            });
                            add(botao1);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.botaoContinuarAtual = botao1;

                        }
                    });

                    ImageIcon talismaIcon = new ImageIcon("D:\\outroJavaJogo/imagens/talisma.png");
                    JLabel talisma = new JLabel(talismaIcon);
                    talisma.setBounds(435, 440, talismaIcon.getIconWidth(), talismaIcon.getIconHeight());
                    talisma.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu TALISMÃ como seu item! Efeito: ruim para as aparições");
                            game.inventoryLabel.setText("Inventário: Espada, Talisma");

                            if(game.botaoContinuarAtual != null){
                                remove(game.botaoContinuarAtual);
                            }

                            JButton botao2 = new JButton("Continuar");
                            botao2.setBounds(850, 460, 150, 70);
                            botao2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "Talisma";
                                    game.exibirBatalha2();
                                }
                            });
                            add(botao2);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.botaoContinuarAtual = botao2;

                        }
                    });

                    ImageIcon kitIcon = new ImageIcon("D:\\outroJavaJogo/imagens/kitMedico.png");
                    JLabel kitMedico = new JLabel(kitIcon);
                    kitMedico.setBounds(585, 440, kitIcon.getIconWidth(), kitIcon.getIconHeight());
                    kitMedico.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu KIT MÉDICO como seu item! Efeito: cura!?");
                            game.inventoryLabel.setText("Inventário: Espada, Kit medico");

                            if(game.botaoContinuarAtual != null){
                                game.remove(game.botaoContinuarAtual);
                            }

                            JButton botao3 = new JButton("Continuar");
                            botao3.setBounds(850, 680, 150, 70);
                            botao3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "Kit medico";
                                    game.exibirBatalha2();
                                }
                            });
                            add(botao3);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.botaoContinuarAtual = botao3;

                        }
                    });
                    add(velaCerimonial);
                    add(talisma);
                    add(kitMedico);

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
        ImageIcon imageIcon = new ImageIcon("D:\\outroJavaJogo/imagens/conversaGuia2.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
