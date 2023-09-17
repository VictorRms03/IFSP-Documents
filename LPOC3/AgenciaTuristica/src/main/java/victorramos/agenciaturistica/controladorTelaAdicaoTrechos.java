package victorramos.agenciaturistica;

import java.io.IOException;
import javafx.fxml.FXML;

public class controladorTelaAdicaoTrechos {

    @FXML
    private void irParaTelaApe() throws IOException {
        App.setRoot("telaApe");
    }
    @FXML
    private void irParaTelaAviao() throws IOException {
        App.setRoot("telaAviao");
    }
    @FXML
    private void irParaTelaBarco() throws IOException {
        App.setRoot("telaBarco");
    }
    @FXML
    private void irParaTelaCarro() throws IOException {
        App.setRoot("telaCarro");
    }
    @FXML
    private void irParaTelaOnibus() throws IOException {
        App.setRoot("telaOnibus");
    }
    @FXML
    private void irParaTelaTrem() throws IOException {
        App.setRoot("telaTrem");
    }
}