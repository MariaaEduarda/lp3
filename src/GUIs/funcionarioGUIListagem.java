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
//public class funcionarioGUIListagem extends JDialog {
//
//    JPanel painelTa = new JPanel();
//    static DefaultTableModel modelo = new DefaultTableModel(new String[]{"C:\\Users\\Maggie\\Desktop\\Pesoa.txt","senha"}, 0);
//    static JTable tabela = new JTable(modelo);
//    JScrollPane scroll = new JScrollPane(tabela);
//    List<String> lista = new ArrayList<>();
//    public funcionarioGUIListagem(List<String> texto, Container cp2) {
//        setTitle("Listagem de funcionario");
//        setSize(840, 315);//tamanho da janela
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memória a classe
//        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
//        setBackground(Color.CYAN);//cor do fundo da janela
//        setModal(true);
//        lista = texto;        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes
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
//        DefaultTableModel modelo = new DefaultTableModel(new String[]{"C:\\Users\\Maggie\\Desktop\\Pesoa.txt","senha"}, 0);
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
//    }}
//
package GUIs;

import Entidades.Funcionario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class funcionarioGUIListagem extends JDialog {

    JPanel painelTa = new JPanel();
    JScrollPane scroll = new JScrollPane();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

    public funcionarioGUIListagem(List<Funcionario> texto, int posX, int posY, Dimension dimensao) {
        setTitle("Listagem de Funcionario");
        setSize(dimensao);//tamanho da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memÃ³ria a classe
        setLayout(new BorderLayout());//informa qual gerenciador de layout serÃ¡ usado
        setBackground(Color.CYAN);//cor do fundo da janela
        setModal(true);
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        JToolBar toolBar = new JToolBar();

        String[] colunas = new String[]{"pessoaCPF",
            "senha",
            "pessoa.getPessoa",};

        String[][] dados = new String[0][3];

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        JTable tabela = new JTable(model);

        scroll.setViewportView(tabela);

        for (int i = 0; i < texto.size(); i++) {
            String[] linha = new String[]{String.valueOf(texto.get(i).getPessoaCPF()),
                (texto.get(i).getSenha()),
                texto.get(i).getPessoa().getNome()};
            model.addRow(linha);
        }

        // scroll.add(ta);
        painelTa.add(scroll);

        cp.add(toolBar, BorderLayout.NORTH);
        cp.add(scroll, BorderLayout.CENTER);

        setLocation(posX + 20, posY + 20);
        setVisible(true);//faz a janela ficar visÃ­vel        
    }
}