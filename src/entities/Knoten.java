/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author mariusbrederlow
 */
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariusbrederlow
 */
@Entity
@Table(name = "Knoten")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Knoten.findAll", query = "SELECT k FROM Knoten k"),
    @NamedQuery(name = "Knoten.findById", query = "SELECT k FROM Knoten k WHERE k.id = :id"),
    @NamedQuery(name = "Knoten.findByName", query = "SELECT k FROM Knoten k WHERE k.name = :name")})
public class Knoten implements Serializable, Comparable<Knoten> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "knotenid")
    private Collection<Kante> kanten;
    
    
    @Transient
    private int minDistanz = Integer.MAX_VALUE;
    @Transient
    private Knoten vorgaenger;

    
    public Knoten() {
    }

    public Knoten(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinDistanz() {
        return minDistanz;
    }

    public void setMinDistanz(int minDistanz) {
        this.minDistanz = minDistanz;
    }

    public Knoten getVorgaenger() {
        return vorgaenger;
    }

    public void setVorgaenger(Knoten vorgaenger) {
        this.vorgaenger = vorgaenger;
    }
    
    

    @XmlTransient
    public Collection<Kante> getKanten() {
        return kanten;
    }

    public void setKantn(Collection<Kante> kanten) {
        this.kanten = kanten;
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
        if (!(object instanceof Knoten)) {
            return false;
        }
        Knoten other = (Knoten) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public int compareTo(Knoten k){
        return Integer.compare(minDistanz, k.minDistanz);
        
    }
}