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
@Table(name = "departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d")
    , @NamedQuery(name = "Departamentos.findByIddepartamentos", query = "SELECT d FROM Departamentos d WHERE d.iddepartamentos = :iddepartamentos")
    , @NamedQuery(name = "Departamentos.findByDescripcion", query = "SELECT d FROM Departamentos d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Departamentos.findByEstado", query = "SELECT d FROM Departamentos d WHERE d.estado = :estado")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_departamentos")
    private Integer iddepartamentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private Collection<ActivosFijos> activosFijosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private Collection<Empleados> empleadosCollection;

    public Departamentos() {
    }

    public Departamentos(Integer iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public Departamentos(Integer iddepartamentos, String descripcion, boolean estado) {
        this.iddepartamentos = iddepartamentos;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIddepartamentos() {
        return iddepartamentos;
    }

    public void setIddepartamentos(Integer iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamentos != null ? iddepartamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.iddepartamentos == null && other.iddepartamentos != null) || (this.iddepartamentos != null && !this.iddepartamentos.equals(other.iddepartamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Departamentos[ iddepartamentos=" + iddepartamentos + " ]";
    }
    
}
