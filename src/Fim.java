import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Fim extends JPanel {
    private GameExemple game;

    public Fim(GameExemple game) {
        this.game = game;
        setLayout(null);

        game.dialogoText = new JTextArea();
        game.dialogoText.setBounds(150, 50, 800, 250);
        game.dialogoText.setForeground(Color.BLACK);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);

        add(game.dialogoText);

        GerenciadorDeDialogos diaologoFim = new GerenciadorDeDialogos(new String[]{
                ""+game.nomeJogador+" voltou para a cabana de seu avô e contou sua aventura para ele." +
                        "Seu avô Charles ficou muito feliz em ver que o neto tinha voltado são e salvo.",
                "Quando o jovem falou para o avô sobre o guia, o avô ficou pensativo por um tempo e depois disse ao neto: ",
                "Acho que sei quem aquele guia era, há muito tempo atrás um guerreio valente, chamado Artorias, "+
                        "aparceu nas montanhas gélidas do monte Seymour e lutou bravamente contra os monstros que ali habitavam.",
                "Temendo a sua imensa força, os 3 monstros: Wendingo,Yuki-Onna e Worozko. Juntaram forças para derrotar Artorias.",
                "Artorias não conseguiu superar a força dos 3 monstros juntos e sucumbiu, restando só o seu espiríto, "+
                        "que vagava pelas montanhas em busca de vingança contra os 3 monstros que o derrotaram."


        });

        game.dialogoText.setText(diaologoFim.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (diaologoFim.hasNextDialogo()) {
                    diaologoFim.avancarDialogo();
                    game.dialogoText.setText(diaologoFim.getDialogoAtual());
                }else{
                    remove(game.dialogoText);
                    JLabel fim = new JLabel();
                    fim.setForeground(Color.RED);
                    fim.setFont(new Font("Arial",Font.BOLD,150));
                    fim.setBounds(380,240,400,400);
                    fim.setText("FIM");
                    add(fim);
                }

                revalidate();
                repaint();
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // imagem do fundo do jogo usando paint component
        ImageIcon imageIcon = new ImageIcon("D:\\outroJavaJogo/imagens/prologo.jpeg");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);


    }
}
