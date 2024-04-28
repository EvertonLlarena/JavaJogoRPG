import java.io.Serializable;

public class GerenciadorDeDialogos implements Serializable{
    private String[] dialogos;
    private int currentDialogIndex;

    public GerenciadorDeDialogos(String[] dialogos){
        this.dialogos = dialogos;
        this.currentDialogIndex = 0;
    }

    public String getDialogoAtual() {
        return dialogos[currentDialogIndex];
    }

    public void avancarDialogo() {
        if (currentDialogIndex < dialogos.length){
            currentDialogIndex++;
        }
    }

    public boolean hasNextDialogo() {
        return currentDialogIndex + 1 < dialogos.length;
    }
}
