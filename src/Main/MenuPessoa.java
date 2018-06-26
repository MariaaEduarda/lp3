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
import GUIs.GUICliente;
import GUIs.GUIComodoImovel;
import GUIs.GUIFiador;
import GUIs.GUIFuncionario;
import GUIs.GUIImovel;
import GUIs.GUITipoImovel;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MenuPessoa extends JFrame {
//    JLabel labelComImagemDeTamanhoDiferente = new JLabel();
    
  ImageIcon iconeLogo = new ImageIcon(getClass().getResource("/fotos/Imobiliaria.png"));
    JLabel logo = new JLabel(iconeLogo);

    

    Container cp;
    JPanel pnNorte = new JPanel();
    JPanel pnCentro = new JPanel();
    JLabel lbTitulo = new JLabel("Menu -Imobiliaria");

    Font fonte = new Font("Monotype Corsiva", Font.BOLD, 30);

//    JLabel labelComImagemDeTamanhoDiferente = new JLabel();

    JMenuBar menuBar = new JMenuBar();
    JMenu menuCadastros = new JMenu("Cadastros");
    JMenu menuListagem = new JMenu("Listagem");
    JMenuItem cadPessoa = new JMenuItem("Pessoa");
    JMenuItem cadImovel = new JMenuItem("Imovel");
    JMenuItem cadTipoImovel = new JMenuItem("Tipo Imovel");
    JMenuItem cadComodoImovel = new JMenuItem("Comodo Imovel");
    JMenuItem cadCliente = new JMenuItem("Cliente");
    JMenuItem cadFuncionario = new JMenuItem("Funcionário");
    JMenuItem cadFiador = new JMenuItem("Fiador");

    Point p;

    public MenuPessoa(Dimension dimensao) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setSize(dimensao);
            setSize(800,600);
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

        cadCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GUICliente(new Point(100, 100), new Dimension(800, 600));
            }
        });
         cadFiador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIFiador(new Point(100, 100), new Dimension(800, 600));
            }
        });

     cadFuncionario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIFuncionario(new Point(100, 100), new Dimension(800, 600));
            }
        });
        
        pnCentro.add(logo);
        pnCentro.setBackground(Color.BLACK);

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);

        setJMenuBar(menuBar);
        menuBar.add(menuCadastros);
        

        menuCadastros.add(cadPessoa);
        menuCadastros.add(cadImovel);
        menuCadastros.add(cadTipoImovel);
        menuCadastros.add(cadComodoImovel);
        menuCadastros.add(cadCliente);
        menuCadastros.add(cadFiador);
        menuCadastros.add(cadFuncionario);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Sai do sistema  
                System.exit(0);
            }
        });

//        pack();
        p = new CentroDoMonitorMaior().getCentroMonitorMaior(this);
        setLocation(p);
        setVisible(true);
    }

    MenuPessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
