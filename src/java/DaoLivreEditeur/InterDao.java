package DaoLivreEditeur;

import java.util.ArrayList;

public interface InterDao<Object> 
{
    public boolean ajouter(Object o);
    public boolean editer(Object o , int id );
    public boolean supprimer(int id);
    public Object getObject(String str);
    //public Object getObject(int id);
    public ArrayList<Object> getAll();
    public void CloseConnexion();
}
