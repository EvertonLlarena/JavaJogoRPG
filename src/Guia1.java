import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Guia1 extends MasterClass {
    private GameExemple game;

    public Guia1(GameExemple game){
        this.game = game;
        this.nomeDoPersonagem = game.nomeJogador;
        this.nomeDoCenario = "Guia1";
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
        game.dialogoText.setBounds(150, 50, 800, 300);
        game.dialogoText.setForeground(Color.BLACK);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);

        add(game.dialogoText);

        GerenciadorDeDialogos dialogosGuia1 = new GerenciadorDeDialogos(new String[]{
                ""+game.nomeJogador+": Quem é você? Por acaso é um dos monstros que por aqui vagueiam?",
                "Guia: Não, para a sua sorte."+" Os monstros que por aqui vivem são muitos poderosos, você não teria a mínima chance contra eles usando apenas essa espada." +
                        "Um dos mais terriveis, Wendingo, é o que você provavelmente enfrentará primeiro. Vou lhe contar um pouco sobre a história dele: ",
                "Guia: Há muito tempo atrás, houve uma intensa nevasca nessas montanhas de gelo, que obrigou boa parte dos moradores a procurarem outro lugar para morar.",
                "Guia: Mas nem todos os moradores da montanha desistiram de morar lá depois que a nevasca começou. "+
                        "Um homem persistiu com tudo o que tinha para ficar lá, mas os recursos estavam ficando escassos. ",
                "Guia: Ele teve de recorrer a viver na miséria para sobreviver, se sustentando apenas comendo cascas de árvore.",
                "Guia: Quando ele finalmente decidiu ir embora, já era tarde demais. " +
                        "Ele sucumbiu à fome, desejando apenas por uma refeição de qualidade.",
                ""+game.nomeJogador+": Tá, mas por que você está me contando tudo isso? quem é você afinal?",
                "Guia: pode me chamar de Guia, eu irei guiá-lo em sua jornada para derrotar os monstros que aqui habitam, e trazer paz a suas almas.",
                ""+game.nomeJogador+": E como você planeja me ajudar? Você parece mais uma assombração que não derrotaria nem uma criança, hahaha.",
                "Guia: Ah, meu caro jovem, vejo que você tem muito o que aprender ainda.",
                ""+game.nomeJogador+": Tá, deixa de papo furado e me diz logo como você planeja ser útil para mim.",
                "Guia: Tenho em minha disposição itens que vão lhe ajudar em sua batalha contrar os monstros dessa montanha, se você optar em usá-los.",
                "Guia: Lhe darei 3 opções de item, escolha com sabedoria e siga em frente em sua trajetória: "



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
                    ImageIcon armadilhaIcon = new ImageIcon("./imagens/armadilha.png");
                    JLabel armadilha = new JLabel(armadilhaIcon);
                    armadilha.setBounds(285, 440, armadilhaIcon.getIconWidth(), armadilhaIcon.getIconHeight());
                    armadilha.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu ARMADILHA como seu item! Efeito: Dano aterrorizante." );

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon1 = new ImageIcon("./imagens/armadilha.png");
                            JLabel item1 = new JLabel(itemIcon1);
                            item1.setBounds(1, 170, itemIcon1.getIconWidth(), itemIcon1.getIconHeight());

                            JButton botao1 = new JButton("Continuar");
                            botao1.setBounds(850, 680, 150, 70);
                            botao1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "armadilha";
                                    game.exibirBatalha1();
                                }
                            });
                            add(item1);
                            add(botao1);


                            revalidate();
                            repaint();//evita botao escondido!!!
                            requestFocus();

                            game.itemTroca = item1;
                            game.botaoContinuarAtual = botao1;


                        }
                    });

                    ImageIcon armaduraIcon = new ImageIcon("./imagens/armadura.png");
                    JLabel armadura = new JLabel(armaduraIcon);
                    armadura.setBounds(435, 440, armaduraIcon.getIconWidth(), armaduraIcon.getIconHeight());
                    armadura.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu ARMADURA como seu item! Efeito: Resistência a dano.");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon2 = new ImageIcon("./imagens/armadura.png");
                            JLabel item2 = new JLabel(itemIcon2);
                            item2.setBounds(1, 170, itemIcon2.getIconWidth(), itemIcon2.getIconHeight());

                            JButton botao2 = new JButton("Continuar");
                            botao2.setBounds(850, 680, 150, 70);
                            botao2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "armadura";
                                    game.exibirBatalha1();
                                }
                            });
                            add(item2);
                            add(botao2);


                            revalidate();
                            repaint();//evita botao escondido!!!
                            requestFocus();

                            game.itemTroca = item2;
                            game.botaoContinuarAtual = botao2;


                        }
                    });

                    ImageIcon coxaIcon = new ImageIcon("./imagens/coxaDeGalinha.png");
                    JLabel coxa = new JLabel(coxaIcon);
                    coxa.setBounds(585, 440, coxaIcon.getIconWidth(), coxaIcon.getIconHeight());
                    coxa.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            game.dialogoText.setText("Você escolheu COXA DE GALINHA como seu item! Efeito: Deliciosa.");

                            if(game.botaoContinuarAtual != null){
                                remove(game.itemTroca);
                                remove(game.botaoContinuarAtual);

                                revalidate();
                                repaint();
                            }

                            ImageIcon itemIcon3 = new ImageIcon("./imagens/coxaDeGalinha.png");
                            JLabel item3 = new JLabel(itemIcon3);
                            item3.setBounds(1, 170, itemIcon3.getIconWidth(), itemIcon3.getIconHeight());

                            JButton botao3 = new JButton("Continuar");
                            botao3.setBounds(850, 680, 150, 70);
                            botao3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    game.nomeItem = "coxaDeGalinha";
                                    game.exibirBatalha1();
                                }
                            });
                            add(item3);
                            add(botao3);


                            revalidate();
                            repaint();//evita botao escondido!!!
                            requestFocus();

                            game.itemTroca = item3;
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
        ImageIcon imageIcon = new ImageIcon("./imagens/conversaGuia1.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
