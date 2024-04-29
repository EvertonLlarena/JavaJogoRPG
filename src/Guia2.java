import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Guia2 extends MasterClass {

    private GameExemple game;

    public Guia2(GameExemple game){
        this.game = game;
        this.nomeDoPersonagem = game.nomeJogador;
        this.nomeDoCenario = "Guia2";
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

        add(new SaveButton(game, this));
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

        GerenciadorDeDialogos dialogosGuia2 = new GerenciadorDeDialogos(new String[]{
                "Guia: Muito bem, jovem guerreiro! Você sobreviveu ao encontro contra o aterrorizante Wendingo.",
                ""+game.nomeJogador+": Arg, olá de novo. Você sussurra baixinho: 'Obrigado pela ajuda'.",
                "Guia: Disponha. Agora voce enfrentará uma monstra maligna, cheia de ódio e rancor dentro de si. Esse ser se chama Yuki-Onna!",
                "Guia: Deixe me contar um pouco sobre a história dela.",
                "Guia: Nem todos que tentaram fugir da nevasca conseguiram. O clima ficou confuso, e o ambiente como um labirinto.",
                "Guia: Uma moça e seu grupo estavam nessa situação, até ela ter se machucado na peregrinação."+
                        " Seus companheiros, vendo-a como um estorvo e desperdício de recursos, abandonaram-na.",
                "Guia: Ela morreu sozinha e em agonia, querendo apenas que sua dor parasse",
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
                    ImageIcon velaIcon = new ImageIcon("./imagens/velaCerimonial.png");
                    JLabel velaCerimonial = new JLabel(velaIcon);
                    velaCerimonial.setBounds(285, 440, velaIcon.getIconWidth(), velaIcon.getIconHeight());
                    velaCerimonial.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu VELA CERIMONIAL como seu item! Efeito: bom contra aparições.");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon1 = new ImageIcon("./imagens/velaCerimonial.png");
                            JLabel item1 = new JLabel(itemIcon1);
                            item1.setBounds(1, 170, itemIcon1.getIconWidth(), itemIcon1.getIconHeight());

                            JButton botao1 = new JButton("Continuar");
                            botao1.setBounds(850, 680, 150, 70);
                            botao1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "velaCerimonial";
                                    game.exibirBatalha2();
                                }
                            });
                            add(item1);
                            add(botao1);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.itemTroca = item1;
                            game.botaoContinuarAtual = botao1;


                        }
                    });

                    ImageIcon talismaIcon = new ImageIcon("./imagens/talisma.png");
                    JLabel talisma = new JLabel(talismaIcon);
                    talisma.setBounds(435, 440, talismaIcon.getIconWidth(), talismaIcon.getIconHeight());
                    talisma.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu TALISMÃ como seu item! Efeito: ruim para as aparições");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon2 = new ImageIcon("./imagens/talisma.png");
                            JLabel item2 = new JLabel(itemIcon2);
                            item2.setBounds(1, 170, itemIcon2.getIconWidth(), itemIcon2.getIconHeight());

                            JButton botao2 = new JButton("Continuar");
                            botao2.setBounds(850, 680, 150, 70);
                            botao2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "talisma";
                                    game.exibirBatalha2();
                                }
                            });
                            add(item2);
                            add(botao2);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.itemTroca = item2;
                            game.botaoContinuarAtual = botao2;

                        }
                    });

                    ImageIcon kitIcon = new ImageIcon("./imagens/kitMedico.png");
                    JLabel kitMedico = new JLabel(kitIcon);
                    kitMedico.setBounds(585, 440, kitIcon.getIconWidth(), kitIcon.getIconHeight());
                    kitMedico.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu KIT MÉDICO como seu item! Efeito: cura!?");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon3 = new ImageIcon("./imagens/kitMedico.png");
                            JLabel item3 = new JLabel(itemIcon3);
                            item3.setBounds(1, 170, itemIcon3.getIconWidth(), itemIcon3.getIconHeight());

                            JButton botao3 = new JButton("Continuar");
                            botao3.setBounds(850, 680, 150, 70);
                            botao3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "kitMedico";
                                    game.exibirBatalha2();
                                }
                            });
                            add(item3);
                            add(botao3);

                            revalidate();
                            repaint();//evita botao escondido!!!

                            game.itemTroca = item3;
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
        ImageIcon imageIcon = new ImageIcon("./imagens/conversaGuia2.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
