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
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByIdLogIn", query = "SELECT l FROM Login l WHERE l.idLogIn = :idLogIn")
    , @NamedQuery(name = "Login.findByNombre", query = "SELECT l FROM Login l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Login.findByApellidos", query = "SELECT l FROM Login l WHERE l.apellidos = :apellidos")
    , @NamedQuery(name = "Login.findByUsuario", query = "SELECT l FROM Login l WHERE l.usuario = :usuario")
    , @NamedQuery(name = "Login.findByCorreoelectronico", query = "SELECT l FROM Login l WHERE l.correoelectronico = :correoelectronico")
    , @NamedQuery(name = "Login.findByContrasena", query = "SELECT l FROM Login l WHERE l.contrasena = :contrasena")
    , @NamedQuery(name = "Login.findBySexo", query = "SELECT l FROM Login l WHERE l.sexo = :sexo")
    , @NamedQuery(name = "Login.findByFechanacimiento", query = "SELECT l FROM Login l WHERE l.fechanacimiento = :fechanacimiento")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_LogIn")
    private Integer idLogIn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Correo_electronico")
    private String correoelectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sexo")
    private Character sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;

    public Login() {
    }

    public Login(Integer idLogIn) {
        this.idLogIn = idLogIn;
    }

    public Login(Integer idLogIn, String nombre, String apellidos, String usuario, String correoelectronico, String contrasena, Character sexo, Date fechanacimiento) {
        this.idLogIn = idLogIn;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getIdLogIn() {
        return idLogIn;
    }

    public void setIdLogIn(Integer idLogIn) {
        this.idLogIn = idLogIn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogIn != null ? idLogIn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idLogIn == null && other.idLogIn != null) || (this.idLogIn != null && !this.idLogIn.equals(other.idLogIn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Login[ idLogIn=" + idLogIn + " ]";
    }
    
}
