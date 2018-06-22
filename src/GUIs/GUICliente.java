//package GUIs;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import DAOs.DAOCliente;
//import Entidades.Cliente;
//import java.text.ParseException;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import javax.swing.JButton;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.ArrayList;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JSpinner;
//import javax.swing.JTextField;
//import javax.swing.SpinnerDateModel;
//import myUtil.ManipulaArquivo;
//
//public class GUICliente extends JFrame {
//private Container cp;
//private JPanel pnNorte = new JPanel(new FlowLayout());
//    private JPanel pnCentro = new JPanel(new FlowLayout());
//     private JPanel pnSul = new JPanel(new FlowLayout());    private JPanel pnAuxiliar = new JPanel(new GridLayout(1, 2));
//
//    private JButton btBuscar = new JButton("Buscar");
//    private JButton btAdicionar = new JButton("Adicionar");
//    private JButton btSalvar = new JButton("Salvar");
//    private JButton btCancelar = new JButton("Cancelar");
//    private JButton btRemover = new JButton("Remover");
//    private JButton btAtualizar = new JButton("Atualizar");
//    private JButton btListar = new JButton("Listagem");
//private JLabel lDatacadastro = new JLabel("Datacadastro: -> dd/MM/yyyy ");
////    private DateTextField tfDatacadastro = new DateTextField ();
//    private JSpinner spinnerdata_nasc = new JSpinner(new SpinnerDateModel());
//    private final JSpinner.DateEditor spinnerEditordata_nasc = new JSpinner.DateEditor(spinnerdata_nasc, "dd/MM/yyyy");
//
//private JLabel lClienteCFP = new JLabel("ClienteCFP:");
// private JTextField tfClienteCFP= new JTextField(30);
//
//private JLabel lAviso = new JLabel("Aviso:");
//DAOCliente controle = new DAOCliente();
//private boolean acao = true;
//Cliente cliente = new Cliente();
// ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
//    List<String> dados = new ArrayList<>();
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    public GUICliente() throws ParseException{
//
//
//        setSize(800, 300);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//        setTitle("Cliente");
//        pnNorte.setBackground(Color.BLUE);
//        pnCentro.setBackground(Color.GRAY);
//        pnSul.setBackground(Color.RED);
//
//
//        pnNorte.add(lDatacadastro);
//        pnNorte.add(spinnerdata_nasc);
//        pnNorte.add(btBuscar);
//        pnNorte.add(btAdicionar);
//        pnNorte.add(btSalvar);
//        pnNorte.add(btCancelar);
//        pnNorte.add(btRemover);
//        pnNorte.add(btAtualizar);
//        pnNorte.add(btListar);
//        btAdicionar.setVisible(false);
//        btSalvar.setVisible(false);
//        btCancelar.setVisible(false);
//        btRemover.setVisible(false);
//        btAtualizar.setVisible(false);
//
//        pnAuxiliar.setLayout(new GridLayout(1,2));
//        pnAuxiliar.add(lClienteCFP); 
//        pnAuxiliar.add(tfClienteCFP);
//
//        pnCentro.add(pnAuxiliar); 
//        pnSul.add(lAviso);
//        cp.setLayout(new BorderLayout());
//        cp.add(pnNorte, BorderLayout.NORTH);
//        cp.add(pnSul, BorderLayout.SOUTH);
//        cp.add(pnCentro, BorderLayout.CENTER);
//btBuscar.addActionListener(
//                new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e
//                    ) {
//                        try {
//                            cliente = new Cliente();
//
//                            int datacadastro = Integer.valueOf(lDatacadastro.getText());
//                            cliente.setPessoaCPF(datacadastro);
//                            if (datacadastro <= 0) {
//datacadastro=datacadastro/ 0;
// }
//
//                                cliente = controle.obter(cliente.getPessoaCPF());
//
//                                if (cliente != null) {
//
//                                    tfClienteCFP.setText(String.valueOf(cliente.getDataCadastro()));
//
//                                    lAviso.setBackground(Color.green);
//                                    lAviso.setText("Encontrado");
//
//                                    btAtualizar.setVisible(true);
//                                    btRemover.setVisible(true);
//                                    btAdicionar.setVisible(false);
//                                } else {
//                                    btAdicionar.setVisible(true);
//                                    btAtualizar.setVisible(false);
//                                    btRemover.setVisible(false);
//
//
//                                    lAviso.setBackground(Color.red);
//                                    lAviso.setText("NÃ£o encontrado");
//
//                                }
//                            }
//                        catch (Exception e1){
//                            JOptionPane.showMessageDialog(null, "Erro de inserção dos dados, verifique as informações");}
//
//                        }
//                }
//        );
//btAdicionar.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e
//                    ) {
//                        acao = true;
//                        btBuscar.setVisible(false);
//
//                        spinnerdata_nasc.setEnabled(false);
//                        tfClienteCFP.requestFocus();
//
//                        tfClienteCFP.setEnabled(true); 
//                        tfClienteCFP.setText("");
//
//                        btAdicionar.setVisible(false);
//                        btSalvar.setVisible(true);
//                        btCancelar.setVisible(true);
//                        btRemover.setVisible(false);
//                        btAtualizar.setVisible(false);
//                    }
//                }
//        );btSalvar.addActionListener(
//                new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e
//                    ) {
//                        Cliente cliente = new Cliente();
//                        try{                        cliente.setDataCadastro();
//(Integer.valueOf(lDatacadastro.getText()));
//
//cliente.setClienteCFPCliente(Dependente.valueOf(tfClienteCFP.getText()));
//
//if (acao) {//inserir
//
//                            List<String> listaCliente = new ArrayList();
//
//                             listaCliente.add(String.valueOf(cliente.getDatacadastroCliente()));
//                             listaCliente.add(String.valueOf(cliente.getClienteCFPCliente()));
//
//                            controle.inserir(cliente);
//                            lAviso.setText("Registro inserido");
//
//                        } else {//alterar
//                            Cliente x = new Cliente();
//
//                         x.setDataCadastrolDatacadastro.getText()));
//
//                            x = controle.obter(x.getDatacadastroCliente());
//                            controle.atualizar(cliente);
//
//                            lAviso.setText("Registro alterado");
//                        }
//
//                        lDatacadastro.setEnabled(true);
//                        lDatacadastro.requestFocus();
////                        lDatacadastro.selectAll();
//                        btSalvar.setVisible(false);
//                        btCancelar.setVisible(false);
//                        btBuscar.setVisible(true);
//                    }
//catch (Exception exbui) {
// JOptionPane.showMessageDialog(null,"Erro na inserção dos dados");                }}}
//        );
//btCancelar.addActionListener(
//                new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e
//                    ) {
//                        lAviso.setText("Cancelado");
//                        lDatacadastro.setEnabled(true);
//
//                        lDatacadastro.requestFocus();
////                        lDatacadastro.selectAll();
//
//
//                        btSalvar.setVisible(false);
//                        btCancelar.setVisible(false);
//                        btBuscar.setVisible(true);
//
//                        tfClienteCFP.setText("");
//
//}
//}
//);
//btAtualizar.addActionListener(
//                new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e
//                    ) {
//                        acao = false;
//                        lDatacadastro.setEnabled(false);
//                        tfClienteCFP.setEnabled(true); 
//                        tfClienteCFP.requestFocus();
//                        btSalvar.setVisible(true);
//                        btCancelar.setVisible(true);
//                        btBuscar.setVisible(false);
//                        btRemover.setVisible(false);
//                        btAtualizar.setVisible(false);
//
//                    }
//                }
//);
//btRemover.addActionListener(
//                new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e
//                    ) {
//                        btRemover.setVisible(false);
//                        btAtualizar.setVisible(false);
//                        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
//                                "Confirma a exclusÃ£o do registro <DATACADASTRO= " + cliente.getDataCadastro()+ ">?", "Confirm",
//                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
//
//                            controle.remover(cliente);
//                            lAviso.setText("Removeu");
//                        tfClienteCFP.setText("");
//                        lDatacadastro.setEnabled(true);
//                        lDatacadastro.requestFocus();
////                        lDatacadastro.selectAll();
//
//                        } else {
//                            lAviso.setText("Cancelada a remoÃ§Ã£o");
//                            btRemover.setVisible(true);
//                            btAtualizar.setVisible(true);
//                        }
//
//                    }
//                }
//        );
//btListar.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//              ClienteGUIListagem clienteGuiListagem;
//              List<Cliente> listaCliente = controle.list();
//                for (Cliente a : listaCliente) {
//                    dados.add(a.toString());
//                }
//                clienteGuiListagem = new ClienteGUIListagem(listaCliente,400,400);
//    
//             }
//        });
//addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//}
//
//// COMENTEI TUDO OS SELECTAll