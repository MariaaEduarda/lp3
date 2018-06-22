package GUIs;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import java.io.File;
import javax.swing.text.JTextComponent;
import Auxiliar.*;
import DAOs.*;
import Entidades.*;

public class GUIPessoa extends JFrame {

    public static void main(String[] args) {
        new GUIPessoa();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("cpf: ");
    private JLabel lbCPF = new JLabel("cpf");
    private JTextField fdCPF = new JTextField(10);

    private JLabel lbRG = new JLabel("RG");
    private JTextField fdRG = new JTextField(10);

    private JLabel lbNome = new JLabel("Nome");
    private JTextField fdNome = new JTextField(10);

    private JLabel lbCelular = new JLabel("Celular");
    private JTextField fdCelular = new JTextField(10);

    private JLabel lbTetefone = new JLabel("telefone");
    private JTextField fdTetefone = new JTextField(20);

    private JLabel lbEmail = new JLabel("email");
    private JTextField fdEmail = new JTextField(40);

    JLabel lbsexo = new JLabel("sexo");
    JPanel pnSexo = new JPanel();
    JCheckBox checkMASC = new JCheckBox("MASC");
    JCheckBox checkFEM = new JCheckBox("FEM");
    private JSpinner spinnerdata_nasc = new JSpinner(new SpinnerDateModel());
    private final JSpinner.DateEditor spinnerEditordata_nasc = new JSpinner.DateEditor(spinnerdata_nasc, "dd/MM/yyyy");
    private JLabel lbData_nasc = new JLabel("Data_nascimento");
    private JLabel lbEndereco = new JLabel("endereco");
    private JTextField fdEndereco = new JTextField(30);

    private JLabel lbEstado_civil = new JLabel("estado_civil");
    private JTextField fdEstado_civil = new JTextField(20);

    JPanel painelImagem = new JPanel(new GridLayout(1, 1));
    Image img;
    Image imagemAux;
    String origem;
    String destino = "src/fotos/";
    String semImagem = "src/fotos/0.png";
    String escolherImagem = "src/fotos/0a.png";
    JLabel labelFoto = new JLabel("");
    Boolean uploadFoto = false;

    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
    private JPanel painelNorteCima = new JPanel();
    private JPanel painelNorteBaixo = new JPanel();
    private JPanel painelCentralFora = new JPanel(new BorderLayout());
    private JPanel painelCentral = new JPanel();
    private JPanel painelSul = new JPanel();
    private JLabel labelBranco = new JLabel();

    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));

    DAOPessoa daoPessoa = new DAOPessoa();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Pessoa pessoa = new Pessoa();

    public GUIPessoa() {
        setSize(725, 620);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Pessoas");

        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }

        painelCentral.setLayout(new GridLayout(10, 2));
        painelCentral.add(lbRG);
        painelCentral.add(fdRG);
        painelCentral.add(lbNome);
        painelCentral.add(fdNome);
        painelCentral.add(lbCelular);
        painelCentral.add(fdCelular);
        painelCentral.add(lbTetefone);
        painelCentral.add(fdTetefone);
        painelCentral.add(lbEmail);
        painelCentral.add(fdEmail);
        painelCentral.add(lbEndereco);
        painelCentral.add(fdEndereco);
        painelCentral.add(lbEstado_civil);
        painelCentral.add(fdEstado_civil);

        fdRG.setEnabled(false);
        fdNome.setEnabled(false);
        fdCelular.setEnabled(false);
        fdTetefone.setEnabled(false);
        fdEmail.setEnabled(false);
        fdEndereco.setEnabled(false);
        fdEstado_civil.setEnabled(false);

        painelCentral.add(lbData_nasc);
        painelCentral.add(spinnerdata_nasc);
        spinnerdata_nasc.setEditor(spinnerEditordata_nasc);
        spinnerdata_nasc.setEnabled(false);
        painelCentral.add(lbsexo);
        pnSexo.add(checkMASC);
        checkMASC.setEnabled(false);
        pnSexo.add(checkFEM);
        checkFEM.setEnabled(false);
        painelCentral.add(pnSexo);
        List<String> combo = new ArrayList<>();

        cp.setBackground(Color.white);
        painelImagem.setBackground(Color.white);
        painelImagem.add(labelFoto);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.WEST);
        cp.add(painelImagem, BorderLayout.EAST);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdCPF);
        painelNorteBaixo.add(btBuscar);
        painelNorteBaixo.add(btInserir);
        painelNorteBaixo.add(btAtualizar);
        painelNorteBaixo.add(btRemover);
        painelNorteBaixo.add(btSalvar);
        painelNorteBaixo.add(btCancelar);
        painelNorteBaixo.add(btListar);
        painelNorteCima.setBackground(Color.white);
        painelNorteBaixo.setBackground(Color.white);
        painelCentralFora.setBackground(Color.white);
        painelCentral.setBackground(Color.white);
        painelSul.setBackground(Color.white);
        btInserir.setBackground(Color.WHITE);
        btSalvar.setBackground(Color.WHITE);
        btRemover.setBackground(Color.WHITE);
        btAtualizar.setBackground(Color.WHITE);
        btBuscar.setBackground(Color.WHITE);
        btCancelar.setBackground(Color.WHITE);
        btListar.setBackground(Color.WHITE);
        pnSexo.setBackground(Color.WHITE);
        checkMASC.setBackground(Color.WHITE);
        checkFEM.setBackground(Color.WHITE);

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdCPF.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbCPF.setFont(new Font("Courier New", Font.BOLD, 17));
        lbRG.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNome.setFont(new Font("Courier New", Font.BOLD, 17));
        lbCelular.setFont(new Font("Courier New", Font.BOLD, 17));
        lbTetefone.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEmail.setFont(new Font("Courier New", Font.BOLD, 17));
        lbsexo.setFont(new Font("Courier New", Font.BOLD, 17));
        lbData_nasc.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEstado_civil.setFont(new Font("Courier New", Font.BOLD, 17));
        fdCPF.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdRG.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNome.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdCelular.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdTetefone.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEmail.setFont(new Font("Courier New", Font.PLAIN, 17));
        checkMASC.setFont(new Font("Courier New", Font.PLAIN, 17));
        checkFEM.setFont(new Font("Courier New", Font.PLAIN, 17));
        spinnerdata_nasc.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEndereco.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEstado_civil.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btInserir.setVisible(false);
        btAtualizar.setVisible(false);
        btRemover.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);

        painelSul.add(labelAviso);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadFoto = false;

                try {
                    pessoa = new Pessoa();
                    System.out.println("cpf " + fdCPF.getText());
                    pessoa.setCpf(Integer.valueOf(fdCPF.getText()));
                    pessoa = daoPessoa.obter(pessoa.getCpf());
                    labelAviso.setBackground(Color.green);
                    if (pessoa != null) {
                        fdCPF.setText(pessoa.getCpf() + "");
                        fdRG.setText(pessoa.getRg() + "");
                        fdNome.setText(pessoa.getNome() + "");
                        fdCelular.setText(pessoa.getCelular() + "");
                        fdTetefone.setText(pessoa.getTelefone() + "");
                        fdEmail.setText(pessoa.getEmail() + "");
                        if (pessoa.getSexo() == 1) { //na entidade ta como short
                            checkMASC.setSelected(true);
                            checkFEM.setSelected(false);
                        } else {
                            checkFEM.setSelected(true);
                            checkMASC.setSelected(false);
                        }
                        spinnerdata_nasc.setValue(pessoa.getDataNasc());
                        fdEndereco.setText(pessoa.getEndereco() + "");
                        fdEstado_civil.setText(pessoa.getEstadoCivil() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");

                        labelAviso.setBackground(Color.green);
                        try {
                            String aux = String.valueOf(pessoa.getCpf()).trim();
                            origem = "/fotos/" + aux + ".png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));

                            labelFoto.setIcon(icone);

                        } catch (Exception erro) {
                            origem = "/fotos/0.png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);
                        }
                    } else {
                        try {
                            origem = "/fotos/0.png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);

                        } catch (Exception erro) {
                            System.out.println("erro ao carregar a imagem");

                        }
                        fdRG.setEnabled(false);
                        fdRG.setText(null);
                        fdNome.setEnabled(false);
                        fdNome.setText(null);
                        fdCelular.setEnabled(false);
                        fdCelular.setText(null);
                        fdTetefone.setEnabled(false);
                        fdTetefone.setText(null);
                        fdEmail.setEnabled(false);
                        fdEmail.setText(null);
                        fdEndereco.setEnabled(false);
                        fdEndereco.setText(null);
                        fdEstado_civil.setEnabled(false);
                        fdEstado_civil.setText(null);
                        checkMASC.setEnabled(false);
                        checkFEM.setEnabled(false);
                        checkMASC.setSelected(false);
                        checkFEM.setSelected(false);
                        spinnerdata_nasc.setEnabled(false);
                        spinnerdata_nasc.setValue(new Date());
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
                        btInserir.setVisible(true);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);
                        btListar.setVisible(false);
                        try {
                            origem = "/fotos/0.png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);

                        } catch (Exception erro) {
                            System.out.println("erro ao carregar a imagem");
                        }
                    }
                } catch (Exception erro) {
                    labelAviso.setText("Preencha os campos corretamente!" + erro.getMessage());
                    labelAviso.setBackground(Color.red);

                }
            }
        }
        );

        btInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = true;
                try {
                    origem = "/fotos/0a.png";
                    ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                    imagemAux = icone.getImage();
                    icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                    labelFoto.setIcon(icone);

                } catch (Exception erro) {
                    System.out.println("erro ao carregar a imagem");
                }
                fdCPF.setEnabled(false);
                fdRG.setEnabled(true);
                fdNome.setEnabled(true);
                fdCelular.setEnabled(true);
                fdTetefone.setEnabled(true);
                fdEmail.setEnabled(true);
                checkMASC.setEnabled(true);
                checkFEM.setEnabled(true);
                spinnerdata_nasc.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdEstado_civil.setEnabled(true);
                uploadFoto = true;
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btInserir.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadFoto = false;
                if (acao) { //btInserir
                    try {
                        pessoa = new Pessoa();
                        pessoa.setCpf(Integer.valueOf(fdCPF.getText()));
                        pessoa.setRg(fdRG.getText());
                        pessoa.setNome(String.valueOf(fdNome.getText()));
                        pessoa.setCelular(fdCelular.getText());
                        pessoa.setTelefone(fdTetefone.getText());
                        pessoa.setEmail(fdEmail.getText());
                        Boolean respSexo = null;
                        if (checkMASC.isSelected()) {
                            respSexo = true;
                        } else if (checkFEM.isSelected()) {
                            respSexo = false;
                        } else {
                            int a = 1 / 0;
                        }
                        pessoa.setSexo(respSexo ? Short.valueOf("1") : Short.valueOf("0"));
                        pessoa.setDataNasc((Date) spinnerdata_nasc.getValue());
                        pessoa.setEndereco(fdEndereco.getText());
                        pessoa.setEstadoCivil(fdEstado_civil.getText());
                        daoPessoa.inserir(pessoa);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdCPF.setEnabled(true);
                        fdCPF.requestFocus();
                        fdRG.setEnabled(false);
                        fdNome.setEnabled(false);
                        fdCelular.setEnabled(false);
                        fdTetefone.setEnabled(false);
                        fdEmail.setEnabled(false);
                        checkMASC.setEnabled(false);
                        checkFEM.setEnabled(false);
                        spinnerdata_nasc.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdEstado_civil.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        pessoa = new Pessoa();
                        pessoa.setCpf(Integer.valueOf(fdCPF.getText()));
                        pessoa.setRg(fdRG.getText());
                        pessoa.setNome(String.valueOf(fdNome.getText()));
                        pessoa.setCelular(fdCelular.getText());
                        pessoa.setTelefone(fdTetefone.getText());
                        pessoa.setEmail(fdEmail.getText());
                        Boolean respSexo = null;
                        if (checkMASC.isSelected()) {
                            respSexo = true;
                        } else {
                            respSexo = false;
                        }
                        pessoa.setSexo(respSexo ? Short.valueOf("0") : Short.valueOf("1"));
                        pessoa.setDataNasc((Date) spinnerdata_nasc.getValue());
                        pessoa.setEndereco(fdEndereco.getText());
                        pessoa.setEstadoCivil(fdEstado_civil.getText());
                        daoPessoa.atualizar(pessoa);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdCPF.setEnabled(true);
                        fdCPF.requestFocus();
                        fdRG.setEnabled(false);
                        fdNome.setEnabled(false);
                        fdCelular.setEnabled(false);
                        fdTetefone.setEnabled(false);
                        fdEmail.setEnabled(false);
                        checkMASC.setEnabled(false);
                        checkFEM.setEnabled(false);
                        spinnerdata_nasc.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdEstado_civil.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
                destino = destino + pessoa.getCpf() + ".png";
                CopiaImagem.copiar(origem, destino);
                destino = "src/fotos/";
            }
        }
        );

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    origem = "/fotos/0.png";
                    ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                    imagemAux = icone.getImage();
                    icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                    labelFoto.setIcon(icone);

                } catch (Exception erro) {
                    System.out.println("erro ao carregar a imagem");
                }
                labelAviso.setText("Cancelado!");
                fdCPF.setEnabled(false);
                fdCPF.setText("");
                fdRG.setEnabled(false);
                fdRG.setText("");
                fdNome.setEnabled(false);
                fdNome.setText("");
                fdCelular.setEnabled(false);
                fdCelular.setText("");
                fdTetefone.setEnabled(false);
                fdTetefone.setText("");
                fdEmail.setEnabled(false);
                fdEmail.setText("");
                checkMASC.setEnabled(false);
                checkMASC.setSelected(false);
                checkFEM.setEnabled(false);
                checkFEM.setSelected(false);
                spinnerdata_nasc.setEnabled(false);
                spinnerdata_nasc.setValue(new Date());
                fdEndereco.setEnabled(false);
                fdEndereco.setText("");
                fdEstado_civil.setEnabled(false);
                fdEstado_civil.setText("");
                fdCPF.setEnabled(true);
                fdCPF.requestFocus();
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
            }
        }
        );

        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadFoto = false;
                acao = false;
                fdRG.setEnabled(true);
                fdNome.setEnabled(true);
                fdCelular.setEnabled(true);
                fdTetefone.setEnabled(true);
                fdEmail.setEnabled(true);
                checkMASC.setEnabled(true);
                checkFEM.setEnabled(true);
                spinnerdata_nasc.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdEstado_civil.setEnabled(true);
                fdRG.requestFocus();
                fdCPF.setEnabled(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btRemover.setVisible(false);
                btAtualizar.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btRemover.setVisible(false);
                btListar.setVisible(false);
                btAtualizar.setVisible(false);
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + pessoa.getCpf() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoPessoa.remover(pessoa);
                    labelAviso.setText("Removido!");
                    fdCPF.setText("");
                    fdRG.setText("");
                    fdRG.setEnabled(false);
                    fdNome.setText("");
                    fdNome.setEnabled(false);
                    fdCelular.setText("");
                    fdCelular.setEnabled(false);
                    fdTetefone.setText("");
                    fdTetefone.setEnabled(false);
                    fdEmail.setText("");
                    fdEmail.setEnabled(false);
                    checkMASC.setEnabled(false);
                    checkMASC.setSelected(false);
                    checkFEM.setEnabled(false);
                    checkFEM.setSelected(false);
                    spinnerdata_nasc.setEnabled(false);
                    spinnerdata_nasc.setValue(new Date());
                    fdEndereco.setText("");
                    fdEndereco.setEnabled(false);
                    fdEstado_civil.setText("");
                    fdEstado_civil.setEnabled(false);
                    String aux = String.valueOf(pessoa.getCpf()).trim();
                    origem = "src/fotos/" + aux + ".png";
                    System.out.println(origem);
                    try {
                        File f = new File(origem);
                        if (f.exists()) {
                            f.delete();
                        }
                    } catch (Exception erro) {
                        System.out.println("Erro");
                    }
                    btListar.setVisible(true);
                } else {
                    labelAviso.setText("Remoção cancelada!");
                    btAtualizar.setVisible(true);
                    btRemover.setVisible(true);
                }
            }
        }
        );

        labelFoto.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (uploadFoto) {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                        File img = fc.getSelectedFile();
                        origem = fc.getSelectedFile().getAbsolutePath();
                        try {
                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);

                        } catch (Exception ex) {
                            System.out.println("Erro: " + ex.getMessage());
                        }
                    }

                }

            }
        });

        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PessoaGUIListagem(daoPessoa.listInOrderNomeStrings("tanto faz"), cp);
            }
        }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        
    }
    
}
