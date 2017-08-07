/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Penelope Lizardo
 */
@Entity
@Table(name = "tipos_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposPagos.findAll", query = "SELECT t FROM TiposPagos t")
    , @NamedQuery(name = "TiposPagos.findByIdtipospagos", query = "SELECT t FROM TiposPagos t WHERE t.idtipospagos = :idtipospagos")
    , @NamedQuery(name = "TiposPagos.findByDescripcion", query = "SELECT t FROM TiposPagos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TiposPagos.findByEstado", query = "SELECT t FROM TiposPagos t WHERE t.estado = :estado")})
public class TiposPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_tipos_pagos")
    private Integer idtipospagos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;

    public TiposPagos() {
    }

    public TiposPagos(Integer idtipospagos) {
        this.idtipospagos = idtipospagos;
    }

    public TiposPagos(Integer idtipospagos, String descripcion, boolean estado) {
        this.idtipospagos = idtipospagos;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdtipospagos() {
        return idtipospagos;
    }

    public void setIdtipospagos(Integer idtipospagos) {
        this.idtipospagos = idtipospagos;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipospagos != null ? idtipospagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposPagos)) {
            return false;
        }
        TiposPagos other = (TiposPagos) object;
        if ((this.idtipospagos == null && other.idtipospagos != null) || (this.idtipospagos != null && !this.idtipospagos.equals(other.idtipospagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TiposPagos[ idtipospagos=" + idtipospagos + " ]";
    }
    
}
