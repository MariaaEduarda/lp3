package DAOs;

import Entidades.ComodoImovel;
import java.util.ArrayList;
import java.util.List;

public class DAOComodoImovel extends DAOGenerico<ComodoImovel> {

    private List<ComodoImovel> lista = new ArrayList<>();

    public DAOComodoImovel() {
        super(ComodoImovel.class);
    }

    public int autoIdcomodoImovel() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idcomodoImovel) FROM ComodoImovel e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<ComodoImovel> listByNome(String nome) {
        return em.createQuery("SELECT e FROM ComodoImovel e WHERE e.idcomodoImovel) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<ComodoImovel> listById(int id) {
        return em.createQuery("SELECT e FROM ComodoImovel + e WHERE e.nomeComodo= :id").setParameter("id", id).getResultList();
    }

    public List<ComodoImovel> listInOrderNome() {
        return em.createQuery("SELECT e FROM ComodoImovel e ORDER BY e.nomeComodo").getResultList();
    }

    public List<ComodoImovel> listInOrderId() {
        return em.createQuery("SELECT e FROM ComodoImovel e ORDER BY e.idcomodoImovel").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<ComodoImovel> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdcomodoImovel() + "-" + lf.get(i).getNomeComodo());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOComodoImovel daoComodoImovel = new DAOComodoImovel();
        List<ComodoImovel> listaComodoImovel = daoComodoImovel.list();
        for (ComodoImovel comodoImovel : listaComodoImovel) {
            System.out.println(comodoImovel.getIdcomodoImovel() + "-" + comodoImovel.getNomeComodo());
        }
    }
}
