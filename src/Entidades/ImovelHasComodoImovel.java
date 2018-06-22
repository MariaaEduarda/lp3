/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Maggie
 */
@Entity
@Table(name = "imovel_has_comodo_imovel")
@NamedQueries({
    @NamedQuery(name = "ImovelHasComodoImovel.findAll", query = "SELECT i FROM ImovelHasComodoImovel i")})
public class ImovelHasComodoImovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImovelHasComodoImovelPK imovelHasComodoImovelPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "metragem")
    private Double metragem;
    @JoinColumn(name = "comodo_imovel_idcomodo_imovel", referencedColumnName = "idcomodo_imovel", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComodoImovel comodoImovel;
    @JoinColumn(name = "imovel_codigo_imovel", referencedColumnName = "codigo_imovel", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Imovel imovel;

    public ImovelHasComodoImovel() {
    }

    public ImovelHasComodoImovel(ImovelHasComodoImovelPK imovelHasComodoImovelPK) {
        this.imovelHasComodoImovelPK = imovelHasComodoImovelPK;
    }

    public ImovelHasComodoImovel(int imovelCodigoImovel, int comodoImovelIdcomodoImovel) {
        this.imovelHasComodoImovelPK = new ImovelHasComodoImovelPK(imovelCodigoImovel, comodoImovelIdcomodoImovel);
    }

    public ImovelHasComodoImovelPK getImovelHasComodoImovelPK() {
        return imovelHasComodoImovelPK;
    }

    public void setImovelHasComodoImovelPK(ImovelHasComodoImovelPK imovelHasComodoImovelPK) {
        this.imovelHasComodoImovelPK = imovelHasComodoImovelPK;
    }

    public Double getMetragem() {
        return metragem;
    }

    public void setMetragem(Double metragem) {
        this.metragem = metragem;
    }

    public ComodoImovel getComodoImovel() {
        return comodoImovel;
    }

    public void setComodoImovel(ComodoImovel comodoImovel) {
        this.comodoImovel = comodoImovel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imovelHasComodoImovelPK != null ? imovelHasComodoImovelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImovelHasComodoImovel)) {
            return false;
        }
        ImovelHasComodoImovel other = (ImovelHasComodoImovel) object;
        if ((this.imovelHasComodoImovelPK == null && other.imovelHasComodoImovelPK != null) || (this.imovelHasComodoImovelPK != null && !this.imovelHasComodoImovelPK.equals(other.imovelHasComodoImovelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ImovelHasComodoImovel[ imovelHasComodoImovelPK=" + imovelHasComodoImovelPK + " ]";
    }

}
