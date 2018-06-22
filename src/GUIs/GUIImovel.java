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

public class GUIImovel extends JFrame {

   public static void main(String[] args) {
        GUIImovel guiImovel = new GUIImovel();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("codigo_Imovel: ");
    private JLabel lbCodigo_Imovel = new JLabel("codigo_Imovel");
    private JTextField fdCodigo_Imovel = new JTextField(10);

    JLabel lbdisponibilidade = new JLabel("disponibilidadde");
    JPanel pnDisponibilidade = new JPanel();
    JCheckBox checksim = new JCheckBox("sim");
    JCheckBox checknão = new JCheckBox("não");
    private JLabel lbPreco = new JLabel("preco_Imovel");
    private JTextField fdPreco = new JTextField(20);

    private JLabel lbEndereco = new JLabel("endereco");
    private JTextField fdEndereco = new JTextField(20);

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

    DAOImovel controle = new DAOImovel();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Imovel imovel = new Imovel();

    public GUIImovel() {
        setSize(725, 380);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Imovels");

        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }

        painelCentral.setLayout(new GridLayout(4, 2));
        painelCentral.add(lbPreco);
        painelCentral.add(fdPreco);
        painelCentral.add(lbEndereco);
        painelCentral.add(fdEndereco);

        fdPreco.setEnabled(false);
        fdEndereco.setEnabled(false);

        painelCentral.add(lbdisponibilidade);
        pnDisponibilidade.add(checksim);
        checksim.setEnabled(false);
        pnDisponibilidade.add(checknão);
        checknão.setEnabled(false);
        painelCentral.add(pnDisponibilidade);
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
        painelNorteCima.add(fdCodigo_Imovel);
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
        pnDisponibilidade.setBackground(Color.WHITE);
        checksim.setBackground(Color.WHITE);
        checknão.setBackground(Color.WHITE);

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdCodigo_Imovel.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbCodigo_Imovel.setFont(new Font("Courier New", Font.BOLD, 17));
        lbdisponibilidade.setFont(new Font("Courier New", Font.BOLD, 17));
        lbPreco.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 17));
        fdCodigo_Imovel.setFont(new Font("Courier New", Font.PLAIN, 17));
        checksim.setFont(new Font("Courier New", Font.PLAIN, 17));
        checknão.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdPreco.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEndereco.setFont(new Font("Courier New", Font.PLAIN, 17));
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
                    imovel = new Imovel();
                    int codigo_Imovel = Integer.valueOf(fdCodigo_Imovel.getText());
                    imovel.setCodigoImovel(Integer.valueOf(fdCodigo_Imovel.getText()));
                    imovel = controle.obter(imovel.getCodigoImovel());
                    labelAviso.setBackground(Color.green);
                    if (imovel != null) {
                        fdCodigo_Imovel.setText(imovel.getCodigoImovel() + "");
                        if (imovel.getDisponibilidade() == 1) {
                            checksim.setSelected(true);
                            checknão.setSelected(false);
                        } else {
                            checknão.setSelected(true);
                            checksim.setSelected(false);
                        }
                        fdPreco.setText(imovel.getPreco() + "");
                        fdEndereco.setText(imovel.getEndereco() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                        try {
                            String aux = String.valueOf(imovel.getCodigoImovel()).trim();
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
                        fdPreco.setEnabled(false);
                        fdPreco.setText(null);
                        fdEndereco.setEnabled(false);
                        fdEndereco.setText(null);
                        checksim.setEnabled(false);
                        checknão.setEnabled(false);
                        checksim.setSelected(false);
                        checknão.setSelected(false);
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
                fdCodigo_Imovel.setEnabled(false);
                checksim.setEnabled(true);
                checknão.setEnabled(true);
                fdPreco.setEnabled(true);
                fdEndereco.setEnabled(true);
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
                        imovel = new Imovel();
                        imovel.setCodigoImovel(Integer.valueOf(fdCodigo_Imovel.getText()));
                        Short respDisponibilidade = null;
                        if (checksim.isSelected()) {
                            respDisponibilidade = 1;
                        } else if (checknão.isSelected()) {
                            respDisponibilidade = 0;
                        } else {
                            int a = 1 / 0;
                        }
                        imovel.setDisponibilidade(respDisponibilidade);
                        imovel.setPreco(Double.valueOf(fdPreco.getText()));
                        imovel.setEndereco(String.valueOf(fdEndereco.getText()));
                        controle.inserir(imovel);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdCodigo_Imovel.setEnabled(true);
                        fdCodigo_Imovel.requestFocus();
                        checksim.setEnabled(false);
                        checknão.setEnabled(false);
                        fdPreco.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        imovel = new Imovel();
                        imovel.setCodigoImovel(Integer.valueOf(fdCodigo_Imovel.getText()));
                        Short respDisponibilidade = null;
                        if (checksim.isSelected()) {
                            respDisponibilidade = 1;
                        } else {
                            respDisponibilidade = 0;
                        }
                        imovel.setDisponibilidade(respDisponibilidade);
                        imovel.setPreco(Double.valueOf(fdPreco.getText()));
                        imovel.setEndereco(String.valueOf(fdEndereco.getText()));
                        controle.atualizar(imovel);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdCodigo_Imovel.setEnabled(true);
                        fdCodigo_Imovel.requestFocus();
                        checksim.setEnabled(false);
                        checknão.setEnabled(false);
                        fdPreco.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
                destino = destino + imovel.getCodigoImovel() + ".png";
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
                fdCodigo_Imovel.setEnabled(false);
                fdCodigo_Imovel.setText("");
                checksim.setEnabled(false);
                checksim.setSelected(false);
                checknão.setEnabled(false);
                checknão.setSelected(false);
                fdPreco.setEnabled(false);
                fdPreco.setText("");
                fdEndereco.setEnabled(false);
                fdEndereco.setText("");
                fdCodigo_Imovel.setEnabled(true);
                fdCodigo_Imovel.requestFocus();
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
                checksim.setEnabled(true);
                checknão.setEnabled(true);
                fdPreco.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdPreco.requestFocus();
                fdCodigo_Imovel.setEnabled(false);
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
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + imovel.getCodigoImovel() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(imovel);
                    labelAviso.setText("Removido!");
                    fdCodigo_Imovel.setText("");
                    checksim.setEnabled(false);
                    checksim.setSelected(false);
                    checknão.setEnabled(false);
                    checknão.setSelected(false);
                    fdPreco.setText("");
                    fdPreco.setEnabled(false);
                    fdEndereco.setText("");
                    fdEndereco.setEnabled(false);
                    String aux = String.valueOf(imovel.getCodigoImovel()).trim();
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
                new ImovelGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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
