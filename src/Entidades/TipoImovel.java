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
@Table(name = "tipo_imovel")
@NamedQueries({
    @NamedQuery(name = "TipoImovel.findAll", query = "SELECT t FROM TipoImovel t")})
public class TipoImovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_imovel")
    private Integer idImovel;
    @Column(name = "nome_tipo_imovel")
    private String nomeTipoImovel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoImovelIdImovel")
    private List<Imovel> imovelList;

    public TipoImovel() {
    }

    public TipoImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public Integer getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public String getNomeTipoImovel() {
        return nomeTipoImovel;
    }

    public void setNomeTipoImovel(String nomeTipoImovel) {
        this.nomeTipoImovel = nomeTipoImovel;
    }

    public List<Imovel> getImovelList() {
        return imovelList;
    }

    public void setImovelList(List<Imovel> imovelList) {
        this.imovelList = imovelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImovel != null ? idImovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoImovel)) {
            return false;
        }
        TipoImovel other = (TipoImovel) object;
        if ((this.idImovel == null && other.idImovel != null) || (this.idImovel != null && !this.idImovel.equals(other.idImovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoImovel[ idImovel=" + idImovel + " ]";
    }

}
