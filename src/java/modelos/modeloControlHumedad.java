package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import sqlgogo.conexionesActivasXd;

public class modeloControlHumedad {

    private conexionesActivasXd objConexion;

    public modeloControlHumedad() throws SQLException {
        objConexion = new conexionesActivasXd(); // Inicializa la conexión en el constructor
    }

    public boolean guardarInfo(String humedad, String fecha, String metodo) throws SQLException {
        ArrayList<String> datitosxd = new ArrayList<>();
        datitosxd.add(humedad);
        datitosxd.add(fecha);
        datitosxd.add(metodo); 

        boolean datito = objConexion.guardarDatosHumedad(datitosxd);
        return datito;
    }
}
