package GUIs;

//package GUIs;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import javax.swing.*;
//import java.io.File;
//import javax.swing.text.JTextComponent;
//import Auxiliar.*;
//import DAOs.*;
//import Entidades.*;
//
//public class GUIFuncionario extends JFrame {
//
//    public static void main(String[] args) {
//        new GUIFuncionario();
//    }
//    private Container cp;
//    private JLabel labelAviso = new JLabel("Avisos");
//    private JLabel labelTitulo = new JLabel("Cadastro Funcionário ");
//    private JLabel lbFuncionario_cpf = new JLabel("CPF");
//    private List<String> stringFuncionario_cpf = new ArrayList<>();
//    private JComboBox comboFuncionario_cpf = new JComboBox();
//    private JLabel lbSenha_usuario = new JLabel("senha");
//    private JTextField fdSenha_usuario = new JTextField(20);
//
//    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
//    private JPanel painelNorteCima = new JPanel();
//    private JPanel painelNorteBaixo = new JPanel();
//    private JPanel painelCentralFora = new JPanel(new BorderLayout());
//    private JPanel painelCentral = new JPanel();
//    private JPanel painelSul = new JPanel();
//    private JLabel labelBranco = new JLabel();
//
//    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
//    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
//    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
//    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
//    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
//    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
//    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));
//
//    DAOFuncionario controle = new DAOFuncionario();
//    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
//    Boolean acao;
//    Font fonte = new Font("Courier New", Font.BOLD, 20);
//    Font fonteL = new Font("Courier New", Font.PLAIN, 14);
//
//    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    JTextComponent editor = (JTextComponent) comboFuncionario_cpf.getEditor().getEditorComponent();
//
//    Funcionario Funcionario = new Funcionario();
//
//    public GUIFuncionario() {
//        setSize(725, 340);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//        setTitle("Cadastro de Funcionarios");
//
//        painelCentral.setLayout(new GridLayout(2, 2));
//
//        fdSenha_usuario.setEnabled(false);
//
//        List<String> combo = new ArrayList<>();
//        combo = new ManipulaArquivo().abrirArquivo("C:\\Users\\Maggie\\Desktop\\Pesoa.txt");
//        for (int x = 0; x < combo.size(); x++) {
//            stringFuncionario_cpf.add(combo.get(x).split(";")[0]);
//        }
//        comboFuncionario_cpf = new JComboBox(stringFuncionario_cpf.toArray());
//        painelCentral.add(lbFuncionario_cpf);
//        painelCentral.add(comboFuncionario_cpf);
//        comboFuncionario_cpf.setEnabled(false);
//        editor.setDocument(new SearchableComboBox(comboFuncionario_cpf));
//
//        cp.setBackground(Color.white);
//        cp.add(painelNortes, BorderLayout.NORTH);
//        cp.add(painelCentralFora, BorderLayout.CENTER);
//        cp.add(painelSul, BorderLayout.SOUTH);
//
//        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
//        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
//        painelNortes.add(painelNorteCima);
//        painelNortes.add(painelNorteBaixo);
//        painelNorteCima.add(labelTitulo);
//        painelNorteCima.add(lbFuncionario_cpf);
//        painelNorteCima.add(comboFuncionario_cpf);
//       
//        painelNorteBaixo.add(btBuscar);
//        painelNorteBaixo.add(btInserir);
//        painelNorteBaixo.add(btAtualizar);
//        painelNorteBaixo.add(btRemover);
//        painelNorteBaixo.add(btSalvar);
//        painelNorteBaixo.add(btCancelar);
//        painelNorteBaixo.add(btListar);
//        painelNorteCima.setBackground(Color.white);
//        painelNorteBaixo.setBackground(Color.white);
//        painelCentralFora.setBackground(Color.white);
//        painelCentral.setBackground(Color.white);
//        painelSul.setBackground(Color.white);
//        btInserir.setBackground(Color.WHITE);
//        btSalvar.setBackground(Color.WHITE);
//        btRemover.setBackground(Color.WHITE);
//        btAtualizar.setBackground(Color.WHITE);
//        btBuscar.setBackground(Color.WHITE);
//        btCancelar.setBackground(Color.WHITE);
//        btListar.setBackground(Color.WHITE);
//
//        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
//        lbFuncionario_cpf.setFont(new Font("Courier New", Font.PLAIN, 20));
//        lbFuncionario_cpf.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbSenha_usuario.setFont(new Font("Courier New", Font.BOLD, 17));
//        comboFuncionario_cpf.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdSenha_usuario.setFont(new Font("Courier New", Font.PLAIN, 17));
//        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
//        btInserir.setVisible(false);
//        btAtualizar.setVisible(false);
//        btRemover.setVisible(false);
//        btSalvar.setVisible(false);
//        btCancelar.setVisible(false);
//
//        painelSul.add(labelAviso);
//
//        btBuscar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Funcionario = new Funcionario();
//                    Funcionario = controle.obter(Funcionario.getPessoaCPF());
//                    labelAviso.setBackground(Color.green);
//                    if (Funcionario != null) {
//                        comboFuncionario_cpf.setSelectedItem(Funcionario.getPessoaCPF().toString());
//                        fdSenha_usuario.setText(Funcionario.getSenha() + "");
//                        btAtualizar.setVisible(true);
//                        btRemover.setVisible(true);
//                        btInserir.setVisible(false);
//                        btListar.setVisible(false);
//                        labelAviso.setText("Encontrado na lista!");
//                        labelAviso.setBackground(Color.green);
//                    } else {
//                        fdSenha_usuario.setEnabled(false);
//                        fdSenha_usuario.setText(null);
//                        comboFuncionario_cpf.setEnabled(false);
//                        comboFuncionario_cpf.setSelectedIndex(0);
//                        labelAviso.setText("Não encontrado!");
//                        labelAviso.setBackground(Color.red);
//                        btInserir.setVisible(true);
//                        btAtualizar.setVisible(false);
//                        btRemover.setVisible(false);
//                        btListar.setVisible(false);
//                    }
//                } catch (Exception erro) {
//                    labelAviso.setText("Preencha os campos corretamente!");
//                    labelAviso.setBackground(Color.red);
//                }
//            }
//        }
//        );
//
//        btInserir.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                acao = true;
//                lbFuncionario_cpf.setEnabled(false);
//                comboFuncionario_cpf.setEnabled(true);
//                fdSenha_usuario.setEnabled(true);
//                btSalvar.setVisible(true);
//                btCancelar.setVisible(true);
//                btBuscar.setVisible(false);
//                btInserir.setVisible(false);
//                btListar.setVisible(false);
//            }
//        }
//        );
//
//        btSalvar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (acao) { //btInserir
//                    try {
//                        Funcionario = new Funcionario();
//                        Funcionario.setPessoaCPF(Integer.valueOf(comboFuncionario_cpf.getSelectedItem().toString()));
//                        Funcionario.setSenha(fdSenha_usuario.getText());
//                        controle.inserir(Funcionario);
//                        labelAviso.setText("Registro inserido com sucesso!");
//                        lbFuncionario_cpf.setEnabled(true);
//                        lbFuncionario_cpf.requestFocus();
//                        comboFuncionario_cpf.setEnabled(false);
//                        fdSenha_usuario.setEnabled(false);
//                        btSalvar.setVisible(false);
//                        btCancelar.setVisible(false);
//                        btBuscar.setVisible(true);
//                        btListar.setVisible(true);
//                    } catch (Exception erro) {
//                        labelAviso.setText("Erro nos dados!");
//                    }
//                } else { //btAlterar
//                    try {
//                        Funcionario = new Funcionario();
//                        Funcionario.setPessoaCPF(Integer.valueOf(comboFuncionario_cpf.getSelectedItem().toString()));
//                        Funcionario.setSenha(fdSenha_usuario.getText());
//                        controle.atualizar(Funcionario);
//                        labelAviso.setText("Registro alterado com sucesso!");
//                        lbFuncionario_cpf.setEnabled(true);
//                        lbFuncionario_cpf.requestFocus();
//                        comboFuncionario_cpf.setEnabled(false);
//                        fdSenha_usuario.setEnabled(false);
//                        btSalvar.setVisible(false);
//                        btCancelar.setVisible(false);
//                        btBuscar.setVisible(true);
//                        btListar.setVisible(true);
//                    } catch (Exception erro) {
//                        labelAviso.setText("Erro nos dados!");
//                    }
//                }
//            }
//        }
//        );
//
//        btCancelar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                labelAviso.setText("Cancelado!");
//                comboFuncionario_cpf.setEnabled(false);
//                comboFuncionario_cpf.setSelectedIndex(0);
//                fdSenha_usuario.setEnabled(false);
//                fdSenha_usuario.setText("");
//                lbFuncionario_cpf.setEnabled(true);
//                lbFuncionario_cpf.requestFocus();
//                btSalvar.setVisible(false);
//                btCancelar.setVisible(false);
//                btBuscar.setVisible(true);
//                btListar.setVisible(true);
//            }
//        }
//        );
//
//        btAtualizar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                acao = false;
//                comboFuncionario_cpf.setEnabled(true);
//                fdSenha_usuario.setEnabled(true);
//                lbFuncionario_cpf.setEnabled(false);
//                btSalvar.setVisible(true);
//                btCancelar.setVisible(true);
//                btBuscar.setVisible(false);
//                btRemover.setVisible(false);
//                btAtualizar.setVisible(false);
//                btListar.setVisible(false);
//            }
//        }
//        );
//
//        btRemover.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                btRemover.setVisible(false);
//                btListar.setVisible(false);
//                btAtualizar.setVisible(false);
//                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + Funcionario.getPessoaCPF() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
//                    controle.remover(Funcionario);
//                    labelAviso.setText("Removido!");
//                    comboFuncionario_cpf.setEnabled(false);
//                    comboFuncionario_cpf.setSelectedIndex(0);
//                    fdSenha_usuario.setText("");
//                    fdSenha_usuario.setEnabled(false);
//                    btListar.setVisible(true);
//                } else {
//                    labelAviso.setText("Remoção cancelada!");
//                    btAtualizar.setVisible(true);
//                    btRemover.setVisible(true);
//                }
//            }
//        }
//        );
//
//        btListar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new funcionarioGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
//            }
//        }
//        );
//
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                dispose();
//            }
//        }
//        );
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//}


