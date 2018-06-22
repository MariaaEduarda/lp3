package DAOs;

import Entidades.TipoImovel;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoImovel extends DAOGenerico<TipoImovel> {

    private List<TipoImovel> lista = new ArrayList<>();

    public DAOTipoImovel() {
        super(TipoImovel.class);
    }

    public int autoIdImovel() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idImovel) FROM TipoImovel e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<TipoImovel> listByNome(String nome) {
        return em.createQuery("SELECT e FROM TipoImovel e WHERE e.idImovel) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<TipoImovel> listById(int id) {
        return em.createQuery("SELECT e FROM TipoImovel + e WHERE e.nomeTipoImovel= :id").setParameter("id", id).getResultList();
    }

    public List<TipoImovel> listInOrderNome() {
        return em.createQuery("SELECT e FROM TipoImovel e ORDER BY e.nomeTipoImovel").getResultList();
    }

    public List<TipoImovel> listInOrderId() {
        return em.createQuery("SELECT e FROM TipoImovel e ORDER BY e.idImovel").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<TipoImovel> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdImovel() + "-" + lf.get(i).getNomeTipoImovel());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOTipoImovel daoTipoImovel = new DAOTipoImovel();
        List<TipoImovel> listaTipoImovel = daoTipoImovel.list();
        for (TipoImovel tipoImovel : listaTipoImovel) {
            System.out.println(tipoImovel.getIdImovel() + "-" + tipoImovel.getNomeTipoImovel());
        }
    }
}
