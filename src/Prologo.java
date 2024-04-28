import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 class Prologo extends JPanel {

     private GameExemple game;

     public Prologo(GameExemple game){
        this.game = game;
        setLayout(null);
        //requestFocusInWindow();

        game.dialogoText = new JTextArea();
        game.dialogoText.setBounds(150, 50, 800, 150);
        game.dialogoText.setForeground(Color.BLACK);
        game.dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        game.dialogoText.setEditable(false);
        game.dialogoText.setLineWrap(true);
        game.dialogoText.setWrapStyleWord(true);
        game.dialogoText.setOpaque(false);
        add(game.dialogoText);

         GerenciadorDeDialogos dialogosPrologo = new GerenciadorDeDialogos(new String[]{
                 "Prepare-se para começar sua aventura, " + game.nomeJogador +"! Aperte a tecla ENTER para passar os dialogos",
                 "Neste jogo você será um jovem destemido e valente, que fascinado pelas histórias de seu avô Charles, " +
                         "decide iniciar uma jornada perigosa em busca de trazer de volta a paz que antigamente se fazia presente nas frias montanhas de Mount Seymour.",
                 "Certifique-se de apertar o botão continuar para progredir no jogo!"


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
                             System.out.println("funcionando!");
                             game.exibirInicioJogo();
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

         ImageIcon imageIcon = new ImageIcon("./imagens/prologo.jpeg");
         Image image = imageIcon.getImage();
         g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
     }
}
