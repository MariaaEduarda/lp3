//package GUIs;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Desktop;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JDialog;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JToolBar;
//import javax.swing.table.DefaultTableModel;
//import Auxiliar.*;
//// @author Radames
//
//public class PessoaGUIListagem extends JDialog {
//
//    JPanel painelTa = new JPanel();
//    static DefaultTableModel modelo = new DefaultTableModel(new String[]{"cpf", "RG", "Nome", "Celular", "telefone", "email", "sexo", "Data_nascimento", "endereco", "estado_civil"}, 0);
//    static JTable tabela = new JTable(modelo);
//    JScrollPane scroll = new JScrollPane(tabela);
//    List<String> lista = new ArrayList<>();
//
//    public PessoaGUIListagem(List<String> texto, Container cp2) {
//        setTitle("Listagem de Pessoa");
//        setSize(840, 315);//tamanho da janela
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memória a classe
//        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
//        setBackground(Color.CYAN);//cor do fundo da janela
//        setModal(true);
//        lista = texto;
//        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes
//
//        painelTa.add(scroll);
//        atualizaTabela();
//
//        cp.add(scroll, BorderLayout.CENTER);
//
//        setLocationRelativeTo(cp2);
//        setVisible(true);
//    }
//
//    public void atualizaTabela() {
//        DefaultTableModel modelo = new DefaultTableModel(new String[]{"cpf", "RG", "Nome", "Celular", "telefone", "email", "sexo", "Data_nascimento", "endereco", "estado_civil"}, 0);
//        int aux = 0;
//
//        for (int i = 0; i < lista.size(); i++) {
//            String[] linha = lista.get(i).toString().split(";");
//            modelo.addRow(linha);
//            aux++;
//        }
//        while (aux < 10) {
//            aux++;
//            modelo.addRow(new Object[]{"", "", "", "", ""});
//        }
//
//        tabela.setModel(modelo);
//    }
//}

package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import Auxiliar.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
// @author Radames
public class PessoaGUIListagem extends JDialog {

    JPanel painelTa = new JPanel();
    static DefaultTableModel modelo = new DefaultTableModel(new String[]{"CPF","RG","Nome","Data Nascimento","E-mail","Sexo","Estado Civil","Endereco","Telefone","Celular"}, 0);
    static JTable tabela = new JTable(modelo);
    JScrollPane scroll = new JScrollPane(tabela);
    List<String> lista = new ArrayList<>();
    public PessoaGUIListagem(List<String> texto, Container cp2) {
        setTitle("Listagem de Pessoa");
        setSize(840, 315);//tamanho da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memória a classe
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        setModal(true);
        lista = texto;        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        painelTa.add(scroll);
        atualizaTabela();

        cp.add(scroll, BorderLayout.CENTER);

        setLocationRelativeTo(cp2);
        setVisible(true);       
    }

    public void atualizaTabela() {
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"CPF","RG","Nome","Data Nascimento","E-mail","Sexo","Estado Civil","Endereco","Telefone","Celular"}, 0);
        int aux = 0;

        for (int i = 0; i < lista.size(); i++) {
            String[] linha = lista.get(i).toString().split(";");
            modelo.addRow(linha);
            aux++;
        }
        while (aux < 10) {
            aux++;
            modelo.addRow(new Object[]{"", "", "", "", ""});
        }

        tabela.setModel(modelo);
    }}

