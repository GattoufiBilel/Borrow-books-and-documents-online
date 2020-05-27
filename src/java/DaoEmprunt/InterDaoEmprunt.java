
package DaoEmprunt;

import Beans.Emprunt;
import java.util.ArrayList;

public interface InterDaoEmprunt<Object> {
    public Boolean OperationEmprunt(Emprunt o);
    public ArrayList<Emprunt> getAll();
    public void CloseConnexion();
}