import DAOs.*;
import Entidades.*;
import GUIs.funcionarioGUIListagem;
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

import myUtil.UsarGridBagLayout;

public class GUIFuncionario extends JDialog {

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

    JLabel labelPessoaCPF = new JLabel("PessoaCPF");
    JTextField textFieldPessoaCPF = new JTextField(20);
    JLabel labelSenha = new JLabel("Senha");
    JTextField textFieldSenha = new JTextField(20);
    JLabel labelPessoa = new JLabel("Pessoa");
    JTextField textFieldPessoa = new JTextField(20);

//Daos para FK
//Entidades para FK
    JPanel pnAvisos = new JPanel();
    JLabel labelAviso = new JLabel("");

    String acao = "";//variavel para facilitar insert e update
    DAOFuncionario daoFuncionario = new DAOFuncionario();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
    Funcionario funcionario;

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

    private void habilitarAtributos(boolean pessoaCPF, boolean senha, boolean pessoa) {
        if (pessoaCPF) {
            textFieldPessoaCPF.requestFocus();
            textFieldPessoaCPF.selectAll();
        }
        textFieldPessoaCPF.setEnabled(pessoaCPF);
        textFieldPessoaCPF.setEditable(pessoaCPF);
        textFieldSenha.setEditable(senha);
        textFieldPessoa.setEditable(pessoa);

    }

