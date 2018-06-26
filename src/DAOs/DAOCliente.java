//package DAOs;
//
//
//import Entidades.Cliente;
//import java.util.ArrayList;
//import java.util.List;
//public class DAOCliente extends DAOGenerico<Cliente> {
//public DAOCliente() {
//        super(Cliente.class);
//    }
//public int autoDatacadastroCliente() {
//Integer a = (Integer) em.createQuery("SELECT MAX(e.datacadastroCliente) FROM Cliente e ").getSingleResult();
//if (a != null) {
//            return a + 1;
//        } else {
//            return 1;
//        }
//    }
//public List<Cliente> listInOrderClienteCFP() {
// return em.createQuery("SELECT e FROM Cliente e ORDER BY e.ClienteCFPCliente").getResultList();
//    }
//public List<Cliente> listInOrderDatacadastro() {
//return em.createQuery("SELECT e FROM Cliente e ORDER BY e.datacadastroCliente").getResultList();
//    }
//public List<String> listInOrderNomeStrings(String qualOrdem) {
//List<Cliente> lf;
//if (qualOrdem.equals("datacadastro")) {
//lf = listInOrderDatacadastro();
//} else {
//lf = listInOrderClienteCFP();}
//List<String> ls = new ArrayList<>();
//for (int i = 0; i < lf.size(); i++) {
//ls.add(lf.get(i).getDataCadastro()+ "-" + lf.get(i).getPessoaCPF());}
//return ls;}}
package DAOs;

import static DAOs.DAOGenerico.em;
import Entidades.Cliente;
import Entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends DAOGenerico<Cliente> {

private List<Cliente> lista = new ArrayList<>();    public DAOCliente(){
        super(Cliente.class);
    }

    public int autoPessoaCPF() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.pessoaCPF) FROM Cliente e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cliente> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.pessoaCPF) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Cliente> listById(int id) {
        return em.createQuery("SELECT e FROM Cliente + e WHERE e.dataCadastro= :id").setParameter("id", id).getResultList();
    }

    public List<Cliente> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.dataCadastro").getResultList();
    }

    public List<Cliente> listInOrderId() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.pessoaCPF").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cliente> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getPessoaCPF() + "-" + lf.get(i).getDataCadastro());
        }
        return ls;
    }


public static void main(String[] args) {
        DAOCliente daoCliente = new DAOCliente();
        List<Cliente> listaCliente = daoCliente.list();
        for (Cliente cliente : listaCliente) {
            System.out.println(cliente.getPessoaCPF()+"-"+cliente.getDataCadastro());
        }
    }}