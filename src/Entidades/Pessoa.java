///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Entidades;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Basic;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
///**
// *
// * @author Maggie
// */
//@Entity
//@Table(name = "pessoa")
//@NamedQueries({
//    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
//public class Pessoa implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "CPF")
//    private Integer cpf;
//    @Column(name = "RG")
//    private String rg;
//    @Column(name = "nome")
//    private String nome;
//    @Column(name = "data_nasc")
//    @Temporal(TemporalType.DATE)
//    private Date dataNasc;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "sexo")
//    private Short sexo;
//    @Column(name = "estado_civil")
//    private String estadoCivil;
//    @Column(name = "endereco")
//    private String endereco;
//    @Column(name = "telefone")
//    private String telefone;
//    @Column(name = "celular")
//    private String celular;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
//    private Cliente cliente;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
//    private Fiador fiador;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
//    private Funcionario funcionario;
//
//    public Pessoa() {
//    }
//
//    public Pessoa(Integer cpf) {
//        this.cpf = cpf;
//    }
//
//    public Integer getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(Integer cpf) {
//        this.cpf = cpf;
//    }
//
//    public String getRg() {
//        return rg;
//    }
//
//    public void setRg(String rg) {
//        this.rg = rg;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public Date getDataNasc() {
//        return dataNasc;
//    }
//
//    public void setDataNasc(Date dataNasc) {
//        this.dataNasc = dataNasc;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Short getSexo() {
//        return sexo;
//    }
//
//    public void setSexo(Short sexo) {
//        this.sexo = sexo;
//    }
//
//    public String getEstadoCivil() {
//        return estadoCivil;
//    }
//
//    public void setEstadoCivil(String estadoCivil) {
//        this.estadoCivil = estadoCivil;
//    }
//
//    public String getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public String getCelular() {
//        return celular;
//    }
//
//    public void setCelular(String celular) {
//        this.celular = celular;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public Fiador getFiador() {
//        return fiador;
//    }
//
//    public void setFiador(Fiador fiador) {
//        this.fiador = fiador;
//    }
//
//    public Funcionario getFuncionario() {
//        return funcionario;
//    }
//
//    public void setFuncionario(Funcionario funcionario) {
//        this.funcionario = funcionario;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (cpf != null ? cpf.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Pessoa)) {
//            return false;
//        }
//        Pessoa other = (Pessoa) object;
//        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Entidades.Pessoa[ cpf=" + cpf + " ]";
//    }
//
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maggie
 */
@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf")
    private Integer cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(name = "email")
    private String email;
    @Column(name = "sexo")
    private Boolean sexo;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;

    public Pessoa() {
    }

    public Pessoa(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pessoa[ cpf=" + cpf + " ]";
    }
    
}
