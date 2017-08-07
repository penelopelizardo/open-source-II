/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Penelope Lizardo
 */
@Entity
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByIdproveedores", query = "SELECT p FROM Proveedores p WHERE p.idproveedores = :idproveedores")
    , @NamedQuery(name = "Proveedores.findByNombre", query = "SELECT p FROM Proveedores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedores.findByCedulaoRNC", query = "SELECT p FROM Proveedores p WHERE p.cedulaoRNC = :cedulaoRNC")
    , @NamedQuery(name = "Proveedores.findByTipopersona", query = "SELECT p FROM Proveedores p WHERE p.tipopersona = :tipopersona")
    , @NamedQuery(name = "Proveedores.findByFecharegistro", query = "SELECT p FROM Proveedores p WHERE p.fecharegistro = :fecharegistro")
    , @NamedQuery(name = "Proveedores.findByEstado", query = "SELECT p FROM Proveedores p WHERE p.estado = :estado")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_proveedores")
    private Integer idproveedores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "Cedula_o_RNC")
    private String cedulaoRNC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Tipo_persona")
    private String tipopersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;

    public Proveedores() {
    }

    public Proveedores(Integer idproveedores) {
        this.idproveedores = idproveedores;
    }

    public Proveedores(Integer idproveedores, String nombre, String cedulaoRNC, String tipopersona, Date fecharegistro, boolean estado) {
        this.idproveedores = idproveedores;
        this.nombre = nombre;
        this.cedulaoRNC = cedulaoRNC;
        this.tipopersona = tipopersona;
        this.fecharegistro = fecharegistro;
        this.estado = estado;
    }

    public Integer getIdproveedores() {
        return idproveedores;
    }

    public void setIdproveedores(Integer idproveedores) {
        this.idproveedores = idproveedores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulaoRNC() {
        return cedulaoRNC;
    }

    public void setCedulaoRNC(String cedulaoRNC) {
        this.cedulaoRNC = cedulaoRNC;
    }

    public String getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproveedores != null ? idproveedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idproveedores == null && other.idproveedores != null) || (this.idproveedores != null && !this.idproveedores.equals(other.idproveedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Proveedores[ idproveedores=" + idproveedores + " ]";
    }
    
}
