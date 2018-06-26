package GUIs;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import DAOs.DAOCliente;
//import DAOs.DAOPessoa;
//import Entidades.Cliente;
//import java.text.ParseException;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.Point;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import javax.swing.JButton;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JSpinner;
//import javax.swing.JTextField;
//import javax.swing.SpinnerDateModel;
//import myUtil.JanelaPesquisar;
//import myUtil.ManipulaArquivo;
//
//public class GUICliente extends JFrame {
//
//    public static void main(String[] args) {
//        new GUICliente();
//    }
//
//    private Container cp;
//    private JPanel pnNorte = new JPanel(new FlowLayout());
//    private JPanel pnCentro = new JPanel(new FlowLayout());
//    private JPanel pnSul = new JPanel(new FlowLayout());
//    private JPanel pnAuxiliar = new JPanel(new GridLayout(1, 2));
//    private List<String> stringpessoaIdPessoa = new ArrayList<>();
//    private JButton btBuscar = new JButton("Buscar");
//    private JButton btAdicionar = new JButton("Adicionar");
//    private JButton btSalvar = new JButton("Salvar");
//    private JButton btCancelar = new JButton("Cancelar");
//    private JButton btRemover = new JButton("Remover");
//    private JButton btAtualizar = new JButton("Atualizar");
//    private JButton btListar = new JButton("Listagem");
//    private JLabel lDatacadastro = new JLabel("Datacadastro: ");
//    private JComboBox comboPessoaIdPessoa = new JComboBox();
////    private DateTextField tfDatacadastro = new DateTextField ();
//    private JSpinner spinnerdata_nasc = new JSpinner(new SpinnerDateModel());
//    private final JSpinner.DateEditor spinnerEditordata_nasc = new JSpinner.DateEditor(spinnerdata_nasc, "dd/MM/yyyy");
//
//    private JLabel lClienteCFP = new JLabel("Cpf:");
//    private JTextField tfClienteCFP = new JTextField(30);
//
//    private JLabel lAviso = new JLabel("Aviso:");
//    DAOCliente controle = new DAOCliente();
//    private boolean acao = true;
//    Cliente cliente = new Cliente();
//    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
//    List<String> dados = new ArrayList<>();
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//    public GUICliente() {
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
//        List<String> combo = new ArrayList<>();
//        combo = new DAOPessoa().listInOrderNomeStrings("idPessoa");
//        for (int x = 0; x < combo.size(); x++) {
//            String[] aux = combo.get(x).split(";");
//            stringpessoaIdPessoa.add(aux[0] + "-" + aux[1]);
//        }
//        comboPessoaIdPessoa = new JComboBox(stringpessoaIdPessoa.toArray());
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
//        pnAuxiliar.setLayout(new GridLayout(1, 2));
//        pnAuxiliar.add(lClienteCFP);
//        pnAuxiliar.add(tfClienteCFP);
//
//        comboPessoaIdPessoa.addItemListener(new java.awt.event.ItemListener() {
//            public void itemStateChanged(java.awt.event.ItemEvent evt) {
//                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
//                    tfClienteCFP.setText(String.valueOf(comboPessoaIdPessoa.getSelectedItem()).split("-")[0]);
//                    //pega o id da pessoa e manda para o fdIdPessoa
//                }
//
//            }
//
//        });
//        pnCentro.add(pnAuxiliar);
//        pnSul.add(lAviso);
//        cp.setLayout(new BorderLayout());
//        cp.add(pnNorte, BorderLayout.NORTH);
//        cp.add(pnSul, BorderLayout.SOUTH);
//        cp.add(pnCentro, BorderLayout.CENTER);
//        btBuscar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    cliente = new Cliente();
//
//                    int datacadastro = Integer.valueOf(lDatacadastro.getText());
//                    cliente.setPessoaCPF(datacadastro);
//                    if (datacadastro <= 0) {
//                        datacadastro = datacadastro / 0;
//                    }
//
//                    cliente = controle.obter(cliente.getPessoaCPF());
//
//                    if (cliente != null) {
//
//                        tfClienteCFP.setText(String.valueOf(cliente.getDataCadastro()));
//
//                        lAviso.setBackground(Color.green);
//                        lAviso.setText("Encontrado");
//
//                        btAtualizar.setVisible(true);
//                        btRemover.setVisible(true);
//                        btAdicionar.setVisible(false);
//                    } else {
//                        btAdicionar.setVisible(true);
//                        btAtualizar.setVisible(false);
//                        btRemover.setVisible(false);
//
//                        lAviso.setBackground(Color.red);
//                        lAviso.setText("NÃ£o encontrado");
//
//                    }
//                } catch (Exception e1) {
//                    JOptionPane.showMessageDialog(null, "Erro de inserção dos dados, verifique as informações");
//                }
//
//            }
//        });
//        btAdicionar.addActionListener(
//                new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e
//            ) {
//                acao = true;
//                btBuscar.setVisible(false);
//
//                spinnerdata_nasc.setEnabled(false);
//                tfClienteCFP.requestFocus();
//
//                tfClienteCFP.setEnabled(true);
//                tfClienteCFP.setText("");
//
//                btAdicionar.setVisible(false);
//                btSalvar.setVisible(true);
//                btCancelar.setVisible(true);
//                btRemover.setVisible(false);
//                btAtualizar.setVisible(false);
//            }
//        }
//        );
//        btSalvar.addActionListener(
//                new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e
//            ) {
//                Cliente cliente = new Cliente();
//                try {
////                    não entendi aqui
////                    cliente.setDataCadastro();
////                    (Integer.valueOf(lDatacadastro.getText()));
////
////                    cliente.setClienteCFPCliente(Dependente.valueOf(tfClienteCFP.getText()));
//
//                    if (acao) {//inserir
//
//                        List<String> listaCliente = new ArrayList();
//
//                        listaCliente.add(String.valueOf(cliente.getDataCadastro()));
//                        listaCliente.add(String.valueOf(cliente.getPessoaCPF()));
//
//                        controle.inserir(cliente);
//                        lAviso.setText("Registro inserido");
//
//                    } else {//alterar
//                        Cliente x = new Cliente();
////                        aqui não entendi tb
////                        x.setDataCadastro;.
////                        getText()
////                        ));
////
////                            x = controle.obter(x.getDataCadastro());
////                        controle.atualizar(cliente);
//
//                        lAviso.setText("Registro alterado");
//                    }
//
//                    lDatacadastro.setEnabled(true);
//                    lDatacadastro.requestFocus();
////                        lDatacadastro.selectAll();
//                    btSalvar.setVisible(false);
//                    btCancelar.setVisible(false);
//                    btBuscar.setVisible(true);
//                } catch (Exception exbui) {
//                    JOptionPane.showMessageDialog(null, "Erro na inserção dos dados");
//                }
//            }
//        }
//        );
//        btCancelar.addActionListener(
//                new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e
//            ) {
//                lAviso.setText("Cancelado");
//                lDatacadastro.setEnabled(true);
//
//                lDatacadastro.requestFocus();
//
//                btSalvar.setVisible(false);
//                btCancelar.setVisible(false);
//                btBuscar.setVisible(true);
//
//                tfClienteCFP.setText("");
//
//            }
//        }
//        );
//        btAtualizar.addActionListener(
//                new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e
//            ) {
//                acao = false;
//                lDatacadastro.setEnabled(false);
//                tfClienteCFP.setEnabled(true);
//                tfClienteCFP.requestFocus();
//                btSalvar.setVisible(true);
//                btCancelar.setVisible(true);
//                btBuscar.setVisible(false);
//                btRemover.setVisible(false);
//                btAtualizar.setVisible(false);
//
//            }
//        }
//        );
//        btRemover.addActionListener(
//                new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e
//            ) {
//                btRemover.setVisible(false);
//                btAtualizar.setVisible(false);
//                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
//                        "Confirma a exclusÃ£o do registro <DATACADASTRO= " + cliente.getDataCadastro() + ">?", "Confirm",
//                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
//
//                    controle.remover(cliente);
//                    lAviso.setText("Removeu");
//                    tfClienteCFP.setText("");
//                    lDatacadastro.setEnabled(true);
//                    lDatacadastro.requestFocus();
//
//                } else {
//                    lAviso.setText("Cancelada a remoÃ§Ã£o");
//                    btRemover.setVisible(true);
//                    btAtualizar.setVisible(true);
//                }
//
//            }
//        }
//        );
//        btListar.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                ClienteGUIListagem clienteGuiListagem;
//                List<Cliente> listaCliente = controle.list();
//                for (Cliente a : listaCliente) {
//                    dados.add(a.toString());
//                }
//                clienteGuiListagem = new ClienteGUIListagem(listaCliente, 400, 400);
//
//            }
//        });
//
////        ??????????????????????????????????????????
////          tfClienteCFP.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e
////            ) {
////                List<String> listaAuxiliar = DAOPessoa.listInOrderNomeStrings("id");
////                if (listaAuxiliar.size() > 0) {
////                    String selectedItem = new JanelaPesquisar(listaAuxiliar, getBounds().x - getWidth() / 2 + getWidth() + 5,
////                            textFieldStatusIdStatus.getBounds().y + textFieldStatusIdStatus.getHeight()).getValorRetornado();
////                    if (!selectedItem.equals("")) {
////                        String[] aux = selectedItem.split("-");
////                        textFieldStatusIdStatus.setText(selectedItem);
////
////                        //preparar para salvar
////                        status = daoStatus.obter(Integer.valueOf(aux[0]));
////
////                    } else {
////                        textFieldStatusIdStatus.requestFocus();
////                        textFieldStatusIdStatus.selectAll();
////                    }
////                } else {
////                    JOptionPane.showMessageDialog(cp, "Não há nenhum produto cadastrado.");
////                }
////            }
////        });
//        addWindowListener(new WindowAdapter() {
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

