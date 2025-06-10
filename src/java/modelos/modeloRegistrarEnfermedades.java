package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import sqlgogo.conexionesActivasXd;

public class modeloRegistrarEnfermedades {
    
    private conexionesActivasXd objConexion;
    public modeloRegistrarEnfermedades() throws SQLException {
    }

    public boolean guardarInfo(String tipoEnfermedad, String sintomas, String fecha) throws SQLException {
        ArrayList<String> datitosxd = new ArrayList<>();
        datitosxd.add(tipoEnfermedad);
        datitosxd.add(sintomas);
        datitosxd.add(fecha);
        
        objConexion = new conexionesActivasXd();
        
        boolean datito = objConexion.guardarDatosEnfermedades(datitosxd);
        return datito;
    }
}