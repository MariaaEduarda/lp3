//package DAOs;
//
//import Entidades.Fiador;
//import java.util.ArrayList;
//import java.util.List;
//import static DAOs.DAOGenerico.em;
//import java.text.SimpleDateFormat;
//
//public class DAOFiador extends DAOGenerico<Fiador> {
//
//    public DAOFiador() {
//        super(Fiador.class);
//    }
//
//    public int autoIdFiador() {
//        Integer a = (Integer) em.createQuery("SELECT MAX(e.fiadorcpf) FROM Fiador e ").getSingleResult();
//        if (a != null) {
//            return a + 1;
//        } else {
//            return 1;
//        }
//    }
//
//    public List<Fiador> listByFiadorcpf(int fiadorcpf) {
//        return em.createQuery("SELECT e FROM Fiador e WHERE e.fiadorcpf = :fiadorcpf").setParameter("fiadorcpf", fiadorcpf).getResultList();
//    }
//
//    public List<Fiador> listByRendamensal(String rendamensal) {
//        return em.createQuery("SELECT e FROM Fiador e WHERE e.rendamensal LIKE :rendamensal").setParameter("rendamensal", "%" + rendamensal + "%").getResultList();
//    }
//
//    public List<Fiador> listInOrderFiadorcpf() {
//        return em.createQuery("SELECT e FROM Fiador e ORDER BY e.fiadorcpf").getResultList();
//    }
//
//    public List<Fiador> listInOrderRendamensal() {
//        return em.createQuery("SELECT e FROM Fiador e ORDER BY e.rendamensal").getResultList();
//    }
//
//    public List<String> listInOrderNomeStrings(String qualOrdem) {
//        List<Fiador> lf;
//        if (qualOrdem.equals("fiadorcpf")) {
//            lf = listInOrderFiadorcpf();
//        } else {
//            lf = listInOrderRendamensal();
//        }
//
//        List<String> ls = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        for (int i = 0; i < lf.size(); i++) {
//            ls.add(lf.get(i).getPessoaCPF()+ ";" + lf.get(i).getRendaMensal()+ ";");
//        }
//        return ls;
//    }
//}
//
package DAOs;

import static DAOs.DAOGenerico.em;
import Entidades.Fiador;
import java.util.ArrayList;
import java.util.List;

public class DAOFiador extends DAOGenerico<Fiador> {

private List<Fiador> lista = new ArrayList<>();    public DAOFiador(){
        super(Fiador.class);
    }

    public int autoPessoaCPF() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.pessoaCPF) FROM Fiador e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Fiador> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Fiador e WHERE e.pessoaCPF) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Fiador> listById(int id) {
        return em.createQuery("SELECT e FROM Fiador + e WHERE e.rendaMensal= :id").setParameter("id", id).getResultList();
    }

    public List<Fiador> listInOrderNome() {
        return em.createQuery("SELECT e FROM Fiador e ORDER BY e.rendaMensal").getResultList();
    }

    public List<Fiador> listInOrderId() {
        return em.createQuery("SELECT e FROM Fiador e ORDER BY e.pessoaCPF").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Fiador> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getPessoaCPF() + "-" + lf.get(i).getRendaMensal());
        }
        return ls;
    }


public static void main(String[] args) {
        DAOFiador daoFiador = new DAOFiador();
        List<Fiador> listaFiador = daoFiador.list();
        for (Fiador fiador : listaFiador) {
            System.out.println(fiador.getPessoaCPF()+"-"+fiador.getRendaMensal());
        }
    }}