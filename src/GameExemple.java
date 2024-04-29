import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameExemple extends JFrame {

    protected String nomeJogador, nomeItem, posicao;
    protected int playerHp;
    protected int monstroHP;
    protected int contador1 = 0, contador2 = 0, contador3 = 0, contador4 = 0, contador5 = 0, contador6 = 0;
    protected JLabel hpPlayerLabel;
    protected JLabel hpMonstroLabel;
    protected JLabel inventoryLabel;
    protected JLabel itemTroca;

    protected boolean botoesAdicionados = false;
    protected boolean botoesAdicionados2 = false;
    protected boolean botoesAdicionados3 = false;


    protected JTextArea dialogoText;

    protected JButton botaoContinuarAtual, escolha1, escolha2;

    public GameExemple() {
        setTitle("Meu jogo");
        setSize(1024, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        exibirTelaInicial();
    }

    //--------------------------------------------------------------------------------------------------------------------------------------
    private void exibirTelaInicial() {
        JPanel telaInicial = new TelaInicial(this);
        setContentPane(telaInicial);
    }

    public void exibirTelaCadastroJogador() {
        CadastroJogador telaCadastro = new CadastroJogador(this);
        setContentPane(telaCadastro);

        revalidate();
        repaint();
    }

    public void exibirPrologo(){
        Prologo telaPrologo = new Prologo(this);
        setContentPane(telaPrologo);

        revalidate();
        repaint();
    }

    public void exibirInicioJogo(){
        InicioJogo inicioJogo = new InicioJogo(this);
        setContentPane(inicioJogo);

        revalidate();
        repaint();
    }

    public void exibirGuia1(){
        Guia1 guia1 = new Guia1(this);
        setContentPane(guia1);

        revalidate();
        repaint();
    }

    public void exibirBatalha1(){
        Batalha1 batalha1 = new Batalha1(this);
        setContentPane(batalha1);

        revalidate();
        repaint();
    }

    public void exibirGuia2(){
        Guia2 guia2 = new Guia2(this);
        setContentPane(guia2);

        revalidate();
        repaint();
    }
    public void exibirBatalha2(){
        Batalha2 batalha2 = new Batalha2(this);
        setContentPane(batalha2);

        revalidate();
        repaint();
    }
    public void exibirGuia3(){
        Guia3 guia3 = new Guia3(this);
        setContentPane(guia3);

        revalidate();
        repaint();
    }


    public void exibirBatalha3(){
        Batalha3 batalha3 = new Batalha3(this);
        setContentPane(batalha3);

        revalidate();
        repaint();
    }
    public void exibirGuia4(){
        Guia4 guia4 = new Guia4(this);
        setContentPane(guia4);

        revalidate();
        repaint();
    }
    public void exibirFim(){
        Fim fim = new Fim(this);
        setContentPane(fim);

        revalidate();
        repaint();

    }









    public void playerStatus(){
        playerHp = 100;
        hpPlayerLabel.setText("HP: " + playerHp);

    }
    public void monstroStatus(){
        monstroHP = 500;
        hpMonstroLabel.setText("Boss HP: " + monstroHP);
    }

    public JButton escolhaBotao(){
        JButton button = new JButton();
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial",Font.BOLD,20));
        //button.setOpaque(false);
        //button.setContentAreaFilled(false);
        //button.setBorderPainted(false);
        return button;

    }

    public void combateItem(JPanel pTemporario, String escolha1, String nomeDoItem){

        switch (posicao){
            case "batalha1":
                switch (escolha1){
                    case "b1e1": luta(pTemporario, ""); break;
                    case "b1e2": luta(pTemporario, nomeDoItem);break;

                }
                break;
            case "loop":
                switch (escolha1){
                    case "l1": luta(pTemporario, nomeDoItem); break;

                }
                break;
        }
    }
    public void combateItem2(JPanel pTemporario, String escolha1, String nomeDoItem){

        switch (posicao){
            case "batalha2":
                switch (escolha1){
                    case "b2e1": luta2(pTemporario,""); break;
                    case "b2e2": luta2(pTemporario, nomeDoItem); break;
                }
                break;
            case "loop2":
                switch (escolha1){
                    case "l2": luta2(pTemporario, nomeDoItem); break;

                }
                break;
        }

    }
    public void combateItem3(JPanel pTemporario, String escolha1, String nomeDoItem){

        switch (posicao){
            case "batalha3":
                switch (escolha1){
                    case "b3e1": luta3(pTemporario, ""); break;
                    case "b3e2": luta3(pTemporario, nomeDoItem);break;

                }
                break;
            case "loop3":
                switch (escolha1){
                    case "l3": luta3(pTemporario, nomeDoItem); break;

                }
                break;
        }

    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    public void luta(JPanel painel, String itemUsado){
        painel.remove(escolha1);
        painel.remove(escolha2);
        painel.revalidate();
        painel.repaint();

        playerAtaque(painel, itemUsado);
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void luta2(JPanel painel, String itemUsado){
        painel.remove(escolha1);
        painel.remove(escolha2);
        painel.revalidate();
        painel.repaint();

        playerAtaque2(painel, itemUsado);
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void luta3(JPanel painel, String itemUsado){
        painel.remove(escolha1);
        painel.remove(escolha2);
        painel.revalidate();
        painel.repaint();

        playerAtaque3(painel, itemUsado);
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    public void playerAtaque(JPanel painel2, String item){
        int playerDano = 0;
        playerDano = new Random().nextInt(300);


        dialogoText = new JTextArea();
        dialogoText.setBounds(150, 50, 800, 200);
        dialogoText.setForeground(Color.ORANGE);
        dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        dialogoText.setEditable(false);
        dialogoText.setLineWrap(true);
        dialogoText.setWrapStyleWord(true);
        dialogoText.setOpaque(false);

        painel2.add(dialogoText);

        if(item.equals("")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");

            }
            else{
                int danoAtual = playerDano;
                GerenciadorDeDialogos dialogoBatalha1 = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano no Wendingo",
                        "..."

                });

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(dialogoBatalha1.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalha1.hasNextDialogo()) {
                                dialogoBatalha1.avancarDialogo();
                                dialogoText.setText(dialogoBatalha1.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque(painel2, "");
                            }
                        }
                    }
                });

            }

        }
        else if(item.equals("Armadilha")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");
            }
            else if(contador1 == 0){
                int ArmaDilha = 300;

                GerenciadorDeDialogos usoArmadilha = new GerenciadorDeDialogos(new String[]{
                        "Você usou o item ARMADILHA e deu " + ArmaDilha + " de dano no Wendingo",
                        "..."

                });
                monstroHP -= ArmaDilha;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(usoArmadilha.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (usoArmadilha.hasNextDialogo()) {
                                usoArmadilha.avancarDialogo();
                                dialogoText.setText(usoArmadilha.getDialogoAtual());
                            } else {
                                contador1++;
                                painel2.remove(dialogoText);
                                monstroAtaque(painel2, "Armadilha");

                            }
                        }
                    }
                });
            }
            else{
                int danoAtual = playerDano;
                GerenciadorDeDialogos dialogoBatalhaArmadilha = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano no Wendingo",
                        "..."

                });
                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(dialogoBatalhaArmadilha.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaArmadilha.hasNextDialogo()) {
                                dialogoBatalhaArmadilha.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaArmadilha.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque(painel2, "Armadilha");

                            }
                        }
                    }
                });
            }

        }
        else if(item.equals("Armadura")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");
            }
            else if(contador2 == 0){
                int danoAtual = playerDano;
                GerenciadorDeDialogos usoArmadura = new GerenciadorDeDialogos(new String[]{
                        "Você usou o item ARMADURA, por isso receberá 0 de dano no início da batalha contra Wendingo\n\n" +
                                "Você deu " + danoAtual + "de dano em Wendingo",
                        "..."
                });

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(usoArmadura.getDialogoAtual());
                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (usoArmadura.hasNextDialogo()) {
                                usoArmadura.avancarDialogo();
                                dialogoText.setText(usoArmadura.getDialogoAtual());
                            } else {
                                contador2++;
                                painel2.remove(dialogoText);
                                monstroAtaque(painel2, "Armadura");

                            }
                        }
                    }
                });

            }
            else {
                int danoAtual = playerDano;
                GerenciadorDeDialogos dialogoBatalhaArmadura = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano no Wendingo",
                        "..."
                });

                dialogoText.setText(dialogoBatalhaArmadura.getDialogoAtual());

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaArmadura.hasNextDialogo()) {
                                dialogoBatalhaArmadura.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaArmadura.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque(painel2, "Armadura");

                            }
                        }
                    }
                });

            }
        }
        else if(item.equals("CoxaDeGalinha")){
            GerenciadorDeDialogos usoCoxa = new GerenciadorDeDialogos(new String[]{
                    "Você usou o item COXA DE GALINHA e algo inusitado aconteceu!",
                    "Wendingo: HMMMMMMM, Meu Deus!!!! Há quanto tempo eu nâo saboreava algo tão delicioso assim!!!",
                    "Isso me lembra de quando eu era pequeno, minha querida mãe preparava uma galinha assada para eu e meus irmãos comermos.",
                    "Como eu era o irmão mais velho, tinha direito à escolher a parte da galinha que eu quisesse, eu sempre escolhia COXA DE GALINHA!",
                    "Oh, Meu Deus, como eu me tornei nesse monstro tão horrendo, há quanto tempo eu não tinha uma memória sobre minha família.",
                    "Tanto tempo se passou, tenho certeza que eles devem estar todos mortos!(Wendingo solta um uivo de dor, e logo após, desaparece para sempre!).",
                    ""+nomeJogador+": Nossa, mas o que foi tudo isso!? Acho melhor eu seguir meu caminho."
            });


            dialogoText.setText(usoCoxa.getDialogoAtual());
            dialogoText.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (usoCoxa.hasNextDialogo()) {
                            usoCoxa.avancarDialogo();
                            dialogoText.setText(usoCoxa.getDialogoAtual());
                        } else {
                            JButton continua = new JButton("Continuar");
                            continua.setBounds(850, 680, 150, 70);
                            continua.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    painel2.remove(dialogoText);
                                    exibirGuia2();
                                }
                            });
                            repaint();//evita botao escondido!!!!
                            painel2.add(continua);

                        }
                    }
                }
            });

        }





        painel2.revalidate();
        painel2.repaint();
        dialogoText.requestFocus();

    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    public void monstroAtaque(JPanel painel,String item){
        int monstroDano = 0;
        monstroDano = new java.util.Random().nextInt(30);

        dialogoText = new JTextArea();
        dialogoText.setBounds(150, 50, 800, 200);
        dialogoText.setForeground(Color.ORANGE);
        dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        dialogoText.setEditable(false);
        dialogoText.setLineWrap(true);
        dialogoText.setWrapStyleWord(true);
        dialogoText.setOpaque(false);

        painel.add(dialogoText);

        if(item.equals("")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Wendingo!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        painel.remove(dialogoText);
                        exibirGuia2();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);


            }else {
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoBatalhaMonstro1 = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano do Wendingo",
                        "..."

                });

                playerHp -= danoAtual;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoBatalhaMonstro1.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaMonstro1.hasNextDialogo()) {
                                dialogoBatalhaMonstro1.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaMonstro1.getDialogoAtual());
                            } else {
                                loop(painel, "");

                            }
                        }
                    }
                });
            }
        }
        else if(item.equals("Armadilha")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Wendingo!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        painel.remove(dialogoText);
                        exibirGuia2();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);

            }
            else{
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoArmadilha = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano do Wendingo",
                        "..."

                });

                playerHp -= danoAtual;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoArmadilha.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoArmadilha.hasNextDialogo()) {
                                dialogoArmadilha.avancarDialogo();
                                dialogoText.setText(dialogoArmadilha.getDialogoAtual());
                            } else {
                                loop(painel, "Armadilha");

                            }
                        }
                    }
                });

            }

        }
        else if(item.equals("Armadura")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Wendingo!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        painel.remove(dialogoText);
                        exibirGuia2();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);
            }
            else if(contador2 == 1){
                GerenciadorDeDialogos efeitoArmadura = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu 0 de dano de Wendingo!",
                        "..."
                });

                dialogoText.setText(efeitoArmadura.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (efeitoArmadura.hasNextDialogo()) {
                                efeitoArmadura.avancarDialogo();
                                dialogoText.setText(efeitoArmadura.getDialogoAtual());
                            } else {
                                contador2++;
                                loop(painel, "Armadura");

                            }
                        }
                    }
                });

            }
            else{
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoArmadura = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano do Wendingo",
                        "..."

                });

                playerHp -= danoAtual;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoArmadura.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoArmadura.hasNextDialogo()) {
                                dialogoArmadura.avancarDialogo();
                                dialogoText.setText(dialogoArmadura.getDialogoAtual());
                            } else {
                                loop(painel, "Armadura");

                            }
                        }
                    }
                });

            }
        }

        painel.revalidate();
        painel.repaint();
        dialogoText.requestFocus();
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void playerAtaque2(JPanel painel2, String item){
        int playerDano = 0;
        playerDano = new Random().nextInt(300);


        dialogoText = new JTextArea();
        dialogoText.setBounds(150, 50, 800, 200);
        dialogoText.setForeground(Color.ORANGE);
        dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        dialogoText.setEditable(false);
        dialogoText.setLineWrap(true);
        dialogoText.setWrapStyleWord(true);
        dialogoText.setOpaque(false);

        painel2.add(dialogoText);

        if(item.equals("")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");

            }
            else{
                int danoAtual = playerDano;
                GerenciadorDeDialogos dialogoBatalha1 = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano em Yuki-Onna",
                        "..."

                });

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(dialogoBatalha1.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalha1.hasNextDialogo()) {
                                dialogoBatalha1.avancarDialogo();
                                dialogoText.setText(dialogoBatalha1.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque2(painel2, "");
                            }
                        }
                    }
                });

            }

        }
        else if(item.equals("Vela cerimonial")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");
            }
            else if(contador3 == 0){
                int dobroDano = playerDano * 2;

                GerenciadorDeDialogos usoVela = new GerenciadorDeDialogos(new String[]{
                        "Você usou o item Vela cerimonial que drobará o seu dano até o final da batalha.\n\n" +
                                "Você deu " + dobroDano + "de dano em Yuki-Onna.",
                        "..."

                });
                monstroHP -= dobroDano;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(usoVela.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (usoVela.hasNextDialogo()) {
                                usoVela.avancarDialogo();
                                dialogoText.setText(usoVela.getDialogoAtual());
                            } else {
                                contador3++;
                                painel2.remove(dialogoText);
                                monstroAtaque2(painel2, "Vela cerimonial");

                            }
                        }
                    }
                });
            }
            else{
                int danoDobro = playerDano * 2;
                GerenciadorDeDialogos dialogoBatalhaVela = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoDobro + " de dano em Yuki-Onna",
                        "..."

                });
                monstroHP -= danoDobro;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(dialogoBatalhaVela.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaVela.hasNextDialogo()) {
                                dialogoBatalhaVela.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaVela.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque2(painel2, "Vela cerimonial");

                            }
                        }
                    }
                });
            }

        }
        else if(item.equals("Talisma")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");
            }
            else if(contador4 == 0){
                int danoAtual = playerDano;
                GerenciadorDeDialogos usoTalisma = new GerenciadorDeDialogos(new String[]{
                        "Você usou o item TALISMÃ, por isso receberá 50% de dano a menos de dano até o final da batalha.\n\n" +
                                "Você deu " + danoAtual + "de dano em Yuki-Onna.",
                        "..."
                });

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(usoTalisma.getDialogoAtual());
                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (usoTalisma.hasNextDialogo()) {
                                usoTalisma.avancarDialogo();
                                dialogoText.setText(usoTalisma.getDialogoAtual());
                            } else {
                                contador4++;
                                painel2.remove(dialogoText);
                                monstroAtaque2(painel2, "Talisma");

                            }
                        }
                    }
                });

            }
            else {
                int danoAtual = playerDano;
                GerenciadorDeDialogos dialogoBatalhaTalisma = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano em Yuki-Onna",
                        "..."
                });

                dialogoText.setText(dialogoBatalhaTalisma.getDialogoAtual());

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaTalisma.hasNextDialogo()) {
                                dialogoBatalhaTalisma.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaTalisma.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque2(painel2, "Talisma");

                            }
                        }
                    }
                });

            }
        }
        else if(item.equals("KitMedico")){
            GerenciadorDeDialogos usoMedico = new GerenciadorDeDialogos(new String[]{
                    "Ao usar o item KIT MÉDICO você repara uma coisa, Yuki-Onna não tira os olhos dele.",
                    ""+nomeJogador+": Por que você olha tanto para isso, você quer?",
                    "Isso... isso... é idêntico a aquele...(Yuki-Onna se recorda de quando foi deixada para trás por seus companheiros.",
                    "Um deles tinha consigo um KIT MÉDICO, igual ao que você possui neste momento, "+
                            "Yuki-Onna pedia esse kit para que pudesse cuidar de suas graves feridas, mas seu companheiro recuso-se em usar o kit médico para tratá-la",
                    "Após isso ela viu seus companheiros indo embora em quanto ela gritava de dor, implorando para que eles voltassem e cuidassem dela.",
                    "Yuki-Onna: Você está realmente oferecendo isto para mim? Porquê?",
                    ""+nomeJogador+": Você mudou o seu jeito totalmente quando viu o meu item, imaginei que fosse algo que lhe interessasse.",
                    "(Yuki-Onna pega o kit médico e começa a chorar baixinho, vai se afastando lentamente e desaparece no meio da floresta escura e fria).",
                    "depois disso, Yuki-Onna nunca mais foi vista.",
                    ""+nomeJogador+": Esse monstros... como podem... ah, deixa pra lá. Vou seguir viagem!"
            });


            dialogoText.setText(usoMedico.getDialogoAtual());
            dialogoText.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (usoMedico.hasNextDialogo()) {
                            usoMedico.avancarDialogo();
                            dialogoText.setText(usoMedico.getDialogoAtual());
                        } else {
                            JButton continua = new JButton("Continuar");
                            continua.setBounds(850, 680, 150, 70);
                            continua.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    painel2.remove(dialogoText);
                                    exibirGuia3();
                                }
                            });
                            repaint();//evita botao escondido!!!!
                            painel2.add(continua);

                        }
                    }
                }
            });
        }



        painel2.revalidate();
        painel2.repaint();
        dialogoText.requestFocus();

    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    public void monstroAtaque2(JPanel painel,String item){
        int monstroDano = 0;
        monstroDano = new java.util.Random().nextInt(30);

        dialogoText = new JTextArea();
        dialogoText.setBounds(150, 50, 800, 50);
        dialogoText.setForeground(Color.ORANGE);
        dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        dialogoText.setEditable(false);
        dialogoText.setLineWrap(true);
        dialogoText.setWrapStyleWord(true);
        dialogoText.setOpaque(false);

        painel.add(dialogoText);

        if(item.equals("")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Yuki-Onna!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("exibirGuia3");
                        painel.remove(dialogoText);
                        exibirGuia3();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);


            }else {
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoBatalhaMonstro2 = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano de Yuki-Onna",
                        "..."

                });

                playerHp -= danoAtual;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoBatalhaMonstro2.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaMonstro2.hasNextDialogo()) {
                                dialogoBatalhaMonstro2.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaMonstro2.getDialogoAtual());
                            } else {
                                loop2(painel, "");

                            }
                        }
                    }
                });
            }
        }
        else if(item.equals("Vela cerimonial")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Yuki-Onna!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        painel.remove(dialogoText);
                        exibirGuia3();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);

            }
            else{
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoVela = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano da Yuki-Onna",
                        "..."

                });

                playerHp -= danoAtual;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoVela.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoVela.hasNextDialogo()) {
                                dialogoVela.avancarDialogo();
                                dialogoText.setText(dialogoVela.getDialogoAtual());
                            } else {
                                loop2(painel, "Vela cerimonial");

                            }
                        }
                    }
                });

            }

        }
        else if(item.equals("Talisma")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Yuki-Onna!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        painel.remove(dialogoText);
                        exibirGuia3();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);
            }
            else{
                int danoDividido = monstroDano/2;
                GerenciadorDeDialogos dialogoArmadura = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoDividido + " de dano de Yuki-Onna!",
                        "..."

                });

                playerHp -= danoDividido;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoArmadura.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoArmadura.hasNextDialogo()) {
                                dialogoArmadura.avancarDialogo();
                                dialogoText.setText(dialogoArmadura.getDialogoAtual());
                            } else {
                                loop2(painel, "Talisma");

                            }
                        }
                    }
                });

            }
        }







        painel.revalidate();
        painel.repaint();
        dialogoText.requestFocus();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    public void playerAtaque3(JPanel painel2, String item){
        int playerDano = 0;
        playerDano = new Random().nextInt(300);


        dialogoText = new JTextArea();
        dialogoText.setBounds(150, 50, 800, 250);

        dialogoText.setForeground(Color.ORANGE);
        dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        dialogoText.setEditable(false);
        dialogoText.setLineWrap(true);
        dialogoText.setWrapStyleWord(true);
        dialogoText.setOpaque(false);

        painel2.add(dialogoText);

        if(item.equals("")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");

            }
            else{
                int danoAtual = playerDano;
                GerenciadorDeDialogos dialogoBatalha3 = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano em Morozko",
                        "..."

                });

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(dialogoBatalha3.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalha3.hasNextDialogo()) {
                                dialogoBatalha3.avancarDialogo();
                                dialogoText.setText(dialogoBatalha3.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque3(painel2, "");
                            }
                        }
                    }
                });

            }

        }
        else if(item.equals("Lampiao")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");
            }
            else if(contador5 == 0){
                int fogo = 50;
                int danoAtual = playerDano;
                int danoEfogo = danoAtual + fogo;
                GerenciadorDeDialogos usoLampiao = new GerenciadorDeDialogos(new String[]{
                        "Você usou o item LAMPIÃO para incendiar o inimigo, fazendo com que ele queime e receba 50 de dano por fogo toda rodada.\n\n" +
                                "Você deu " + danoAtual + " de dano em Worozko e ele queimou, perdendo " + fogo + "  vida também",
                        "..."

                });
                monstroHP -= danoEfogo;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(usoLampiao.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (usoLampiao.hasNextDialogo()) {
                                usoLampiao.avancarDialogo();
                                dialogoText.setText(usoLampiao.getDialogoAtual());
                            } else {
                                contador5++;
                                painel2.remove(dialogoText);
                                monstroAtaque3(painel2, "Lampiao");

                            }
                        }
                    }
                });
            }
            else{
                int fogo = 50;
                int danoAtual = playerDano;
                int danoEfogo = danoAtual + fogo;

                GerenciadorDeDialogos dialogoBatalhaLampiao = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano em Worozko e ele queimou, perdendo " + fogo + " de vida também",
                        "..."

                });
                monstroHP -= danoEfogo;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(dialogoBatalhaLampiao.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaLampiao.hasNextDialogo()) {
                                dialogoBatalhaLampiao.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaLampiao.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque3(painel2, "Lampiao");

                            }
                        }
                    }
                });
            }

        }
        else if(item.equals("Escudo")){
            if (playerHp<1){
                dialogoText.setText("Game Over!");
            }
            else if(contador6 == 0){
                int danoAtual = playerDano;
                GerenciadorDeDialogos usoEscudo = new GerenciadorDeDialogos(new String[]{
                        "Você usou o item ESCUDO, com ele você pode dar um parry em seu inimigo, devolvendo a ele o dano que ele daria em você, sim, esse item é APELAO!\n\n" +
                                "Você deu " + danoAtual + " de dano em Worozko.",
                        "..."
                });

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(usoEscudo.getDialogoAtual());
                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (usoEscudo.hasNextDialogo()) {
                                usoEscudo.avancarDialogo();
                                dialogoText.setText(usoEscudo.getDialogoAtual());
                            } else {
                                contador6++;
                                painel2.remove(dialogoText);
                                monstroAtaque3(painel2, "Escudo");

                            }
                        }
                    }
                });

            }
            else {
                int danoAtual = playerDano;
                GerenciadorDeDialogos dialogoBatalhaEscudo = new GerenciadorDeDialogos(new String[]{
                        "Você deu " + danoAtual + " de dano em Worozko",
                        "..."
                });

                dialogoText.setText(dialogoBatalhaEscudo.getDialogoAtual());

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaEscudo.hasNextDialogo()) {
                                dialogoBatalhaEscudo.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaEscudo.getDialogoAtual());
                            } else {
                                painel2.remove(dialogoText);
                                monstroAtaque3(painel2, "Escudo");

                            }
                        }
                    }
                });

            }
        }
        else if(item.equals("SacoDeDinheiro")){
            GerenciadorDeDialogos usoDinheiro = new GerenciadorDeDialogos(new String[]{
                    "Você usou o item SACO DE DINHEIRO e fez os olhos escuros e sombrios de Morozko brilharem!",
                    "Morozko: ME DÊ! Eu quero esse ouro, passa ele para cá, seu pirralho.",
                    "Você é empurrado e o saco de dinheiro é tirado a força de você.",
                    "Ao se recomper, você grita: VOCÊ VAI PAGAR POR ISSO, SEU MALDITO!" +
                            "Mas não havia ali outro ser além de você",
                    "Morozko desapareceu na velocidade de um raio, levando consigo o saco de dinheiro," +
                            "depois disso, Morozko nunca mais foi visto por aquelas montanhas."
            });


            dialogoText.setText(usoDinheiro.getDialogoAtual());
            dialogoText.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (usoDinheiro.hasNextDialogo()) {
                            usoDinheiro.avancarDialogo();
                            dialogoText.setText(usoDinheiro.getDialogoAtual());
                        } else {
                            JButton continua = new JButton("Continuar");
                            continua.setBounds(850, 680, 150, 70);
                            continua.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    painel2.remove(dialogoText);
                                    exibirGuia4();
                                }
                            });
                            repaint();//evita botao escondido!!!!
                            painel2.add(continua);

                        }
                    }
                }
            });
        }


        painel2.revalidate();
        painel2.repaint();
        dialogoText.requestFocus();

    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    public void monstroAtaque3(JPanel painel,String item){
        int monstroDano = 0;
        monstroDano = new java.util.Random().nextInt(30);

        dialogoText = new JTextArea();
        dialogoText.setBounds(150, 50, 800, 250);
        dialogoText.setForeground(Color.ORANGE);
        dialogoText.setFont(new Font("Arial", Font.BOLD, 20));
        dialogoText.setEditable(false);
        dialogoText.setLineWrap(true);
        dialogoText.setWrapStyleWord(true);
        dialogoText.setOpaque(false);

        painel.add(dialogoText);

        if(item.equals("")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Morozko!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("exibirGuia4");
                        painel.remove(dialogoText);
                        exibirGuia4();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);


            }else {
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoBatalhaMonstro3 = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano de Morozko",
                        "..."

                });

                playerHp -= danoAtual;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoBatalhaMonstro3.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoBatalhaMonstro3.hasNextDialogo()) {
                                dialogoBatalhaMonstro3.avancarDialogo();
                                dialogoText.setText(dialogoBatalhaMonstro3.getDialogoAtual());
                            } else {
                                loop3(painel, "");

                            }
                        }
                    }
                });
            }
        }
        else if(item.equals("Lampiao")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Worozko!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        painel.remove(dialogoText);
                        exibirGuia4();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);

            }
            else{
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoLampiao = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano de Worozko",
                        "..."

                });

                playerHp -= danoAtual;
                hpPlayerLabel.setText("HP: " + playerHp);

                dialogoText.setText(dialogoLampiao.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoLampiao.hasNextDialogo()) {
                                dialogoLampiao.avancarDialogo();
                                dialogoText.setText(dialogoLampiao.getDialogoAtual());
                            } else {
                                loop3(painel, "Lampiao");

                            }
                        }
                    }
                });

            }

        }
        else if(item.equals("Escudo")){
            if(monstroHP<1){
                dialogoText.setText("Você derrotou Worozko!");

                JButton continua = new JButton("Continuar");
                continua.setBounds(850, 680, 150, 70);
                continua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        painel.remove(dialogoText);
                        exibirGuia4();
                    }
                });
                repaint();//evita botao escondido!!!!
                painel.add(continua);
            }
            else{
                int danoAtual = monstroDano;
                GerenciadorDeDialogos dialogoArmadura = new GerenciadorDeDialogos(new String[]{
                        "Você recebeu " + danoAtual + " de dano de Morozko, mas o dano foi refletido nele mesmo por causa do parry.",
                        "..."

                });

                monstroHP -= danoAtual;
                hpMonstroLabel.setText("Boss HP: " + monstroHP);

                dialogoText.setText(dialogoArmadura.getDialogoAtual());

                dialogoText.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (dialogoArmadura.hasNextDialogo()) {
                                dialogoArmadura.avancarDialogo();
                                dialogoText.setText(dialogoArmadura.getDialogoAtual());
                            } else {
                                loop3(painel, "Escudo");

                            }
                        }
                    }
                });

            }
        }







        painel.revalidate();
        painel.repaint();
        dialogoText.requestFocus();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    public void loop (JPanel painelLoop, String itemChose){

        posicao = "loop";

        JButton loopBotao = escolhaBotao();
        loopBotao.setText("Atacar");
        loopBotao.setBounds(425, 500, 150, 60);

        loopBotao.setActionCommand("l1");//para se referir a ação gerada por esse botao especificamente!!!
        loopBotao.setVisible(true);
        loopBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loopBotao.setVisible(false);
                painelLoop.remove(dialogoText);
                String suaEscolha1 = e.getActionCommand();
                combateItem(painelLoop, suaEscolha1, itemChose);
                painelLoop.revalidate();
                painelLoop.repaint();
            }
        });

        painelLoop.add(loopBotao);
        painelLoop.revalidate();
        painelLoop.repaint();
        painelLoop.requestFocus();

    }

    public void loop2(JPanel painelLoop, String itemChose){

        posicao = "loop2";

        JButton loopBotao = escolhaBotao();
        loopBotao.setText("Atacar");
        loopBotao.setBounds(425, 500, 150, 60);

        loopBotao.setActionCommand("l2");//para se referir a ação gerada por esse botao especificamente!!!
        loopBotao.setVisible(true);
        loopBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loopBotao.setVisible(false);
                painelLoop.remove(dialogoText);
                String suaEscolha1 = e.getActionCommand();
                combateItem2(painelLoop, suaEscolha1, itemChose);
                painelLoop.revalidate();
                painelLoop.repaint();
            }
        });

        painelLoop.add(loopBotao);
        painelLoop.revalidate();
        painelLoop.repaint();
        painelLoop.requestFocus();

    }
    public void loop3(JPanel painelLoop, String itemChose){

        posicao = "loop3";

        JButton loopBotao = escolhaBotao();
        loopBotao.setText("Atacar");
        loopBotao.setBounds(425, 500, 150, 60);

        loopBotao.setActionCommand("l3");//para se referir a ação gerada por esse botao especificamente!!!
        loopBotao.setVisible(true);
        loopBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loopBotao.setVisible(false);
                painelLoop.remove(dialogoText);
                String suaEscolha1 = e.getActionCommand();
                combateItem3(painelLoop, suaEscolha1, itemChose);
                painelLoop.revalidate();
                painelLoop.repaint();
            }
        });

        painelLoop.add(loopBotao);
        painelLoop.revalidate();
        painelLoop.repaint();
        painelLoop.requestFocus();

    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameExemple().setVisible(true);
        });
    }
}


