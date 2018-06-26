//package DAOs;
//
//import Entidades.Funcionario;
//import java.util.ArrayList;
//import java.util.List;
//import static DAOs.DAOGenerico.em;
//import java.text.SimpleDateFormat;
//
//public class DAOFuncionario extends DAOGenerico<Funcionario> {
//
//    public DAOFuncionario() {
//        super(Funcionario.class);
//    }
//
//    public int autoIdFuncionario() {
//        Integer a = (Integer) em.createQuery("SELECT MAX(e.Funcionario_cpf) FROM Funcionario e ").getSingleResult();
//        if (a != null) {
//            return a + 1;
//        } else {
//            return 1;
//        }
//    }
//
//    public List<Funcionario> listByFuncionario_cpf(int Funcionario_cpf) {
//        return em.createQuery("SELECT e FROM Funcionario e WHERE e.Funcionario_cpf = :Funcionario_cpf").setParameter("Funcionario_cpf", Funcionario_cpf).getResultList();
//    }
//
//    public List<Funcionario> listBySenha_usuario(String senha_usuario) {
//        return em.createQuery("SELECT e FROM Funcionario e WHERE e.senha_usuario LIKE :senha_usuario").setParameter("senha_usuario", "%" + senha_usuario + "%").getResultList();
//    }
//
//    public List<Funcionario> listInOrderFuncionario_cpf() {
//        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.Funcionario_cpf").getResultList();
//    }
//
//    public List<Funcionario> listInOrderSenha_usuario() {
//        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.senha_usuario").getResultList();
//    }
//
//    public List<String> listInOrderNomeStrings(String qualOrdem) {
//        List<Funcionario> lf;
//        if (qualOrdem.equals("Funcionario_cpf")) {
//            lf = listInOrderFuncionario_cpf();
//        } else {
//            lf = listInOrderSenha_usuario();
//        }
//
//        List<String> ls = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        for (int i = 0; i < lf.size(); i++) {
//            ls.add(lf.get(i).getPessoaCPF()+ ";" + lf.get(i).getSenha()+ ";");
//        }
//        return ls;
//    }
//}
//
package DAOs;

import static DAOs.DAOGenerico.em;
import Entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionario extends DAOGenerico<Funcionario> {

private List<Funcionario> lista = new ArrayList<>();    public DAOFuncionario(){
        super(Funcionario.class);
    }

    public int autoPessoaCPF() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.pessoaCPF) FROM Funcionario e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Funcionario> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Funcionario e WHERE e.pessoaCPF) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Funcionario> listById(int id) {
        return em.createQuery("SELECT e FROM Funcionario + e WHERE e.senha= :id").setParameter("id", id).getResultList();
    }

    public List<Funcionario> listInOrderNome() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.senha").getResultList();
    }

    public List<Funcionario> listInOrderId() {
        return em.createQuery("SELECT e FROM Funcionario e ORDER BY e.pessoaCPF").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Funcionario> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getPessoaCPF() + "-" + lf.get(i).getSenha());
        }
        return ls;
    }


public static void main(String[] args) {
        DAOFuncionario daoFuncionario = new DAOFuncionario();
        List<Funcionario> listaFuncionario = daoFuncionario.list();
        for (Funcionario fiador : listaFuncionario) {
            System.out.println(fiador.getPessoaCPF()+"-"+fiador.getSenha());
        }
    }}