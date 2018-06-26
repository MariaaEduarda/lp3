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
//public class GUIPessoa extends JFrame {
//    public static void main(String[] args) {
//        new GUIPessoa();
//    }
//    private Container cp;
//    private JLabel labelAviso = new JLabel("Avisos");
//    private JLabel labelTitulo = new JLabel("CPF: ");
//    private JLabel lbCpf = new JLabel("CPF");
//    private JTextField fdCpf = new JTextField(15);
//
//    private JLabel lbRg = new JLabel("RG");
//    private JTextField fdRg = new JTextField(45);
//
//    private JLabel lbNome = new JLabel("Nome");
//    private JTextField fdNome = new JTextField(45);
//
//    private JSpinner spinnerdataNasc = new JSpinner(new SpinnerDateModel());
//    private final JSpinner.DateEditor spinnerEditordataNasc = new JSpinner.DateEditor(spinnerdataNasc, "dd/MM/yyyy");
//    private JLabel lbDataNasc = new JLabel("Data Nascimento");
//    private JLabel lbEmail = new JLabel("E-mail");
//    private JTextField fdEmail = new JTextField(45);
//
//    JLabel lbsexo = new JLabel("Sexo");
//    JPanel pnSexo = new JPanel();
//    JCheckBox checkFeminino = new JCheckBox("feminino");
//    JCheckBox checkMasculino = new JCheckBox("masculino");
//    private JLabel lbEstadoCivil = new JLabel("Estado Civil");
//    private JTextField fdEstadoCivil = new JTextField(45);
//
//    private JLabel lbEndereco = new JLabel("Endereco");
//    private JTextField fdEndereco = new JTextField(45);
//
//    private JLabel lbTelefone = new JLabel("Telefone");
//    private JTextField fdTelefone = new JTextField(45);
//
//    private JLabel lbCelular = new JLabel("Celular");
//    private JTextField fdCelular = new JTextField(45);
//
//    JPanel painelImagem = new JPanel(new GridLayout(1, 1));
//    Image img;
//    Image imagemAux;
//    String origem;
//    String destino = "src/fotos/";
//    String semImagem = "src/fotos/0.png";
//    String escolherImagem = "src/fotos/0a.png";
//    JLabel labelFoto = new JLabel("");
//    Boolean uploadFoto = false;
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
//    DAOPessoa controle = new DAOPessoa();
//    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
//    Boolean acao;
//    Font fonte = new Font("Courier New", Font.BOLD, 20);
//    Font fonteL = new Font("Courier New", Font.PLAIN, 14);
//
//    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//    Pessoa pessoa = new Pessoa();
//
//    public GUIPessoa(){
//        setSize(725, 620);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//        setTitle("Cadastro de Pessoas");
//
//        try {
//            origem = "/fotos/0.png";
//            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
//            imagemAux = icone.getImage();
//            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//            labelFoto.setIcon(icone);
//
//        } catch (Exception erro) {
//            System.out.println("erro ao carregar a imagem");
//        }
//
//        painelCentral.setLayout(new GridLayout(10, 2));
//        painelCentral.add(lbRg);
//        painelCentral.add(fdRg);
//        painelCentral.add(lbNome);
//        painelCentral.add(fdNome);
//        painelCentral.add(lbEmail);
//        painelCentral.add(fdEmail);
//        painelCentral.add(lbEstadoCivil);
//        painelCentral.add(fdEstadoCivil);
//        painelCentral.add(lbEndereco);
//        painelCentral.add(fdEndereco);
//        painelCentral.add(lbTelefone);
//        painelCentral.add(fdTelefone);
//        painelCentral.add(lbCelular);
//        painelCentral.add(fdCelular);
//
//        fdRg.setEnabled(false);
//        fdNome.setEnabled(false);
//        fdEmail.setEnabled(false);
//        fdEstadoCivil.setEnabled(false);
//        fdEndereco.setEnabled(false);
//        fdTelefone.setEnabled(false);
//        fdCelular.setEnabled(false);
//
//        painelCentral.add(lbDataNasc);
//        painelCentral.add(spinnerdataNasc);
//        spinnerdataNasc.setEditor(spinnerEditordataNasc);
//        spinnerdataNasc.setEnabled(false);
//        painelCentral.add(lbsexo);
//        pnSexo.add(checkFeminino);
//        checkFeminino.setEnabled(false);
//        pnSexo.add(checkMasculino);
//        checkMasculino.setEnabled(false);
//        painelCentral.add(pnSexo);
//        List<String> combo = new ArrayList<>();
//
//
//cp.setBackground(Color.white);
//        painelImagem.setBackground(Color.white);
//        painelImagem.add(labelFoto);
//        cp.add(painelNortes, BorderLayout.NORTH);
//        cp.add(painelCentralFora, BorderLayout.WEST);
//        cp.add(painelImagem, BorderLayout.EAST);
//        cp.add(painelSul, BorderLayout.SOUTH);
//
//        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
//        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
//        painelNortes.add(painelNorteCima);
//        painelNortes.add(painelNorteBaixo);
//        painelNorteCima.add(labelTitulo);
//        painelNorteCima.add(fdCpf);
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
//        pnSexo.setBackground(Color.WHITE);
//        checkFeminino.setBackground(Color.WHITE);
//        checkMasculino.setBackground(Color.WHITE);
//
//        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
//        fdCpf.setFont(new Font("Courier New", Font.PLAIN, 20));
//        lbCpf.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbRg.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbNome.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbDataNasc.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbEmail.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbsexo.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbEstadoCivil.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbTelefone.setFont(new Font("Courier New", Font.BOLD, 17));
//        lbCelular.setFont(new Font("Courier New", Font.BOLD, 17));
//        fdCpf.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdRg.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdNome.setFont(new Font("Courier New", Font.PLAIN, 17));
//        spinnerdataNasc.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdEmail.setFont(new Font("Courier New", Font.PLAIN, 17));
//        checkFeminino.setFont(new Font("Courier New", Font.PLAIN, 17));
//        checkMasculino.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdEstadoCivil.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdEndereco.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdTelefone.setFont(new Font("Courier New", Font.PLAIN, 17));
//        fdCelular.setFont(new Font("Courier New", Font.PLAIN, 17));
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
//            uploadFoto = false;
//                try{
//                    pessoa = new Pessoa();
//                    int cpf = Integer.valueOf(fdCpf.getText());
//                    pessoa.setCpf(Integer.valueOf(fdCpf.getText()));
//                    pessoa = controle.obter(pessoa.getCpf());
//                    labelAviso.setBackground(Color.green);
//                    if (pessoa != null) {
//                        fdCpf.setText(pessoa.getCpf() + "");
//                        fdRg.setText(pessoa.getRg() + "");
//                        fdNome.setText(pessoa.getNome() + "");
//                        spinnerdataNasc.setValue(pessoa.getDataNasc());
//                        fdEmail.setText(pessoa.getEmail() + "");
//                        if (pessoa.getSexo()==1) {
//                            checkFeminino.setSelected(true);
//                            checkMasculino.setSelected(false);
//                        } else {
//                            checkMasculino.setSelected(true);
//                            checkFeminino.setSelected(false);
//                        }
//                        fdEstadoCivil.setText(pessoa.getEstadoCivil() + "");
//                        fdEndereco.setText(pessoa.getEndereco() + "");
//                        fdTelefone.setText(pessoa.getTelefone() + "");
//                        fdCelular.setText(pessoa.getCelular() + "");
//                        btAtualizar.setVisible(true);
//                        btRemover.setVisible(true);
//                        btInserir.setVisible(false);
//                        btListar.setVisible(false);
//                        labelAviso.setText("Encontrado na lista!");
//                        labelAviso.setBackground(Color.green);
//                        try {
//                            String aux = String.valueOf(pessoa.getCpf()).trim();
//                            origem = "/fotos/" + aux + ".png";
//                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
//                            imagemAux = icone.getImage();
//                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//
//                            labelFoto.setIcon(icone);
//
//                        } catch (Exception erro) {
//                            origem = "/fotos/0.png";
//                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
//                            imagemAux = icone.getImage();
//                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//                            labelFoto.setIcon(icone);
//                        }
//                    } else {
//        try {
//            origem = "/fotos/0.png";
//            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
//            imagemAux = icone.getImage();
//            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//            labelFoto.setIcon(icone);
//
//        } catch (Exception erro) {
//            System.out.println("erro ao carregar a imagem");
//        }
//                        fdRg.setEnabled(false);
//                        fdRg.setText(null);
//                        fdNome.setEnabled(false);
//                        fdNome.setText(null);
//                        fdEmail.setEnabled(false);
//                        fdEmail.setText(null);
//                        fdEstadoCivil.setEnabled(false);
//                        fdEstadoCivil.setText(null);
//                        fdEndereco.setEnabled(false);
//                        fdEndereco.setText(null);
//                        fdTelefone.setEnabled(false);
//                        fdTelefone.setText(null);
//                        fdCelular.setEnabled(false);
//                        fdCelular.setText(null);
//                        checkFeminino.setEnabled(false);
//                        checkMasculino.setEnabled(false);
//                        checkFeminino.setSelected(false);
//                        checkMasculino.setSelected(false);
//                        spinnerdataNasc.setEnabled(false);
//                        spinnerdataNasc.setValue(new Date());
//                        labelAviso.setText("Não encontrado!");
//                        labelAviso.setBackground(Color.red);
//                        btInserir.setVisible(true);
//                        btAtualizar.setVisible(false);
//                        btRemover.setVisible(false);
//                        btListar.setVisible(false);
//        try {
//            origem = "/fotos/0.png";
//            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
//            imagemAux = icone.getImage();
//            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//            labelFoto.setIcon(icone);
//
//        } catch (Exception erro) {
//            System.out.println("erro ao carregar a imagem");
//        }
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
//        try {
//            origem = "/fotos/0a.png";
//            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
//            imagemAux = icone.getImage();
//            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//            labelFoto.setIcon(icone);
//
//        } catch (Exception erro) {
//            System.out.println("erro ao carregar a imagem");
//        }
//                fdCpf.setEnabled(false);
//                fdRg.setEnabled(true);
//                fdNome.setEnabled(true);
//                spinnerdataNasc.setEnabled(true);
//                fdEmail.setEnabled(true);
//                checkFeminino.setEnabled(true);
//                checkMasculino.setEnabled(true);
//                fdEstadoCivil.setEnabled(true);
//                fdEndereco.setEnabled(true);
//                fdTelefone.setEnabled(true);
//                fdCelular.setEnabled(true);
//            uploadFoto = true;
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
//            uploadFoto = false;
//                if(acao){ //btInserir
//                    try {
//                    pessoa = new Pessoa();
//                        pessoa.setCpf(Integer.valueOf(fdCpf.getText()));
//                        pessoa.setRg(fdRg.getText());
//                        pessoa.setNome(fdNome.getText());
//                        pessoa.setDataNasc((Date) spinnerdataNasc.getValue());
//                        pessoa.setEmail(fdEmail.getText());
//                        Boolean respSexo = null;
//                        if (checkFeminino.isSelected()) {
//                            respSexo = true;
//                        } else if (checkMasculino.isSelected()) {
//                            respSexo = false;
//                        } else {
//                            int a = 1 / 0;
//                        }
//                        pessoa.setSexo(respSexo ? Short.valueOf("1") : Short.valueOf("0"));
//                        pessoa.setEstadoCivil(fdEstadoCivil.getText());
//                        pessoa.setEndereco(fdEndereco.getText());
//                        pessoa.setTelefone(fdTelefone.getText());
//                        pessoa.setCelular(fdCelular.getText());
//                        controle.inserir(pessoa);
//                        labelAviso.setText("Registro inserido com sucesso!");
//                        fdCpf.setEnabled(true);
//                        fdCpf.requestFocus();
//                        fdRg.setEnabled(false);
//                        fdNome.setEnabled(false);
//                        spinnerdataNasc.setEnabled(false);
//                        fdEmail.setEnabled(false);
//                        checkFeminino.setEnabled(false);
//                        checkMasculino.setEnabled(false);
//                        fdEstadoCivil.setEnabled(false);
//                        fdEndereco.setEnabled(false);
//                        fdTelefone.setEnabled(false);
//                        fdCelular.setEnabled(false);
//                        btSalvar.setVisible(false);
//                        btCancelar.setVisible(false);
//                        btBuscar.setVisible(true);
//                        btListar.setVisible(true);
//                    } catch (Exception erro) {
//                        labelAviso.setText("Erro nos dados!");
//                    }
//                } else { //btAlterar
//                    try {
//                        pessoa = new Pessoa();
//                        pessoa.setCpf(Integer.valueOf(fdCpf.getText()));
//                        pessoa.setRg(fdRg.getText());
//                        pessoa.setNome(fdNome.getText());
//                        pessoa.setDataNasc((Date) spinnerdataNasc.getValue());
//                        pessoa.setEmail(fdEmail.getText());
//                        Boolean respSexo = null;
//                        if (checkFeminino.isSelected()) {
//                            respSexo = true; 
//                        } else {
//                            respSexo = false;
//                        }
//                        pessoa.setSexo(respSexo ? Short.valueOf("0") : Short.valueOf("1"));
//                        pessoa.setEstadoCivil(fdEstadoCivil.getText());
//                        pessoa.setEndereco(fdEndereco.getText());
//                        pessoa.setTelefone(fdTelefone.getText());
//                        pessoa.setCelular(fdCelular.getText());
//                        controle.atualizar(pessoa);
//                        labelAviso.setText("Registro alterado com sucesso!");
//                        fdCpf.setEnabled(true);
//                        fdCpf.requestFocus();
//                        fdRg.setEnabled(false);
//                        fdNome.setEnabled(false);
//                        spinnerdataNasc.setEnabled(false);
//                        fdEmail.setEnabled(false);
//                        checkFeminino.setEnabled(false);
//                        checkMasculino.setEnabled(false);
//                        fdEstadoCivil.setEnabled(false);
//                        fdEndereco.setEnabled(false);
//                        fdTelefone.setEnabled(false);
//                        fdCelular.setEnabled(false);
//                        btSalvar.setVisible(false);
//                        btCancelar.setVisible(false);
//                        btBuscar.setVisible(true);
//                        btListar.setVisible(true);
//                    } catch (Exception erro) {
//                        labelAviso.setText("Erro nos dados!");
//                    }
//                }
//                destino = destino + pessoa.getCpf() + ".png";
//                CopiaImagem.copiar(origem, destino);
//                destino = "src/fotos/";
//            }
//        }
//    );
//
//        btCancelar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//        try {
//            origem = "/fotos/0.png";
//            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
//            imagemAux = icone.getImage();
//            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//            labelFoto.setIcon(icone);
//
//        } catch (Exception erro) {
//            System.out.println("erro ao carregar a imagem");
//        }
//                labelAviso.setText("Cancelado!");
//                fdCpf.setEnabled(false);
//                fdCpf.setText("");
//                fdRg.setEnabled(false);
//                fdRg.setText("");
//                fdNome.setEnabled(false);
//                fdNome.setText("");
//                spinnerdataNasc.setEnabled(false);
//                spinnerdataNasc.setValue(new Date());
//                fdEmail.setEnabled(false);
//                fdEmail.setText("");
//                checkFeminino.setEnabled(false);
//                checkFeminino.setSelected(false);
//                checkMasculino.setEnabled(false);
//                checkMasculino.setSelected(false);
//                fdEstadoCivil.setEnabled(false);
//                fdEstadoCivil.setText("");
//                fdEndereco.setEnabled(false);
//                fdEndereco.setText("");
//                fdTelefone.setEnabled(false);
//                fdTelefone.setText("");
//                fdCelular.setEnabled(false);
//                fdCelular.setText("");
//                fdCpf.setEnabled(true);
//                fdCpf.requestFocus();
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
//            uploadFoto = false;
//                acao = false;
//                fdRg.setEnabled(true);
//                fdNome.setEnabled(true);
//                spinnerdataNasc.setEnabled(true);
//                fdEmail.setEnabled(true);
//                checkFeminino.setEnabled(true);
//                checkMasculino.setEnabled(true);
//                fdEstadoCivil.setEnabled(true);
//                fdEndereco.setEnabled(true);
//                fdTelefone.setEnabled(true);
//                fdCelular.setEnabled(true);
//                fdRg.requestFocus();
//                fdCpf.setEnabled(false);
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
//                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + pessoa.getCpf() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
//                    controle.remover(pessoa);
//                    labelAviso.setText("Removido!");
//                    fdCpf.setText("");
//                    fdRg.setText("");
//                    fdRg.setEnabled(false);
//                    fdNome.setText("");
//                    fdNome.setEnabled(false);
//                    spinnerdataNasc.setEnabled(false);
//                    spinnerdataNasc.setValue(new Date());
//                    fdEmail.setText("");
//                    fdEmail.setEnabled(false);
//                    checkFeminino.setEnabled(false);
//                    checkFeminino.setSelected(false);
//                    checkMasculino.setEnabled(false);
//                    checkMasculino.setSelected(false);
//                    fdEstadoCivil.setText("");
//                    fdEstadoCivil.setEnabled(false);
//                    fdEndereco.setText("");
//                    fdEndereco.setEnabled(false);
//                    fdTelefone.setText("");
//                    fdTelefone.setEnabled(false);
//                    fdCelular.setText("");
//                    fdCelular.setEnabled(false);
//String aux = String.valueOf(pessoa.getCpf()).trim();
//                    origem = "src/fotos/" + aux + ".png";
//                    System.out.println(origem);
//                    try {
//                        File f = new File(origem);
//                        if (f.exists()) {
//                            f.delete();
//                        }
//                    } catch (Exception erro) {
//                        System.out.println("Erro");
//                    }
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
// labelFoto.addMouseListener(new MouseAdapter() {
//            public void mouseReleased(MouseEvent e) {
//                if (uploadFoto) {
//                    JFileChooser fc = new JFileChooser();
//                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
//                        File img = fc.getSelectedFile();
//                        origem = fc.getSelectedFile().getAbsolutePath();
//                        try {
//                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());
//                            Image imagemAux;
//                            imagemAux = icone.getImage();
//                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
//                            labelFoto.setIcon(icone);
//
//                        } catch (Exception ex) {
//                            System.out.println("Erro: " + ex.getMessage());
//                        }
//                    }
//
//                }
//
//            }
//        });
//
//        btListar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new PessoaGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GUIPessoa extends JFrame {
    public static void main(String[] args) {
        new GUIPessoa();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("CPF: ");
    private JLabel lbCpf = new JLabel("CPF");
    private JTextField fdCpf = new JTextField(15);

    private JLabel lbRg = new JLabel("RG");
    private JTextField fdRg = new JTextField(45);

    private JLabel lbNome = new JLabel("Nome");
    private JTextField fdNome = new JTextField(45);

    private JSpinner spinnerdataNasc = new JSpinner(new SpinnerDateModel());
    private final JSpinner.DateEditor spinnerEditordataNasc = new JSpinner.DateEditor(spinnerdataNasc, "dd/MM/yyyy");
    private JLabel lbDataNasc = new JLabel("Data Nascimento");
    private JLabel lbEmail = new JLabel("E-mail");
    private JTextField fdEmail = new JTextField(45);

    JLabel lbsexo = new JLabel("Sexo");
    JPanel pnSexo = new JPanel();
    JCheckBox checkFeminino = new JCheckBox("feminino");
    JCheckBox checkMasculino = new JCheckBox("masculino");
    private JLabel lbEstadoCivil = new JLabel("Estado Civil");
    private JTextField fdEstadoCivil = new JTextField(45);

    private JLabel lbEndereco = new JLabel("Endereco");
    private JTextField fdEndereco = new JTextField(45);

    private JLabel lbTelefone = new JLabel("Telefone");
    private JTextField fdTelefone = new JTextField(45);

    private JLabel lbCelular = new JLabel("Celular");
    private JTextField fdCelular = new JTextField(45);

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

    DAOPessoa controle = new DAOPessoa();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Pessoa pessoa = new Pessoa();

    public GUIPessoa(){
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
        painelCentral.add(lbRg);
        painelCentral.add(fdRg);
        painelCentral.add(lbNome);
        painelCentral.add(fdNome);
        painelCentral.add(lbEmail);
        painelCentral.add(fdEmail);
        painelCentral.add(lbEstadoCivil);
        painelCentral.add(fdEstadoCivil);
        painelCentral.add(lbEndereco);
        painelCentral.add(fdEndereco);
        painelCentral.add(lbTelefone);
        painelCentral.add(fdTelefone);
        painelCentral.add(lbCelular);
        painelCentral.add(fdCelular);

        fdRg.setEnabled(false);
        fdNome.setEnabled(false);
        fdEmail.setEnabled(false);
        fdEstadoCivil.setEnabled(false);
        fdEndereco.setEnabled(false);
        fdTelefone.setEnabled(false);
        fdCelular.setEnabled(false);

        painelCentral.add(lbDataNasc);
        painelCentral.add(spinnerdataNasc);
        spinnerdataNasc.setEditor(spinnerEditordataNasc);
        spinnerdataNasc.setEnabled(false);
        painelCentral.add(lbsexo);
        pnSexo.add(checkFeminino);
        checkFeminino.setEnabled(false);
        pnSexo.add(checkMasculino);
        checkMasculino.setEnabled(false);
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
        painelNorteCima.add(fdCpf);
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
        checkFeminino.setBackground(Color.WHITE);
        checkMasculino.setBackground(Color.WHITE);

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdCpf.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbCpf.setFont(new Font("Courier New", Font.BOLD, 17));
        lbRg.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNome.setFont(new Font("Courier New", Font.BOLD, 17));
        lbDataNasc.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEmail.setFont(new Font("Courier New", Font.BOLD, 17));
        lbsexo.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEstadoCivil.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 17));
        lbTelefone.setFont(new Font("Courier New", Font.BOLD, 17));
        lbCelular.setFont(new Font("Courier New", Font.BOLD, 17));
        fdCpf.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdRg.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNome.setFont(new Font("Courier New", Font.PLAIN, 17));
        spinnerdataNasc.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEmail.setFont(new Font("Courier New", Font.PLAIN, 17));
        checkFeminino.setFont(new Font("Courier New", Font.PLAIN, 17));
        checkMasculino.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEstadoCivil.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEndereco.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdTelefone.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdCelular.setFont(new Font("Courier New", Font.PLAIN, 17));
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
                try{
                    pessoa = new Pessoa();
                    int cpf = Integer.valueOf(fdCpf.getText());
                    pessoa.setCpf(Integer.valueOf(fdCpf.getText()));
                    pessoa = controle.obter(pessoa.getCpf());
                    labelAviso.setBackground(Color.green);
                    if (pessoa != null) {
                        fdCpf.setText(pessoa.getCpf() + "");
                        fdRg.setText(pessoa.getRg() + "");
                        fdNome.setText(pessoa.getNome() + "");
                        spinnerdataNasc.setValue(pessoa.getDataNasc());
                        fdEmail.setText(pessoa.getEmail() + "");
                        if (pessoa.getSexo()) {
                            checkFeminino.setSelected(true);
                            checkMasculino.setSelected(false);
                        } else {
                            checkMasculino.setSelected(true);
                            checkFeminino.setSelected(false);
                        }
                        fdEstadoCivil.setText(pessoa.getEstadoCivil() + "");
                        fdEndereco.setText(pessoa.getEndereco() + "");
                        fdTelefone.setText(pessoa.getTelefone() + "");
                        fdCelular.setText(pessoa.getCelular() + "");
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
                        fdRg.setEnabled(false);
                        fdRg.setText(null);
                        fdNome.setEnabled(false);
                        fdNome.setText(null);
                        fdEmail.setEnabled(false);
                        fdEmail.setText(null);
                        fdEstadoCivil.setEnabled(false);
                        fdEstadoCivil.setText(null);
                        fdEndereco.setEnabled(false);
                        fdEndereco.setText(null);
                        fdTelefone.setEnabled(false);
                        fdTelefone.setText(null);
                        fdCelular.setEnabled(false);
                        fdCelular.setText(null);
                        checkFeminino.setEnabled(false);
                        checkMasculino.setEnabled(false);
                        checkFeminino.setSelected(false);
                        checkMasculino.setSelected(false);
                        spinnerdataNasc.setEnabled(false);
                        spinnerdataNasc.setValue(new Date());
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
                    labelAviso.setText("Preencha os campos corretamente!");
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
                fdCpf.setEnabled(false);
                fdRg.setEnabled(true);
                fdNome.setEnabled(true);
                spinnerdataNasc.setEnabled(true);
                fdEmail.setEnabled(true);
                checkFeminino.setEnabled(true);
                checkMasculino.setEnabled(true);
                fdEstadoCivil.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdTelefone.setEnabled(true);
                fdCelular.setEnabled(true);
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
                if(acao){ //btInserir
                    try {
                    pessoa = new Pessoa();
                        pessoa.setCpf(Integer.valueOf(fdCpf.getText()));
                        pessoa.setRg(fdRg.getText());
                        pessoa.setNome(fdNome.getText());
                        pessoa.setDataNasc((Date) spinnerdataNasc.getValue());
                        pessoa.setEmail(fdEmail.getText());
                        Boolean respSexo = null;
                        if (checkFeminino.isSelected()) {
                            respSexo = true;
                        } else if (checkMasculino.isSelected()) {
                            respSexo = false;
                        } else {
                            int a = 1 / 0;
                        }
                        pessoa.setSexo(respSexo);
                        pessoa.setEstadoCivil(fdEstadoCivil.getText());
                        pessoa.setEndereco(fdEndereco.getText());
                        pessoa.setTelefone(fdTelefone.getText());
                        pessoa.setCelular(fdCelular.getText());
                        controle.inserir(pessoa);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdCpf.setEnabled(true);
                        fdCpf.requestFocus();
                        fdRg.setEnabled(false);
                        fdNome.setEnabled(false);
                        spinnerdataNasc.setEnabled(false);
                        fdEmail.setEnabled(false);
                        checkFeminino.setEnabled(false);
                        checkMasculino.setEnabled(false);
                        fdEstadoCivil.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        fdCelular.setEnabled(false);
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
                        pessoa.setCpf(Integer.valueOf(fdCpf.getText()));
                        pessoa.setRg(fdRg.getText());
                        pessoa.setNome(fdNome.getText());
                        pessoa.setDataNasc((Date) spinnerdataNasc.getValue());
                        pessoa.setEmail(fdEmail.getText());
                        Boolean respSexo = null;
                        if (checkFeminino.isSelected()) {
                            respSexo = true; 
                        } else {
                            respSexo = false;
                        }
                        pessoa.setSexo(respSexo);
                        pessoa.setEstadoCivil(fdEstadoCivil.getText());
                        pessoa.setEndereco(fdEndereco.getText());
                        pessoa.setTelefone(fdTelefone.getText());
                        pessoa.setCelular(fdCelular.getText());
                        controle.atualizar(pessoa);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdCpf.setEnabled(true);
                        fdCpf.requestFocus();
                        fdRg.setEnabled(false);
                        fdNome.setEnabled(false);
                        spinnerdataNasc.setEnabled(false);
                        fdEmail.setEnabled(false);
                        checkFeminino.setEnabled(false);
                        checkMasculino.setEnabled(false);
                        fdEstadoCivil.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        fdCelular.setEnabled(false);
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
                fdCpf.setEnabled(false);
                fdCpf.setText("");
                fdRg.setEnabled(false);
                fdRg.setText("");
                fdNome.setEnabled(false);
                fdNome.setText("");
                spinnerdataNasc.setEnabled(false);
                spinnerdataNasc.setValue(new Date());
                fdEmail.setEnabled(false);
                fdEmail.setText("");
                checkFeminino.setEnabled(false);
                checkFeminino.setSelected(false);
                checkMasculino.setEnabled(false);
                checkMasculino.setSelected(false);
                fdEstadoCivil.setEnabled(false);
                fdEstadoCivil.setText("");
                fdEndereco.setEnabled(false);
                fdEndereco.setText("");
                fdTelefone.setEnabled(false);
                fdTelefone.setText("");
                fdCelular.setEnabled(false);
                fdCelular.setText("");
                fdCpf.setEnabled(true);
                fdCpf.requestFocus();
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
                fdRg.setEnabled(true);
                fdNome.setEnabled(true);
                spinnerdataNasc.setEnabled(true);
                fdEmail.setEnabled(true);
                checkFeminino.setEnabled(true);
                checkMasculino.setEnabled(true);
                fdEstadoCivil.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdTelefone.setEnabled(true);
                fdCelular.setEnabled(true);
                fdRg.requestFocus();
                fdCpf.setEnabled(false);
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
                    controle.remover(pessoa);
                    labelAviso.setText("Removido!");
                    fdCpf.setText("");
                    fdRg.setText("");
                    fdRg.setEnabled(false);
                    fdNome.setText("");
                    fdNome.setEnabled(false);
                    spinnerdataNasc.setEnabled(false);
                    spinnerdataNasc.setValue(new Date());
                    fdEmail.setText("");
                    fdEmail.setEnabled(false);
                    checkFeminino.setEnabled(false);
                    checkFeminino.setSelected(false);
                    checkMasculino.setEnabled(false);
                    checkMasculino.setSelected(false);
                    fdEstadoCivil.setText("");
                    fdEstadoCivil.setEnabled(false);
                    fdEndereco.setText("");
                    fdEndereco.setEnabled(false);
                    fdTelefone.setText("");
                    fdTelefone.setEnabled(false);
                    fdCelular.setText("");
                    fdCelular.setEnabled(false);
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
                new PessoaGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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
