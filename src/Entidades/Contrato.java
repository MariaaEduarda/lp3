/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "contrato")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContratoPK contratoPK;
    @Column(name = "data_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFechamento;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @JoinColumn(name = "cliente_pessoa_CPF", referencedColumnName = "pessoa_CPF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "fiador_pessoa_CPF", referencedColumnName = "pessoa_CPF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fiador fiador;
    @JoinColumn(name = "funcionario_pessoa_CPF", referencedColumnName = "pessoa_CPF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "imovel_codigo_imovel", referencedColumnName = "codigo_imovel", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Imovel imovel;

    public Contrato() {
    }

    public Contrato(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Contrato(int imovelCodigoImovel, int fiadorpessoaCPF, int clientepessoaCPF, int funcionariopessoaCPF) {
        this.contratoPK = new ContratoPK(imovelCodigoImovel, fiadorpessoaCPF, clientepessoaCPF, funcionariopessoaCPF);
    }

    public ContratoPK getContratoPK() {
        return contratoPK;
    }

    public void setContratoPK(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fiador getFiador() {
        return fiador;
    }

    public void setFiador(Fiador fiador) {
        this.fiador = fiador;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        hash += (contratoPK != null ? contratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.contratoPK == null && other.contratoPK != null) || (this.contratoPK != null && !this.contratoPK.equals(other.contratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Contrato[ contratoPK=" + contratoPK + " ]";
    }

}
