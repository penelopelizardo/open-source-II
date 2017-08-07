/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Penelope Lizardo
 */
@Entity
@Table(name = "ubicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicaciones.findAll", query = "SELECT u FROM Ubicaciones u")
    , @NamedQuery(name = "Ubicaciones.findByIdubicaciones", query = "SELECT u FROM Ubicaciones u WHERE u.idubicaciones = :idubicaciones")
    , @NamedQuery(name = "Ubicaciones.findByDescripcion", query = "SELECT u FROM Ubicaciones u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "Ubicaciones.findByDireccion", query = "SELECT u FROM Ubicaciones u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Ubicaciones.findByEdificio", query = "SELECT u FROM Ubicaciones u WHERE u.edificio = :edificio")
    , @NamedQuery(name = "Ubicaciones.findByEstado", query = "SELECT u FROM Ubicaciones u WHERE u.estado = :estado")})
public class Ubicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_ubicaciones")
    private Integer idubicaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Edificio")
    private String edificio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacion")
    private Collection<ActivosFijos> activosFijosCollection;

    public Ubicaciones() {
    }

    public Ubicaciones(Integer idubicaciones) {
        this.idubicaciones = idubicaciones;
    }

    public Ubicaciones(Integer idubicaciones, String descripcion, String direccion, String edificio, boolean estado) {
        this.idubicaciones = idubicaciones;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.edificio = edificio;
        this.estado = estado;
    }

    public Integer getIdubicaciones() {
        return idubicaciones;
    }

    public void setIdubicaciones(Integer idubicaciones) {
        this.idubicaciones = idubicaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ActivosFijos> getActivosFijosCollection() {
        return activosFijosCollection;
    }

    public void setActivosFijosCollection(Collection<ActivosFijos> activosFijosCollection) {
        this.activosFijosCollection = activosFijosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idubicaciones != null ? idubicaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicaciones)) {
            return false;
        }
        Ubicaciones other = (Ubicaciones) object;
        if ((this.idubicaciones == null && other.idubicaciones != null) || (this.idubicaciones != null && !this.idubicaciones.equals(other.idubicaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ubicaciones[ idubicaciones=" + idubicaciones + " ]";
    }
    
}
