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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maggie
 */
@Entity
@Table(name = "comodo_imovel")
@NamedQueries({
    @NamedQuery(name = "ComodoImovel.findAll", query = "SELECT c FROM ComodoImovel c")})
public class ComodoImovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcomodo_imovel")
    private Integer idcomodoImovel;
    @Column(name = "nome_comodo")
    private String nomeComodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comodoImovel")
    private List<ImovelHasComodoImovel> imovelHasComodoImovelList;

    public ComodoImovel() {
    }

    public ComodoImovel(Integer idcomodoImovel) {
        this.idcomodoImovel = idcomodoImovel;
    }

    public Integer getIdcomodoImovel() {
        return idcomodoImovel;
    }

    public void setIdcomodoImovel(Integer idcomodoImovel) {
        this.idcomodoImovel = idcomodoImovel;
    }

    public String getNomeComodo() {
        return nomeComodo;
    }

    public void setNomeComodo(String nomeComodo) {
        this.nomeComodo = nomeComodo;
    }

    public List<ImovelHasComodoImovel> getImovelHasComodoImovelList() {
        return imovelHasComodoImovelList;
    }

    public void setImovelHasComodoImovelList(List<ImovelHasComodoImovel> imovelHasComodoImovelList) {
        this.imovelHasComodoImovelList = imovelHasComodoImovelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomodoImovel != null ? idcomodoImovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComodoImovel)) {
            return false;
        }
        ComodoImovel other = (ComodoImovel) object;
        if ((this.idcomodoImovel == null && other.idcomodoImovel != null) || (this.idcomodoImovel != null && !this.idcomodoImovel.equals(other.idcomodoImovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ComodoImovel[ idcomodoImovel=" + idcomodoImovel + " ]";
    }

}