import DAOs.*;
import Entidades.*;
import GUIs.ClienteGUIListagem;
import java.awt.Dimension;
import java.util.List;
import java.awt.Point;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import myUtil.JanelaPesquisar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import myUtil.UsarGridBagLayout;

public class GUICliente extends JDialog {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeNext = new ImageIcon(getClass().getResource("/icones/next.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnNext = new JButton(iconeNext);
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    private JSpinner spinnerdataCadastro = new JSpinner(new SpinnerDateModel());
    private final JSpinner.DateEditor spinnerEditordataCadastro = new JSpinner.DateEditor(spinnerdataCadastro, "dd/MM/yyyy");
    JLabel labelPessoaCPF = new JLabel("PessoaCPF");
    JTextField textFieldPessoaCPF = new JTextField(20);
    JLabel labelDataCadastro = new JLabel("Data Cadastro");
    JTextField textFielDataCadastro = new JTextField(20);
    JLabel labelPessoa = new JLabel("Pessoa");
    JTextField textFieldPessoa = new JTextField(20);

//Daos para FK
//Entidades para FK
    JPanel pnAvisos = new JPanel();
    JLabel labelAviso = new JLabel("");

    String acao = "";//variavel para facilitar insert e update
    DAOCliente daoCliente = new DAOCliente();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
    Cliente cliente;

    private void atvBotoes(boolean c, boolean r, boolean u, boolean d) {
        btnCreate.setEnabled(c);
        btnNext.setEnabled(r);
        btnRetrieve.setEnabled(r);
        btnUpdate.setEnabled(u);
        btnDelete.setEnabled(d);
        btnList.setEnabled(r);
    }

    public void mostrarBotoes(boolean visivel) {
        btnCreate.setVisible(visivel);
        btnNext.setVisible(visivel);
        btnRetrieve.setVisible(visivel);
        btnUpdate.setVisible(visivel);
        btnDelete.setVisible(visivel);
        btnList.setVisible(visivel);
        btnSave.setVisible(!visivel);
        btnCancel.setVisible(!visivel);
    }

    private void habilitarAtributos(boolean pessoaCPF, boolean DataCadastro, boolean pessoa) {
        if (pessoaCPF) {
            textFieldPessoaCPF.requestFocus();
            textFieldPessoaCPF.selectAll();
        }
        textFieldPessoaCPF.setEnabled(pessoaCPF);
        textFieldPessoaCPF.setEditable(pessoaCPF);
        textFielDataCadastro.setEditable(DataCadastro);
        textFieldPessoa.setEditable(pessoa);

    }

    public void zerarAtributos() {
        textFielDataCadastro.setText("");
        textFieldPessoa.setText("");
    }
    Color corPadrao = labelPessoaCPF.getBackground();

    public GUICliente(Point posicao, Dimension dimensao) {
        setTitle("CRUD - Cliente");
        setSize(dimensao);//tamanho da janela
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        atvBotoes(false, true, false, false);
        habilitarAtributos(true, false, false);
        btnCreate.setToolTipText("Inserir novo registro");
        btnNext.setToolTipText("Próximo novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        JToolBar Toolbar1 = new JToolBar();
        Toolbar1.add(labelPessoaCPF);
        Toolbar1.add(textFieldPessoaCPF);
        Toolbar1.add(btnRetrieve);
        Toolbar1.add(btnCreate);
        Toolbar1.add(btnNext);
        Toolbar1.add(btnUpdate);
        Toolbar1.add(btnDelete);
        Toolbar1.add(btnSave);
        Toolbar1.add(btnCancel);
        Toolbar1.add(btnList);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);

//atritubos não chave, todos no painel centro
        JPanel centro = new JPanel();
        UsarGridBagLayout usarGridBagLayout = new UsarGridBagLayout(centro);
        usarGridBagLayout.add(labelDataCadastro, textFielDataCadastro, corPadrao);
//       JPanel centro.add(spinnerdataCadastro);
        
        usarGridBagLayout.add(labelPessoa, textFieldPessoa, Color.yellow);
        pnAvisos.add(labelAviso);
        pnAvisos.setBackground(Color.yellow);
        cp.add(Toolbar1, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(pnAvisos, BorderLayout.SOUTH);

        textFieldPessoaCPF.requestFocus();
        textFieldPessoaCPF.selectAll();
        textFieldPessoaCPF.setBackground(Color.GREEN);
        labelAviso.setText("Digite um PessoaCPF e clic [Pesquisar]");

//--------------- listeners ----------------- 
        textFieldPessoaCPF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRetrieve.doClick();
            }
        });

//-----------------------------  btnRetrieve ------------------------------------------
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cliente = new Cliente();
                cliente=daoCliente.obter(Integer.valueOf(textFieldPessoaCPF.getText()));
                textFieldPessoaCPF.setText(textFieldPessoaCPF.getText().trim());
                System.out.println(cliente.getDataCadastro());
//caso tenham sido digitados espaços
               textFielDataCadastro.setText(sdf.format(cliente.getDataCadastro()));
                if (textFieldPessoaCPF.getText().equals("")) {
                    List<String> listaAuxiliar = daoCliente.listInOrderNomeStrings("id");
                    if (listaAuxiliar.size() > 0) {
                        Point lc = btnRetrieve.getLocationOnScreen();
                        lc.x = lc.x + btnRetrieve.getWidth();
                        String selectedItem = new JanelaPesquisar(listaAuxiliar,
                                lc.x,
                                lc.y).getValorRetornado();
                        if (!selectedItem.equals("")) {
                            String[] aux = selectedItem.split("-");
                            textFieldPessoaCPF.setText(aux[0]);
                            btnRetrieve.doClick();
                        } else {
                            textFieldPessoaCPF.requestFocus();
                            textFieldPessoaCPF.selectAll();
                        }
                    }

                    textFieldPessoaCPF.requestFocus();
                    textFieldPessoaCPF.selectAll();
                } else {
                    try {
                        cliente.setPessoaCPF(Integer.valueOf(textFieldPessoaCPF.getText()));
                        cliente = daoCliente.obter(cliente.getPessoaCPF());
                        if (cliente != null) { //se encontrou na lista
                            textFielDataCadastro.setText(sdf.format(cliente.getDataCadastro()));
                            textFieldPessoa.setText(String.valueOf(cliente.getPessoa() + "-"
                                    + cliente.getPessoa().getNome()));
                            atvBotoes(false, true, true, true);
                            habilitarAtributos(true, false, false);
                            labelAviso.setText("Encontrou - clic [Pesquisar], [Alterar] ou [Excluir]");
                            acao = "encontrou";
                        } else {
                            atvBotoes(true, true, false, false);
                            zerarAtributos();
                            labelAviso.setText("Não cadastrado - clic [Inserir] ou digite outra id [Pesquisar]");
                        }
                        textFieldPessoaCPF.setBackground(Color.green);
                        
                    } catch (Exception x) {
                        textFieldPessoaCPF.setOpaque(true);
                        textFieldPessoaCPF.selectAll();
                        textFieldPessoaCPF.requestFocus();
                        textFieldPessoaCPF.setBackground(Color.red);
                        labelAviso.setText("Tipo errado - " + x.getMessage());
                    }
                }
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos();
              
                habilitarAtributos(false, true, true);
                textFielDataCadastro.requestFocus();
                mostrarBotoes(false);
                labelAviso.setText("Preencha os campos e clic [Salvar] ou clic [Cancelar]");
                acao = "insert";
            }
        });

        // ---------------------- botao next ------------------------------
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int prox = daoCliente.autoPessoaCPF();
                textFieldPessoaCPF.setText(String.valueOf(prox));
                btnRetrieve.doClick();
                btnCreate.doClick();
            }
        });

