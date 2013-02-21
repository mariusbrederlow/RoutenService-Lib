/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Knoten;
import java.util.List;

/**
 *
 * @author mariusbrederlow
 */
public interface IRoutenService {
    
    public List getSchnellsterWeg(String standort, String zielort);
    public void setStandort(String ort);
    public void setZielort(String ziel);
    public List<Knoten> getKnotenListe();
    
}
