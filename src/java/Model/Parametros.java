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
@Table(name = "parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")
    , @NamedQuery(name = "Parametros.findByIdparametros", query = "SELECT p FROM Parametros p WHERE p.idparametros = :idparametros")
    , @NamedQuery(name = "Parametros.findByAnoproceso", query = "SELECT p FROM Parametros p WHERE p.anoproceso = :anoproceso")
    , @NamedQuery(name = "Parametros.findByMesproceso", query = "SELECT p FROM Parametros p WHERE p.mesproceso = :mesproceso")
    , @NamedQuery(name = "Parametros.findByDepreciacioncalculada", query = "SELECT p FROM Parametros p WHERE p.depreciacioncalculada = :depreciacioncalculada")
    , @NamedQuery(name = "Parametros.findByRNCempresa", query = "SELECT p FROM Parametros p WHERE p.rNCempresa = :rNCempresa")
    , @NamedQuery(name = "Parametros.findByMetododepreciacion", query = "SELECT p FROM Parametros p WHERE p.metododepreciacion = :metododepreciacion")})
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_parametros")
    private Integer idparametros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Ano_proceso")
    private String anoproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Mes_proceso")
    private String mesproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Depreciacion_calculada")
    private String depreciacioncalculada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RNC_empresa")
    private String rNCempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Metodo_depreciacion")
    private String metododepreciacion;

    public Parametros() {
    }

    public Parametros(Integer idparametros) {
        this.idparametros = idparametros;
    }

    public Parametros(Integer idparametros, String anoproceso, String mesproceso, String depreciacioncalculada, String rNCempresa, String metododepreciacion) {
        this.idparametros = idparametros;
        this.anoproceso = anoproceso;
        this.mesproceso = mesproceso;
        this.depreciacioncalculada = depreciacioncalculada;
        this.rNCempresa = rNCempresa;
        this.metododepreciacion = metododepreciacion;
    }

    public Integer getIdparametros() {
        return idparametros;
    }

    public void setIdparametros(Integer idparametros) {
        this.idparametros = idparametros;
    }

    public String getAnoproceso() {
        return anoproceso;
    }

    public void setAnoproceso(String anoproceso) {
        this.anoproceso = anoproceso;
    }

    public String getMesproceso() {
        return mesproceso;
    }

    public void setMesproceso(String mesproceso) {
        this.mesproceso = mesproceso;
    }

    public String getDepreciacioncalculada() {
        return depreciacioncalculada;
    }

    public void setDepreciacioncalculada(String depreciacioncalculada) {
        this.depreciacioncalculada = depreciacioncalculada;
    }

    public String getRNCempresa() {
        return rNCempresa;
    }

    public void setRNCempresa(String rNCempresa) {
        this.rNCempresa = rNCempresa;
    }

    public String getMetododepreciacion() {
        return metododepreciacion;
    }

    public void setMetododepreciacion(String metododepreciacion) {
        this.metododepreciacion = metododepreciacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparametros != null ? idparametros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.idparametros == null && other.idparametros != null) || (this.idparametros != null && !this.idparametros.equals(other.idparametros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Parametros[ idparametros=" + idparametros + " ]";
    }
    
}
