import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Batalha3 extends JPanel{

    private GameExemple game;

    public Batalha3(GameExemple game){
        this.game = game;
        setLayout(null);

        game.hpMonstroLabel = new JLabel();
        game.hpMonstroLabel.setBounds(800, 10, 100, 20);
        game.hpMonstroLabel.setForeground(Color.RED);

        game.hpPlayerLabel = new JLabel();
        game.hpPlayerLabel.setBounds(10,10,100,20);
        game.hpPlayerLabel.setForeground(Color.RED);

        game.inventoryLabel = new JLabel("Inventário: Espada, " + game.nomeItem);
        game.inventoryLabel.setBounds(10, 30, 200, 20);
        game.inventoryLabel.setForeground(Color.RED);

        add(game.hpMonstroLabel);
        add(game.hpPlayerLabel);
        add(game.inventoryLabel);
        game.monstroStatus();
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


        GerenciadorDeDialogos dialogosBatalha3 = new GerenciadorDeDialogos(new String[]{
                ""+game.nomeJogador+": Então você é o tal do Morozko!",
                "Morozko: Quem ousa me pertubar neste momento!? Mas olha só, uma criançinha perdida. Está procurando a sua mamãe?",
                ""+game.nomeJogador+": NÂO ME CHAME DE CRIANÇA! A única coisa que eu procuro é enfiar a minha espada no meio da sua alma, seu verme.",
                "Morozko: Seus pais não te ensinaram a respeitar os mais velhos, seu moleque!"+
                        " Vai pagar caro por essa sua insolência.",
                ""+game.nomeJogador+"Vem, monstro!"

        });

        game.dialogoText.setText(dialogosBatalha3.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dialogosBatalha3.hasNextDialogo()) {
                    dialogosBatalha3.avancarDialogo();
                    game.dialogoText.setText(dialogosBatalha3.getDialogoAtual());
                } else {
                    if (!game.botoesAdicionados3) {
                        game.posicao = "batalha3";

                        game.escolha1 = game.escolhaBotao();
                        game.escolha1.setText("Atacar");
                        game.escolha1.setBounds(425, 500, 150, 60);

                        game.escolha1.setActionCommand("b3e1");//para se referir a ação gerada por esse botao especificamente!!!

                        game.escolha1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                remove(game.dialogoText);
                                String suaEscolha1 = e.getActionCommand();
                                game.combateItem3(Batalha3.this, suaEscolha1, "");
                            }
                        });

                        game.escolha2 = game.escolhaBotao();
                        game.escolha2.setText("Usar Item");
                        game.escolha2.setBounds(425, 560, 150, 60);

                        game.escolha2.setActionCommand("b3e2");

                        game.escolha2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                remove(game.dialogoText);
                                String suaEscolha2 = e.getActionCommand();
                                game.combateItem3(Batalha3.this, suaEscolha2, game.nomeItem);
                            }
                        });

                        repaint();//evita botao escondido!!!
                        add(game.escolha1);
                        add(game.escolha2);

                        game.botoesAdicionados3 = true;
                    }
                }

            }
        });

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // imagem do fundo do jogo usando paint component
        ImageIcon imageIcon = new ImageIcon("./imagens/batalha3.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }


}
