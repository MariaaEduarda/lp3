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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maggie
 */
@Entity
@Table(name = "imovel")
@NamedQueries({
    @NamedQuery(name = "Imovel.findAll", query = "SELECT i FROM Imovel i")})
public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_imovel")
    private Integer codigoImovel;
    @Column(name = "disponibilidade")
    private Short disponibilidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;
    @Column(name = "endereco")
    private String endereco;
    @JoinColumn(name = "tipo_imovel_id_imovel", referencedColumnName = "id_imovel")
    @ManyToOne(optional = false)
    private TipoImovel tipoImovelIdImovel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imovel")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imovel")
    private List<ImovelHasComodoImovel> imovelHasComodoImovelList;

    public Imovel() {
    }

    public Imovel(Integer codigoImovel) {
        this.codigoImovel = codigoImovel;
    }

    public Integer getCodigoImovel() {
        return codigoImovel;
    }

    public void setCodigoImovel(Integer codigoImovel) {
        this.codigoImovel = codigoImovel;
    }

    public Short getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Short disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoImovel getTipoImovelIdImovel() {
        return tipoImovelIdImovel;
    }

    public void setTipoImovelIdImovel(TipoImovel tipoImovelIdImovel) {
        this.tipoImovelIdImovel = tipoImovelIdImovel;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
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
        hash += (codigoImovel != null ? codigoImovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imovel)) {
            return false;
        }
        Imovel other = (Imovel) object;
        if ((this.codigoImovel == null && other.codigoImovel != null) || (this.codigoImovel != null && !this.codigoImovel.equals(other.codigoImovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Imovel[ codigoImovel=" + codigoImovel + " ]";
    }

}
