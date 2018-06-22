package Main;

import GUIs.GUIPessoa;
//import null.GUInull;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import Auxiliar.*;
import GUIs.GUIComodoImovel;
import GUIs.GUIImovel;
import GUIs.GUITipoImovel;
import GUIs.PessoaGUIListagem;
import java.awt.Dimension;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MenuPessoa extends JFrame {

    Container cp;
    JPanel pnNorte = new JPanel();
    JPanel pnCentro = new JPanel();
    JLabel lbTitulo = new JLabel("Menu - Produtos com relacionamento 1:n");

    Font fonte = new Font("Monotype Corsiva", Font.BOLD, 30);

    JLabel labelComImagemDeTamanhoDiferente = new JLabel();

    JMenuBar menuBar = new JMenuBar();
    JMenu menuCadastros = new JMenu("Cadastros");
    JMenuItem cadPessoa = new JMenuItem("Pessoa");
    JMenuItem cadImovel = new JMenuItem("Imovel");
    JMenuItem cadTipoImovel = new JMenuItem("Tipo Imovel");
    JMenuItem cadComodoImovel = new JMenuItem("Comodo Imovel");
    JMenuItem cadPessoaListagem = new JMenuItem("Listagem Pessoa");

    Point p;

    public MenuPessoa() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setSize(dimensao);
        setTitle(lbTitulo.getText());

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        pnNorte.add(lbTitulo);
        lbTitulo.setFont(fonte);
        pnNorte.setBackground(Color.LIGHT_GRAY);

        cadPessoa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIPessoa();
            }
        });
        cadImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIImovel();
            }
        });

        cadComodoImovel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIComodoImovel(new Point(100, 100), new Dimension(800, 600));
            }
        });
        cadTipoImovel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GUITipoImovel(new Point(100, 100), new Dimension(800, 600));
            }
        });
        
//        cadPessoaListagem.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new PessoaGUIListagem();
//            }
//        });

        pnCentro.add(labelComImagemDeTamanhoDiferente);
        pnCentro.setBackground(Color.BLACK);

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);

        setJMenuBar(menuBar);
        menuBar.add(menuCadastros);

        menuCadastros.add(cadPessoa);
        menuCadastros.add(cadImovel);
        menuCadastros.add(cadTipoImovel);
        menuCadastros.add(cadComodoImovel);
        menuCadastros.add(cadPessoaListagem);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Sai do sistema  
                System.exit(0);
            }
        });

        pack();
        p = new CentroDoMonitorMaior().getCentroMonitorMaior(this);
        setLocation(p);
        setVisible(true);
    }
}