//-----------------------------  SAVE ------------------------------------------
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean deuRuim = false;
                if (acao.equals("insert")) {
                    cliente = new Cliente();
                }
                try {
                    cliente.setPessoaCPF(Integer.valueOf((textFieldPessoaCPF.getText())));
                } catch (Exception erro2) {
                    deuRuim = true;
                    textFieldPessoaCPF.setBackground(Color.red);
                }
                try {
                    String valor = textFielDataCadastro.getText();
                    valor = valor.replace(".", "");
                    valor = valor.replace(",", ".");
                    textFielDataCadastro.setText(valor);
                    
                    cliente.setDataCadastro(sdf.parse((textFielDataCadastro.getText()))
                 );
                } catch (Exception erro3) {
                    deuRuim = true;
                    textFielDataCadastro.setBackground(Color.red);
                }
                if (!deuRuim) {
                    if (acao.equals("insert")) {
                        daoCliente.inserir(cliente);
                        labelAviso.setText("Registro inserido.");
                    } else {
                       daoCliente.atualizar(cliente);
                        labelAviso.setText("Registro alterado.");
                    }
                    habilitarAtributos(true, false, false);
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                }//!deu ruim
                else {
                    labelAviso.setText("Erro nos dados - corrija");
                    labelAviso.setBackground(Color.red);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos();
                atvBotoes(false, true, false, false);
                habilitarAtributos(true, false, false);
                mostrarBotoes(true);
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                acao = "list";
                ClienteGUIListagem guiClienteListagem = new ClienteGUIListagem(daoCliente.listInOrderNome(), getBounds().x, getBounds().y, dimensao);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "update";
                mostrarBotoes(false);
                habilitarAtributos(false, true, true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + cliente.getDataCadastro() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");
                    daoCliente.remover(cliente);
                    spinnerdataCadastro.setEnabled(true);
                    zerarAtributos();
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                    textFielDataCadastro.requestFocus();
                    textFielDataCadastro.selectAll();
                }
            }
        });

        // ----------------   Janela Pesquisar para FKs -----------------
        textFieldPessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldPessoa.getText().equals("")) {
                    DAOPessoa daoPessoa = new DAOPessoa();
                    List<String> listaAuxiliar = daoPessoa.listInOrderNomeStrings("id");
                    if (listaAuxiliar.size() > 0) {
                        Point lc = textFieldPessoa.getLocationOnScreen();
                        lc.x = lc.x + textFieldPessoa.getWidth();
                        String selectedItem = new JanelaPesquisar(listaAuxiliar,
                                lc.x,
                                lc.y).getValorRetornado();
                        if (!selectedItem.equals("")) {
                            String[] aux = selectedItem.split("-");
                            textFieldPessoa.setText(aux[0]);

                        }
                    }
                }

            }
        });

        textFielDataCadastro.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFielDataCadastro.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFielDataCadastro.setBackground(corPadrao);
            }
        });
        textFieldPessoa.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldPessoa.setBackground(Color.orange);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldPessoa.setBackground(Color.yellow);
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //antes de sair do sistema, grava os dados da lista em disco
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Sai   
                dispose();
            }
        });

        pack();
        setModal(true);
        setLocation(posicao);
        setVisible(true);//faz a janela ficar visível  
    }

    public static void main(String[] args) {
        new GUICliente(new Point(880, 250), new Dimension(800, 600));
    }
}
