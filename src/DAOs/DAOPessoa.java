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
        Integer a = (Integer) em.createQuery("SELECT MAX(e.CPF) FROM Pessoa e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Pessoa> listByCPF(int CPF) {
        return em.createQuery("SELECT e FROM Pessoa e WHERE e.CPF = :CPF").setParameter("CPF", CPF).getResultList();
    }

    public List<Pessoa> listByRG(String RG) {
        return em.createQuery("SELECT e FROM Pessoa e WHERE e.RG LIKE :RG").setParameter("RG", "%" + RG + "%").getResultList();
    }

    public List<Pessoa> listInOrderCPF() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.CPF").getResultList();
    }

    public List<Pessoa> listInOrderRG() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.RG").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pessoa> lf;
        if (qualOrdem.equals("CPF")) {
            lf = listInOrderCPF();
        } else {
            lf = listInOrderRG();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCpf() + ";" + lf.get(i).getRg() + ";"
                    + lf.get(i).getNome() + ";" + lf.get(i).getCelular()
                    + ";" + lf.get(i).getTelefone() + ";" + lf.get(i).getEmail()
                    + ";" + lf.get(i).getSexo() + ";" + sdf.format(lf.get(i).getDataNasc())
                    + ";" + lf.get(i).getEndereco() + ";" + lf.get(i).getEstadoCivil() + ";");
        }
        return ls;
    }

    public Pessoa obter(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
