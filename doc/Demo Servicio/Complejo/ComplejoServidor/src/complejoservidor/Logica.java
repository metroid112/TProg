/**
 * 
 */
package complejoservidor;

/**
 * @author efviodo
 *
 */

import complejoservidor.types.DataMaestro;
import complejoservidor.types.DataPersona;

public class Logica {

    public String obtenerApellido(DataPersona dp){
        return dp.getApellido();
    }

    public DataMaestro obtenerConvocados(String apellido){
        DataPersona dp1 = new DataPersona("Fernando", "Muslera", "muslera.jpg");
        DataPersona dp2 = new DataPersona("Martin", "Silva", "martin_silva.jpg");
        DataPersona dp3 = new DataPersona("Martin", "Campaña", "martin_campana.jpg");
        DataPersona dp4 = new DataPersona("Diego", "Godin", "godin.jpg");
        DataPersona dp5 = new DataPersona("Jose Maria", "Gimenez", "josema.jpg");
        DataPersona dp6 = new DataPersona("Sebastian", "Coates", "coates.jpg");
        DataPersona dp7 = new DataPersona("Gaston", "Silva", "gaston_silva.jpg");
        DataPersona dp8 = new DataPersona("Federico", "Ricca", "federico_ricca.jpg");
        DataPersona dp9 = new DataPersona("Maximiliano", "Pereira", "maxi_pereira.jpg");
        DataPersona dp10 = new DataPersona("Alvaro", "Pereira", "alvaro_pereira.jpg");
        DataPersona dp11 = new DataPersona("Matias", "Vecino", "maxi_pereira.jpg");
        DataPersona dp12 = new DataPersona("Egidio", "Arevalo Rios", "cacha.jpg");
        
        DataPersona dp13 = new DataPersona("Cristian", "Rodriguez", "cebolla.jpg");
        DataPersona dp14 = new DataPersona("Matias", "Corujo", "corujo.jpg");
        DataPersona dp15 = new DataPersona("Alvaro", "Gonzalez", "tata.jpg");
        DataPersona dp16 = new DataPersona("Diego", "Laxalt", "laxalt.jpg");
        DataPersona dp17 = new DataPersona("Carlos", "Sanchez", "carlos_sanchez.jpg");
        DataPersona dp18 = new DataPersona("Giorgian", "De Arrascaeta", "giorgian.jpg");
        DataPersona dp19 = new DataPersona("Nicolas", "Lodeiro", "nico.jpg");
        DataPersona dp20 = new DataPersona("Gaston", "Ramirez", "gaston_ramirez.jpg");
        DataPersona dp21 = new DataPersona("Edinson", "Cavani", "edi.jpg");
        DataPersona dp22 = new DataPersona("Abel", "Hernandez", "joya.jpg");
        DataPersona dp23 = new DataPersona("Diego", "Rolan", "rolan.jpg");
        DataPersona dp24 = new DataPersona("Cristhian", "Stuani", "stuani.jpg");
        DataPersona dp25 = new DataPersona("Luis", "Suraez", "luis.jpg");
        DataPersona dp26 = new DataPersona("Oscar", "Tabares", "master.jpg");
        
        
        DataMaestro dm = new DataMaestro("Óscar Washington", apellido);
        dm.addConvocado(dp1);
        dm.addConvocado(dp2);
        dm.addConvocado(dp3);
        dm.addConvocado(dp4);
        dm.addConvocado(dp5);
        dm.addConvocado(dp6);
        dm.addConvocado(dp7);
        dm.addConvocado(dp8);
        dm.addConvocado(dp9);
        dm.addConvocado(dp10);
        dm.addConvocado(dp11);
        dm.addConvocado(dp12);
        dm.addConvocado(dp13);
        dm.addConvocado(dp14);
        dm.addConvocado(dp15);
        dm.addConvocado(dp16);
        dm.addConvocado(dp17);
        dm.addConvocado(dp18);
        dm.addConvocado(dp19);
        dm.addConvocado(dp20);
        dm.addConvocado(dp21);
        dm.addConvocado(dp22);
        dm.addConvocado(dp23);
        dm.addConvocado(dp24);
        dm.addConvocado(dp25);
        dm.addConvocado(dp26);
        
        return dm;
    }
}