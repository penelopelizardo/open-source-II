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
@Table(name = "tipos_activos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposActivos.findAll", query = "SELECT t FROM TiposActivos t")
    , @NamedQuery(name = "TiposActivos.findByIdtiposactivos", query = "SELECT t FROM TiposActivos t WHERE t.idtiposactivos = :idtiposactivos")
    , @NamedQuery(name = "TiposActivos.findByDescripcion", query = "SELECT t FROM TiposActivos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TiposActivos.findByCuentacontablecompra", query = "SELECT t FROM TiposActivos t WHERE t.cuentacontablecompra = :cuentacontablecompra")
    , @NamedQuery(name = "TiposActivos.findByCuentacontabledepreciacion", query = "SELECT t FROM TiposActivos t WHERE t.cuentacontabledepreciacion = :cuentacontabledepreciacion")
    , @NamedQuery(name = "TiposActivos.findByEstado", query = "SELECT t FROM TiposActivos t WHERE t.estado = :estado")})
public class TiposActivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_tipos_activos")
    private Integer idtiposactivos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuenta_contable_compra")
    private int cuentacontablecompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuenta_contable_depreciacion")
    private int cuentacontabledepreciacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoactivo")
    private Collection<ActivosFijos> activosFijosCollection;

    public TiposActivos() {
    }

    public TiposActivos(Integer idtiposactivos) {
        this.idtiposactivos = idtiposactivos;
    }

    public TiposActivos(Integer idtiposactivos, String descripcion, int cuentacontablecompra, int cuentacontabledepreciacion, boolean estado) {
        this.idtiposactivos = idtiposactivos;
        this.descripcion = descripcion;
        this.cuentacontablecompra = cuentacontablecompra;
        this.cuentacontabledepreciacion = cuentacontabledepreciacion;
        this.estado = estado;
    }

    public Integer getIdtiposactivos() {
        return idtiposactivos;
    }

    public void setIdtiposactivos(Integer idtiposactivos) {
        this.idtiposactivos = idtiposactivos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCuentacontablecompra() {
        return cuentacontablecompra;
    }

    public void setCuentacontablecompra(int cuentacontablecompra) {
        this.cuentacontablecompra = cuentacontablecompra;
    }

    public int getCuentacontabledepreciacion() {
        return cuentacontabledepreciacion;
    }

    public void setCuentacontabledepreciacion(int cuentacontabledepreciacion) {
        this.cuentacontabledepreciacion = cuentacontabledepreciacion;
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
        hash += (idtiposactivos != null ? idtiposactivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposActivos)) {
            return false;
        }
        TiposActivos other = (TiposActivos) object;
        if ((this.idtiposactivos == null && other.idtiposactivos != null) || (this.idtiposactivos != null && !this.idtiposactivos.equals(other.idtiposactivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TiposActivos[ idtiposactivos=" + idtiposactivos + " ]";
    }
    
}
