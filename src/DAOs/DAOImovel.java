package DAOs;

import Entidades.Imovel;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import Entidades.Imovel;
import java.text.SimpleDateFormat;

public class DAOImovel extends DAOGenerico<Imovel> {

    public DAOImovel() {
        super(Imovel.class);
    }

    public int autoIdImovel() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.codigo_Imovel) FROM Imovel e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Imovel> listByCodigo_Imovel(int codigo_Imovel) {
        return em.createQuery("SELECT e FROM Imovel e WHERE e.codigo_Imovel = :codigo_Imovel").setParameter("codigo_Imovel", codigo_Imovel).getResultList();
    }

    public List<Imovel> listByDisponibilidade(String disponibilidade) {
        return em.createQuery("SELECT e FROM Imovel e WHERE e.disponibilidade LIKE :disponibilidade").setParameter("disponibilidade", "%" + disponibilidade + "%").getResultList();
    }

    public List<Imovel> listInOrderCodigo_Imovel() {
        return em.createQuery("SELECT e FROM Imovel e ORDER BY e.codigo_Imovel").getResultList();
    }

    public List<Imovel> listInOrderDisponibilidade() {
        return em.createQuery("SELECT e FROM Imovel e ORDER BY e.disponibilidade").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Imovel> lf;
        if (qualOrdem.equals("codigo_Imovel")) {
            lf = listInOrderCodigo_Imovel();
        } else {
            lf = listInOrderDisponibilidade();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCodigoImovel() + ";" + ";" + lf.get(i).getEndereco() + lf.get(i).getDisponibilidade() + lf.get(i).getPreco() + ";" + ";");
        }
        return ls;
    }

    public Imovel obter(String codigo_Imovel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
