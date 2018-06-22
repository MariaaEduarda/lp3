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
public class ContratoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "imovel_codigo_imovel")
    private int imovelCodigoImovel;
    @Basic(optional = false)
    @Column(name = "fiador_pessoa_CPF")
    private int fiadorpessoaCPF;
    @Basic(optional = false)
    @Column(name = "cliente_pessoa_CPF")
    private int clientepessoaCPF;
    @Basic(optional = false)
    @Column(name = "funcionario_pessoa_CPF")
    private int funcionariopessoaCPF;

    public ContratoPK() {
    }

    public ContratoPK(int imovelCodigoImovel, int fiadorpessoaCPF, int clientepessoaCPF, int funcionariopessoaCPF) {
        this.imovelCodigoImovel = imovelCodigoImovel;
        this.fiadorpessoaCPF = fiadorpessoaCPF;
        this.clientepessoaCPF = clientepessoaCPF;
        this.funcionariopessoaCPF = funcionariopessoaCPF;
    }

    public int getImovelCodigoImovel() {
        return imovelCodigoImovel;
    }

    public void setImovelCodigoImovel(int imovelCodigoImovel) {
        this.imovelCodigoImovel = imovelCodigoImovel;
    }

    public int getFiadorpessoaCPF() {
        return fiadorpessoaCPF;
    }

    public void setFiadorpessoaCPF(int fiadorpessoaCPF) {
        this.fiadorpessoaCPF = fiadorpessoaCPF;
    }

    public int getClientepessoaCPF() {
        return clientepessoaCPF;
    }

    public void setClientepessoaCPF(int clientepessoaCPF) {
        this.clientepessoaCPF = clientepessoaCPF;
    }

    public int getFuncionariopessoaCPF() {
        return funcionariopessoaCPF;
    }

    public void setFuncionariopessoaCPF(int funcionariopessoaCPF) {
        this.funcionariopessoaCPF = funcionariopessoaCPF;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) imovelCodigoImovel;
        hash += (int) fiadorpessoaCPF;
        hash += (int) clientepessoaCPF;
        hash += (int) funcionariopessoaCPF;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoPK)) {
            return false;
        }
        ContratoPK other = (ContratoPK) object;
        if (this.imovelCodigoImovel != other.imovelCodigoImovel) {
            return false;
        }
        if (this.fiadorpessoaCPF != other.fiadorpessoaCPF) {
            return false;
        }
        if (this.clientepessoaCPF != other.clientepessoaCPF) {
            return false;
        }
        if (this.funcionariopessoaCPF != other.funcionariopessoaCPF) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ContratoPK[ imovelCodigoImovel=" + imovelCodigoImovel + ", fiadorpessoaCPF=" + fiadorpessoaCPF + ", clientepessoaCPF=" + clientepessoaCPF + ", funcionariopessoaCPF=" + funcionariopessoaCPF + " ]";
    }

}
