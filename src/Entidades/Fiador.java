/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Maggie
 */
@Entity
@Table(name = "fiador")
@NamedQueries({
    @NamedQuery(name = "Fiador.findAll", query = "SELECT f FROM Fiador f")})
public class Fiador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa_CPF")
    private Integer pessoaCPF;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "renda_mensal")
    private Double rendaMensal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fiador")
    private List<Contrato> contratoList;
    @JoinColumn(name = "pessoa_CPF", referencedColumnName = "CPF", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;

    public Fiador() {
    }

    public Fiador(Integer pessoaCPF) {
        this.pessoaCPF = pessoaCPF;
    }

    public Integer getPessoaCPF() {
        return pessoaCPF;
    }

    public void setPessoaCPF(Integer pessoaCPF) {
        this.pessoaCPF = pessoaCPF;
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaCPF != null ? pessoaCPF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fiador)) {
            return false;
        }
        Fiador other = (Fiador) object;
        if ((this.pessoaCPF == null && other.pessoaCPF != null) || (this.pessoaCPF != null && !this.pessoaCPF.equals(other.pessoaCPF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Fiador[ pessoaCPF=" + pessoaCPF + " ]";
    }

}
