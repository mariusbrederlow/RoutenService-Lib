/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author peters
 */
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariusbrederlow
 */
@Entity
@Table(name = "Kante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kante.findAll", query = "SELECT k FROM Kante k"),
    @NamedQuery(name = "Kante.findById", query = "SELECT k FROM Kante k WHERE k.id = :id"),
    @NamedQuery(name = "Kante.findByIdmitZiel", query = "SELECT k FROM Kante k WHERE k.knotenid = :k and k.zielknotenid = :ziel"),
    @NamedQuery(name = "Kante.findByLaenge", query = "SELECT k FROM Kante k WHERE k.laenge = :laenge"),
    @NamedQuery(name = "Kante.findByMinProKM", query = "SELECT k FROM Kante k WHERE k.minProKM = :minProKM"),
    @NamedQuery(name = "Kante.findByGewicht", query = "SELECT k FROM Kante k WHERE k.gewicht = :gewicht"),
    @NamedQuery(name = "Kante.findByName", query = "SELECT k FROM Kante k WHERE k.name = :name"),
    @NamedQuery(name = "Kante.findByZielknotenid", query = "SELECT k FROM Kante k WHERE k.zielknotenid = :zielknotenid")})
public class Kante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Laenge")
    private Integer laenge;
    @Column(name = "MinProKM")
    private Integer minProKM;
    @Column(name = "Gewicht")
    private Integer gewicht;
    @Column(name = "Name")
    private String name;
    @Column(name = "Zielknoten_id")
    private int zielknotenid;
    @JoinColumn(name = "Knoten_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Knoten knotenid;

    
    
    @Transient
    private Knoten zielknoten;
//    private Knoten zielknoten = (Knoten) em.createNamedQuery("Knoten.findById").setParameter("id", zielknotenid).getSingleResult();
    
    
   
    
    public Kante() {
//        zielknoten = (Knoten)em.createNamedQuery("Knoten.findById").setParameter("id", zielknotenid).getSingleResult();
    }

    public Kante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLaenge() {
        return laenge;
    }

    public void setLaenge(Integer laenge) {
        this.laenge = laenge;
    }

    public Integer getMinProKM() {
        return minProKM;
    }

    public void setMinProKM(Integer minProKM) {
        this.minProKM = minProKM;
    }

    public Integer getGewicht() {
        return gewicht;
    }

    public void setGewicht(Integer gewicht) {
        this.gewicht = gewicht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZielknotenid() {
        return zielknotenid;
    }

    public void setZielknotenid(Integer zielknotenid) {
        this.zielknotenid = zielknotenid;
    }

    public Knoten getKnotenid() {
        return knotenid;
    }

    public void setKnotenid(Knoten knotenid) {
        this.knotenid = knotenid;
    }

    public Knoten getZielknoten() {
        return zielknoten;
    }

    public void setZielknoten(Knoten zielknoten) {
        this.zielknoten = zielknoten;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kante)) {
            return false;
        }
        Kante other = (Kante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "neu_mygraph.Kante[ id=" + id + " ]";
    }
    
}

