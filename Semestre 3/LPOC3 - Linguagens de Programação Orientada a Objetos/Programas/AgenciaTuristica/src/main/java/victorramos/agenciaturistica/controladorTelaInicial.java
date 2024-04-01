package victorramos.agenciaturistica;

import java.io.IOException;
import javafx.fxml.FXML;

public class controladorTelaInicial {

    @FXML
    private void irParaTelaAdicaoTrechos() throws IOException {
        App.setRoot("telaAdicaoTrechos");
    }
}
