/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Penelope Lizardo
 */
@Entity
@Table(name = "activos_fijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivosFijos.findAll", query = "SELECT a FROM ActivosFijos a")
    , @NamedQuery(name = "ActivosFijos.findByIdactivosfijos", query = "SELECT a FROM ActivosFijos a WHERE a.idactivosfijos = :idactivosfijos")
    , @NamedQuery(name = "ActivosFijos.findByDescripcion", query = "SELECT a FROM ActivosFijos a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "ActivosFijos.findByFecharegistro", query = "SELECT a FROM ActivosFijos a WHERE a.fecharegistro = :fecharegistro")
    , @NamedQuery(name = "ActivosFijos.findByValorcompra", query = "SELECT a FROM ActivosFijos a WHERE a.valorcompra = :valorcompra")
    , @NamedQuery(name = "ActivosFijos.findByDepreciacionacumulada", query = "SELECT a FROM ActivosFijos a WHERE a.depreciacionacumulada = :depreciacionacumulada")})
public class ActivosFijos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_activos_fijos")
    private Integer idactivosfijos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor_compra")
    private BigDecimal valorcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Depreciacion_acumulada")
    private BigDecimal depreciacionacumulada;
    @JoinColumn(name = "Departamento", referencedColumnName = "Id_departamentos")
    @ManyToOne(optional = false)
    private Departamentos departamento;
    @JoinColumn(name = "Ubicacion", referencedColumnName = "Id_ubicaciones")
    @ManyToOne(optional = false)
    private Ubicaciones ubicacion;
    @JoinColumn(name = "Tipo_activo", referencedColumnName = "Id_tipos_activos")
    @ManyToOne(optional = false)
    private TiposActivos tipoactivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activofijo")
    private Collection<CalculoDepreciacion> calculoDepreciacionCollection;

    public ActivosFijos() {
    }

    public ActivosFijos(Integer idactivosfijos) {
        this.idactivosfijos = idactivosfijos;
    }

    public ActivosFijos(Integer idactivosfijos, String descripcion, Date fecharegistro, BigDecimal depreciacionacumulada) {
        this.idactivosfijos = idactivosfijos;
        this.descripcion = descripcion;
        this.fecharegistro = fecharegistro;
        this.depreciacionacumulada = depreciacionacumulada;
    }

    public Integer getIdactivosfijos() {
        return idactivosfijos;
    }

    public void setIdactivosfijos(Integer idactivosfijos) {
        this.idactivosfijos = idactivosfijos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigDecimal getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(BigDecimal valorcompra) {
        this.valorcompra = valorcompra;
    }

    public BigDecimal getDepreciacionacumulada() {
        return depreciacionacumulada;
    }

    public void setDepreciacionacumulada(BigDecimal depreciacionacumulada) {
        this.depreciacionacumulada = depreciacionacumulada;
    }

    public Departamentos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
    }

    public Ubicaciones getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicaciones ubicacion) {
        this.ubicacion = ubicacion;
    }

    public TiposActivos getTipoactivo() {
        return tipoactivo;
    }

    public void setTipoactivo(TiposActivos tipoactivo) {
        this.tipoactivo = tipoactivo;
    }

    @XmlTransient
    public Collection<CalculoDepreciacion> getCalculoDepreciacionCollection() {
        return calculoDepreciacionCollection;
    }

    public void setCalculoDepreciacionCollection(Collection<CalculoDepreciacion> calculoDepreciacionCollection) {
        this.calculoDepreciacionCollection = calculoDepreciacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivosfijos != null ? idactivosfijos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivosFijos)) {
            return false;
        }
        ActivosFijos other = (ActivosFijos) object;
        if ((this.idactivosfijos == null && other.idactivosfijos != null) || (this.idactivosfijos != null && !this.idactivosfijos.equals(other.idactivosfijos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ActivosFijos[ idactivosfijos=" + idactivosfijos + " ]";
    }
    
}
