import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InicioJogo extends JPanel{

    private GameExemple game;

    public InicioJogo(GameExemple game){
        this.game = game;
        setLayout(null);

        game.dialogoText = new JTextArea();
        game.dialogoText.setBounds(150, 50, 800, 150);
        game.dialogoText.setForeground(Color.YELLOW);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);
        add(game.dialogoText);

        GerenciadorDeDialogos dialogosPrologo = new GerenciadorDeDialogos(new String[]{
                "Vô Charles: Há quanto tempo, meu neto. Vejo que você cresceu e se tornou um jovem forte. O que trás você de volta a casa do seu velho?",
                ""+game.nomeJogador+": Prazer em revê-lo, vovô Charles! " +
                        "Recentemente me veio a mente as histórias que o senhor me contava sobre os monstros que coabitam essas montanhas. Eles ainda existem?",
                "Vô Charles: Haha, então é por isso que você veio. Me lembro muito bem de como você morria de medo desses monstros quando criança." +
                        "E sim, eles ainda existem, quer dizer, pelo menos 3 deles, o restante já se desvaneceram há algum tempo.",
                ""+game.nomeJogador+": Então quer dizer que 3 deles ainda perambulam por essas gélidas montanhas. "+
                        "Eu irei atrás desses monstros que restam, vovô. E irei extingui-los desse lugar de uma por todas.",
                "Vô Charles: Se é isso que deseja, meu neto, permita-me lhe dar esta Espada, para ajudá-lo em sua jornada."+
                        "Tome muito cuidado, nessas montanhas, a morte é o que menos pior lhe pode acontecer.",
                ""+game.nomeJogador+": Não se preocupe, vovô. Eu irei voltar são e salvo!"

        });

        game.dialogoText.setText(dialogosPrologo.getDialogoAtual());

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "avancarDialogo");
        actionMap.put("avancarDialogo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dialogosPrologo.hasNextDialogo()) {
                    dialogosPrologo.avancarDialogo();
                    game.dialogoText.setText(dialogosPrologo.getDialogoAtual());
                } else {
                    JButton continua = new JButton("continuar");
                    continua.setBounds(850, 680, 150, 70);
                    continua.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            game.exibirGuia1();

                        }
                    });
                    game.repaint();
                    add(continua);
                }
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imageIcon = new ImageIcon("./imagens/inicioCabanaHistoria.jpeg");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
