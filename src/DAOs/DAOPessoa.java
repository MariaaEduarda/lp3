package DAOs;

import Entidades.Pessoa;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOPessoa extends DAOGenerico<Pessoa> {

    public DAOPessoa() {
        super(Pessoa.class);
    }

    public int autoIdPessoa() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.cpf) FROM Pessoa e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Pessoa> listByCpf(int cpf) {
        return em.createQuery("SELECT e FROM Pessoa e WHERE e.cpf = :cpf").setParameter("cpf", cpf).getResultList();
    }

    public List<Pessoa> listByRg(String rg) {
        return em.createQuery("SELECT e FROM Pessoa e WHERE e.rg LIKE :rg").setParameter("rg", "%" + rg + "%").getResultList();
    }

    public List<Pessoa> listInOrderCpf() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.cpf").getResultList();
    }

    public List<Pessoa> listInOrderRg() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.rg").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pessoa> lf;
        if (qualOrdem.equals("cpf")) {
            lf = listInOrderCpf();
        } else {
            lf = listInOrderRg();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCpf() + ";" + lf.get(i).getRg() + ";" + lf.get(i).getNome() + ";" + sdf.format(lf.get(i).getDataNasc()) + ";" + lf.get(i).getEmail() + ";" + lf.get(i).getSexo() + ";" + lf.get(i).getEstadoCivil() + ";" + lf.get(i).getEndereco() + ";" + lf.get(i).getTelefone() + ";" + lf.get(i).getCelular() + ";");
        }
        return ls;
    }
}