    public void zerarAtributos() {
        textFieldSenha.setText("");
        textFieldPessoa.setText("");
    }
    Color corPadrao = labelPessoaCPF.getBackground();

    public GUIFuncionario(Point posicao, Dimension dimensao) {
        setTitle("CRUD - Funcionario");
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
        usarGridBagLayout.add(labelSenha, textFieldSenha, corPadrao);
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
                funcionario = new Funcionario();
                textFieldPessoaCPF.setText(textFieldPessoaCPF.getText().trim());//caso tenham sido digitados espaços

                if (textFieldPessoaCPF.getText().equals("")) {
                    List<String> listaAuxiliar = daoFuncionario.listInOrderNomeStrings("id");
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
                        funcionario.setPessoaCPF(Integer.valueOf(textFieldPessoaCPF.getText()));
                        funcionario = daoFuncionario.obter(funcionario.getPessoaCPF());
                        if (funcionario != null) { //se encontrou na lista
                            textFieldSenha.setText((funcionario.getSenha()));
                            textFieldPessoa.setText(String.valueOf(funcionario.getPessoa().getCpf()+ "-"
                                    + funcionario.getPessoa().getNome()));
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
                textFieldSenha.requestFocus();
                mostrarBotoes(false);
                labelAviso.setText("Preencha os campos e clic [Salvar] ou clic [Cancelar]");
                acao = "insert";
            }
        });

        // ---------------------- botao next ------------------------------
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int prox = daoFuncionario.autoPessoaCPF();
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
                    funcionario = new Funcionario();
                }
                try {
                    funcionario.setPessoaCPF(Integer.valueOf((textFieldPessoaCPF.getText())));
                } catch (Exception erro2) {
                    deuRuim = true;
                    textFieldPessoaCPF.setBackground(Color.red);
                }
                try {
                    String valor = textFieldSenha.getText();
                    valor = valor.replace(".", "");
                    valor = valor.replace(",", ".");
                    textFieldSenha.setText(valor);
                    funcionario.setSenha(String.valueOf((textFieldSenha.getText())));
                } catch (Exception erro3) {
                    deuRuim = true;
                    textFieldSenha.setBackground(Color.red);
                }
                if (!deuRuim) {
                    if (acao.equals("insert")) {
                        daoFuncionario.inserir(funcionario);
                        labelAviso.setText("Registro inserido.");
                    } else {
                        daoFuncionario.atualizar(funcionario);
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
                funcionarioGUIListagem guiFuncionarioListagem = new funcionarioGUIListagem(daoFuncionario.listInOrderNome(), getBounds().x, getBounds().y, dimensao);
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
                        "Confirma a exclusão do registro <ID = " + funcionario.getSenha()+ ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");
                    daoFuncionario.remover(funcionario);
                    zerarAtributos();
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                    textFieldSenha.requestFocus();
                    textFieldSenha.selectAll();
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

        textFieldSenha.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldSenha.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldSenha.setBackground(corPadrao);
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
        new GUIFuncionario(new Point(880, 250), new Dimension(800, 600));
    }
}
