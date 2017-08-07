/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Penelope Lizardo
 */
@Entity
@Table(name = "calculo_depreciacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalculoDepreciacion.findAll", query = "SELECT c FROM CalculoDepreciacion c")
    , @NamedQuery(name = "CalculoDepreciacion.findByIdcalculodepreciacion", query = "SELECT c FROM CalculoDepreciacion c WHERE c.idcalculodepreciacion = :idcalculodepreciacion")
    , @NamedQuery(name = "CalculoDepreciacion.findByAnoproceso", query = "SELECT c FROM CalculoDepreciacion c WHERE c.anoproceso = :anoproceso")
    , @NamedQuery(name = "CalculoDepreciacion.findByMesproceso", query = "SELECT c FROM CalculoDepreciacion c WHERE c.mesproceso = :mesproceso")
    , @NamedQuery(name = "CalculoDepreciacion.findByFechaproceso", query = "SELECT c FROM CalculoDepreciacion c WHERE c.fechaproceso = :fechaproceso")
    , @NamedQuery(name = "CalculoDepreciacion.findByMontodepreciado", query = "SELECT c FROM CalculoDepreciacion c WHERE c.montodepreciado = :montodepreciado")
    , @NamedQuery(name = "CalculoDepreciacion.findByDepreciacionacumulada", query = "SELECT c FROM CalculoDepreciacion c WHERE c.depreciacionacumulada = :depreciacionacumulada")
    , @NamedQuery(name = "CalculoDepreciacion.findByCuentacompra", query = "SELECT c FROM CalculoDepreciacion c WHERE c.cuentacompra = :cuentacompra")
    , @NamedQuery(name = "CalculoDepreciacion.findByCuentadepreciacion", query = "SELECT c FROM CalculoDepreciacion c WHERE c.cuentadepreciacion = :cuentadepreciacion")})
public class CalculoDepreciacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_calculo_depreciacion")
    private Integer idcalculodepreciacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ano_proceso")
    private int anoproceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mes_proceso")
    private int mesproceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_proceso")
    @Temporal(TemporalType.DATE)
    private Date fechaproceso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Monto_depreciado")
    private BigDecimal montodepreciado;
    @Column(name = "Depreciacion_acumulada")
    private BigDecimal depreciacionacumulada;
    @Column(name = "Cuenta_compra")
    private Integer cuentacompra;
    @Column(name = "Cuenta_depreciacion")
    private Integer cuentadepreciacion;
    @JoinColumn(name = "Activo_fijo", referencedColumnName = "Id_activos_fijos")
    @ManyToOne(optional = false)
    private ActivosFijos activofijo;

    public CalculoDepreciacion() {
    }

    public CalculoDepreciacion(Integer idcalculodepreciacion) {
        this.idcalculodepreciacion = idcalculodepreciacion;
    }

    public CalculoDepreciacion(Integer idcalculodepreciacion, int anoproceso, int mesproceso, Date fechaproceso) {
        this.idcalculodepreciacion = idcalculodepreciacion;
        this.anoproceso = anoproceso;
        this.mesproceso = mesproceso;
        this.fechaproceso = fechaproceso;
    }

    public Integer getIdcalculodepreciacion() {
        return idcalculodepreciacion;
    }

    public void setIdcalculodepreciacion(Integer idcalculodepreciacion) {
        this.idcalculodepreciacion = idcalculodepreciacion;
    }

    public int getAnoproceso() {
        return anoproceso;
    }

    public void setAnoproceso(int anoproceso) {
        this.anoproceso = anoproceso;
    }

    public int getMesproceso() {
        return mesproceso;
    }

    public void setMesproceso(int mesproceso) {
        this.mesproceso = mesproceso;
    }

    public Date getFechaproceso() {
        return fechaproceso;
    }

    public void setFechaproceso(Date fechaproceso) {
        this.fechaproceso = fechaproceso;
    }

    public BigDecimal getMontodepreciado() {
        return montodepreciado;
    }

    public void setMontodepreciado(BigDecimal montodepreciado) {
        this.montodepreciado = montodepreciado;
    }

    public BigDecimal getDepreciacionacumulada() {
        return depreciacionacumulada;
    }

    public void setDepreciacionacumulada(BigDecimal depreciacionacumulada) {
        this.depreciacionacumulada = depreciacionacumulada;
    }

    public Integer getCuentacompra() {
        return cuentacompra;
    }

    public void setCuentacompra(Integer cuentacompra) {
        this.cuentacompra = cuentacompra;
    }

    public Integer getCuentadepreciacion() {
        return cuentadepreciacion;
    }

    public void setCuentadepreciacion(Integer cuentadepreciacion) {
        this.cuentadepreciacion = cuentadepreciacion;
    }

    public ActivosFijos getActivofijo() {
        return activofijo;
    }

    public void setActivofijo(ActivosFijos activofijo) {
        this.activofijo = activofijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalculodepreciacion != null ? idcalculodepreciacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalculoDepreciacion)) {
            return false;
        }
        CalculoDepreciacion other = (CalculoDepreciacion) object;
        if ((this.idcalculodepreciacion == null && other.idcalculodepreciacion != null) || (this.idcalculodepreciacion != null && !this.idcalculodepreciacion.equals(other.idcalculodepreciacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.CalculoDepreciacion[ idcalculodepreciacion=" + idcalculodepreciacion + " ]";
    }
    
}
