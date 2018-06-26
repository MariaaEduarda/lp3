//package GUIs;
//
//
//
//
//import Entidades.Imovel;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import javax.swing.table.AbstractTableModel;
//
//public class ImovelTableModel extends AbstractTableModel {
//
//    private final Class classes[] = new Class[]{Integer.class, String.class};
//    private final String colunas[] = new String[]{"codigo", "Disponibilidade","preco","endereco","tipo_imovel_id_imovel"};
//    private List<Imovel> dados;
//    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
//  
//
//    public ImovelTableModel(List<Imovel> dados) {
//        this.dados = dados;
//    }
//
//    public void setDados(List<Imovel> dados) {
//        this.dados = dados;
//    }
//
//    public List<Imovel> getDados() {
//        return this.dados;
//    }
//
//    @Override
//    public int getColumnCount() {
//        return colunas.length;
//    }
//
//    @Override
//    public int getRowCount() {
//        return dados.size();
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return classes[columnIndex];
//    }
//
//    @Override
//    public String getColumnName(int columnIndex) {
//        return colunas[columnIndex];
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//
//        Imovel s = dados.get(rowIndex);
//        switch (columnIndex) {
//            case 0:
//                return s.getCodigoImovel();
//            case 1:
//                return s.getDisponibilidade();            
//            default:
//                throw new IndexOutOfBoundsException("Coluna Inválida!");
//        }
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        if (columnIndex==0) {
//            return false;
//        }
//        return true;
//    }
//
//  
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//
//      //  mudou = true;
//        Imovel s = dados.get(rowIndex);
//        switch (columnIndex) {
//            case 0:              
//                    s.setCodigoImovel(Integer) aValue);                
//                break;
//            case 1:
//                s.setNome((String) aValue);
//                break;          
//            default:
//                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
//        }
//        fireTableDataChanged();
//    }
//
//    public Imovel getValue(int rowIndex) {
//        return dados.get(rowIndex);
//    }
//
//    public int indexOf(Imovel tc) {
//        return dados.indexOf(tc);
//    }
//
//    public void onAdd(Imovel tipoConta) {
//        dados.add(tipoConta);
//        fireTableRowsInserted(indexOf(tipoConta), indexOf(tipoConta));
//    }
//
//    public void onRemove(int[] rowIndex) {
//        int x;
//        for (x = rowIndex.length - 1; x >= 0; x--) {
//            dados.remove(rowIndex[x]);
//            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
//        }
//    }
//}
