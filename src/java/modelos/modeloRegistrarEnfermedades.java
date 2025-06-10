package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import sqlgogo.conexionesActivasXd;

public class modeloRegistrarEnfermedades {
    
    private conexionesActivasXd objConexion;
    public modeloRegistrarEnfermedades() throws SQLException {
        
    }

    public boolean guardarInfo(String tipoContenedor, String contenido, String humedad) throws SQLException {
        ArrayList<String> datitosxd = new ArrayList<>();
        datitosxd.add(tipoContenedor);
        datitosxd.add(contenido);
        datitosxd.add(humedad);
        objConexion = new conexionesActivasXd();
        
        boolean datito = objConexion.guardarDatos(datitosxd);
        return datito;
    }
}
