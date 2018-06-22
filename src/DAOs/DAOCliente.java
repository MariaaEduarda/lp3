package DAOs;


import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
public class DAOCliente extends DAOGenerico<Cliente> {
public DAOCliente() {
        super(Cliente.class);
    }
public int autoDatacadastroCliente() {
Integer a = (Integer) em.createQuery("SELECT MAX(e.datacadastroCliente) FROM Cliente e ").getSingleResult();
if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }
public List<Cliente> listInOrderClienteCFP() {
 return em.createQuery("SELECT e FROM Cliente e ORDER BY e.ClienteCFPCliente").getResultList();
    }
public List<Cliente> listInOrderDatacadastro() {
return em.createQuery("SELECT e FROM Cliente e ORDER BY e.datacadastroCliente").getResultList();
    }
public List<String> listInOrderNomeStrings(String qualOrdem) {
List<Cliente> lf;
if (qualOrdem.equals("datacadastro")) {
lf = listInOrderDatacadastro();
} else {
lf = listInOrderClienteCFP();}
List<String> ls = new ArrayList<>();
for (int i = 0; i < lf.size(); i++) {
ls.add(lf.get(i).getDataCadastro()+ "-" + lf.get(i).getPessoaCPF());}
return ls;}}
