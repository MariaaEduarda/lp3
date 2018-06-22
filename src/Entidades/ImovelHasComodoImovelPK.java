/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Maggie
 */
@Embeddable
public class ImovelHasComodoImovelPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "imovel_codigo_imovel")
    private int imovelCodigoImovel;
    @Basic(optional = false)
    @Column(name = "comodo_imovel_idcomodo_imovel")
    private int comodoImovelIdcomodoImovel;

    public ImovelHasComodoImovelPK() {
    }

    public ImovelHasComodoImovelPK(int imovelCodigoImovel, int comodoImovelIdcomodoImovel) {
        this.imovelCodigoImovel = imovelCodigoImovel;
        this.comodoImovelIdcomodoImovel = comodoImovelIdcomodoImovel;
    }

    public int getImovelCodigoImovel() {
        return imovelCodigoImovel;
    }

    public void setImovelCodigoImovel(int imovelCodigoImovel) {
        this.imovelCodigoImovel = imovelCodigoImovel;
    }

    public int getComodoImovelIdcomodoImovel() {
        return comodoImovelIdcomodoImovel;
    }

    public void setComodoImovelIdcomodoImovel(int comodoImovelIdcomodoImovel) {
        this.comodoImovelIdcomodoImovel = comodoImovelIdcomodoImovel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) imovelCodigoImovel;
        hash += (int) comodoImovelIdcomodoImovel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImovelHasComodoImovelPK)) {
            return false;
        }
        ImovelHasComodoImovelPK other = (ImovelHasComodoImovelPK) object;
        if (this.imovelCodigoImovel != other.imovelCodigoImovel) {
            return false;
        }
        if (this.comodoImovelIdcomodoImovel != other.comodoImovelIdcomodoImovel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ImovelHasComodoImovelPK[ imovelCodigoImovel=" + imovelCodigoImovel + ", comodoImovelIdcomodoImovel=" + comodoImovelIdcomodoImovel + " ]";
    }

}
