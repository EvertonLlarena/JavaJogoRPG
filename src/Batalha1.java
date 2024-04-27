import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Batalha1 extends JPanel{

    private GameExemple game;



    public Batalha1(GameExemple game){
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
        game.dialogoText.setBounds(150, 50, 400, 50);
        //dialogoText.setBackground(new Color(0, 0, 0, 140));
        game.dialogoText.setForeground(Color.WHITE);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);

        add(game.dialogoText);


        GerenciadorDeDialogos dialogosBatalha1 = new GerenciadorDeDialogos(new String[]{
                "Olá, eu sou o personagem 1.",
                "Legal te conhecer! Eu sou o personagem 2."

        });

        game.dialogoText.setText(dialogosBatalha1.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dialogosBatalha1.hasNextDialogo()) {
                    dialogosBatalha1.avancarDialogo();
                    game.dialogoText.setText(dialogosBatalha1.getDialogoAtual());
                } else {
                    if (!game.botoesAdicionados) {
                        game.posicao = "batalha1";

                        game.escolha1 = game.escolhaBotao();
                        game.escolha1.setText("Atacar");
                        game.escolha1.setBounds(425, 500, 150, 60);

                        game.escolha1.setActionCommand("b1e1");//para se referir a ação gerada por esse botao especificamente!!!

                        game.escolha1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                remove(game.dialogoText);
                                String suaEscolha1 = e.getActionCommand();
                                game.combateItem(Batalha1.this, suaEscolha1, "");
                            }
                        });

                        game.escolha2 = game.escolhaBotao();
                        game.escolha2.setText("Usar Item");
                        game.escolha2.setBounds(425, 560, 150, 60);

                        game.escolha2.setActionCommand("b1e2");

                        game.escolha2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                remove(game.dialogoText);
                                String suaEscolha2 = e.getActionCommand();
                                game.combateItem(Batalha1.this, suaEscolha2, game.nomeItem);
                            }
                        });

                        repaint();//evita botao escondido!!!
                        add(game.escolha1);
                        add(game.escolha2);

                        game.botoesAdicionados = true;
                    }
                }

            }
        });

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // imagem do fundo do jogo usando paint component
        ImageIcon imageIcon = new ImageIcon("D:\\outroJavaJogo/imagens/batalha1.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }


}
