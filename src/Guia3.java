import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Guia3 extends MasterClass {

    private GameExemple game;

    public Guia3(GameExemple game){
        this.game = game;
        this.nomeDoPersonagem = game.nomeJogador;
        this.nomeDoCenario = "Guia3";
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

        GerenciadorDeDialogos dialogosGuia3 = new GerenciadorDeDialogos(new String[]{
                ""+game.nomeJogador+": (Fingindo supresa) É claro que você está por aqui.",
                "Guia: Mandou bem em sua batalha contra a Yuki-Onno, ela não era uma gracinha?",
                ""+game.nomeJogador+": Sai pra lá, aquela coisa era feia que doía.",
                "Guia: Agora só lhe resta um último adversário, e o nome dele é Morozko." +
                        "Vou lhe contar um pouca sobre o passado dele.",
                "Guia: Os que persistiam em ficar na montanha não conseguiram sobreviver vivendo honestamente. " +
                        "Eles forçaram outros moradores a ficarem junto com eles, extorquindo seus bens e ameaçando matá-los caso desobedecessem.",
                "Guia: Um velho senhor foi uma das vítimas desses bandidos, que retiraram dele tudo que tinha de valor." +
                        " Ele morreu sem qualquer dinheiro ou bens, ansiando puramente em ter de volta aquilo que lhe foi roubado!",
                "Guia: Tome cuidado com esse inimigo, ele é perigoso. Aqui, escolha dentre esses 3 itens para lhe ajudar em sua batalha: "

        });

        game.dialogoText.setText(dialogosGuia3.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dialogosGuia3.hasNextDialogo()) {
                    dialogosGuia3.avancarDialogo();
                    game.dialogoText.setText(dialogosGuia3.getDialogoAtual());
                } else {
                    ImageIcon lampiaoIcon = new ImageIcon("./imagens/lampiao.png");
                    JLabel lampiao = new JLabel(lampiaoIcon);
                    lampiao.setBounds(285, 440, lampiaoIcon.getIconWidth(), lampiaoIcon.getIconHeight());
                    lampiao.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu LAMPIÃO como seu item! Efeito: incendiar.");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon1 = new ImageIcon("./imagens/lampiao.png");
                            JLabel item1 = new JLabel(itemIcon1);
                            item1.setBounds(1, 170, itemIcon1.getIconWidth(), itemIcon1.getIconHeight());

                            JButton botao1 = new JButton("Continuar");
                            botao1.setBounds(850, 680, 150, 70);
                            botao1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "lampiao";
                                    game.exibirBatalha3();
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

                    ImageIcon escudoIcon = new ImageIcon("./imagens/escudo.png");
                    JLabel escudo = new JLabel(escudoIcon);
                    escudo.setBounds(435, 440, escudoIcon.getIconWidth(), escudoIcon.getIconHeight());
                    escudo.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu ESCUDO como seu item! Efeito: parry.");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon2 = new ImageIcon("./imagens/escudo.png");
                            JLabel item2 = new JLabel(itemIcon2);
                            item2.setBounds(1, 170, itemIcon2.getIconWidth(), itemIcon2.getIconHeight());

                            JButton botao2 = new JButton("Continuar");
                            botao2.setBounds(850, 680, 150, 70);
                            botao2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "escudo";
                                    game.exibirBatalha3();
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

                    ImageIcon dinheiroIcon = new ImageIcon("./imagens/sacoDeDinheiro.png");
                    JLabel sacoDeDinheiro = new JLabel(dinheiroIcon);
                    sacoDeDinheiro.setBounds(585, 440, dinheiroIcon.getIconWidth(), dinheiroIcon.getIconHeight());
                    sacoDeDinheiro.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu SACO DE DINHEIRO como seu item! Efeito: morrer rico!?");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon3 = new ImageIcon("./imagens/sacoDeDinheiro.png");
                            JLabel item3 = new JLabel(itemIcon3);
                            item3.setBounds(1, 170, itemIcon3.getIconWidth(), itemIcon3.getIconHeight());

                            JButton botao3 = new JButton("Continuar");
                            botao3.setBounds(850, 680, 150, 70);
                            botao3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "sacoDeDinheiro";
                                    game.exibirBatalha3();
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
                    add(lampiao);
                    add(escudo);
                    add(sacoDeDinheiro);

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
        ImageIcon imageIcon = new ImageIcon("./imagens/conversaGuia3.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
