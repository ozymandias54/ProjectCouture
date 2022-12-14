
package dao;

import java.sql.Connection;
import java.util.List;


public abstract class DAO<T> {
    public Connection connect= Connectdb.getInstance();
  public abstract T recherche(int id) ;
  public abstract void inserer(T obj);
  public abstract void modifier(T obj,int id);
  public abstract void supprimer(int id);
  public abstract List<T> liste();
}
