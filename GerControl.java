import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.awt.ActiveEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class GerControl{
    Insere insert;
    Consulta cons;
    static final int lim = 100;

    @FXML
    private Spinner parId;
    @FXML
    private TextField parNome;
    @FXML
    private TextField parNacionalidade;
    @FXML
    private ComboBox parFuncao;
    @FXML
    private DatePicker parData;
    @FXML
    private Button parBtn;

    @FXML
    private Spinner patId;
    @FXML
    private TextField patNome;
    @FXML
    private Button patBtn;

    @FXML
    private Spinner timIdCapitao;
    @FXML
    private Spinner timIdMembro;
    @FXML
    private Spinner timIdTecnico;
    @FXML
    private Spinner timIdPat;
    @FXML
    private TextField timNome;
    @FXML
    private TextField timPais;
    @FXML
    private TextField timJogo;
    @FXML
    private TextField timDono;
    @FXML
    private DatePicker timData;
    @FXML
    private Button timBtnNovo;
    @FXML
    private Button timBtnIncluir;
    @FXML
    private Button timBtnIncluirPat;
    @FXML
    private TextField timTime;

    @FXML
    private TextField camNome;
    @FXML
    private TextField camPremio;
    @FXML
    private TextField camCampJogador;
    @FXML
    private TextField camNomeTime;
    @FXML
    private TextField camAno;
    @FXML
    private TextField camColocacao;
    @FXML
    private TextField camLocal;
    @FXML
    private TextField camCampPartida;
    @FXML
    private Spinner camIdJogador;
    @FXML
    private Spinner camIdRodada;
    @FXML
    private Spinner camIdFase;
    @FXML
    private Spinner camIdNumero;
    @FXML
    private Spinner camIdRodadaJ;
    @FXML
    private Spinner camIdFaseJ;
    @FXML
    private Spinner camIdNumeroJ;
    @FXML
    private Button camBtnNovo;
    @FXML
    private Button camBtnIncluirPartida;
    @FXML
    private Button camBtnIncluirTime;
    @FXML
    private Button camBtnIncluirJogador;

    @FXML
    private RadioButton conTime;
    @FXML
    private RadioButton conJogador;
    @FXML
    private RadioButton conTecnico;
    @FXML
    private RadioButton conPatrocinador;
    @FXML
    private RadioButton conCampeonato;
    @FXML
    private RadioButton conPartida;
    @FXML
    private TextField conPk1;
    @FXML
    private TextField conPk2;
    @FXML
    private TextField conPk3;
    @FXML
    private Label conLbl1;
    @FXML
    private Label conLbl2;
    @FXML
    private Label conLbl3;
    @FXML
    private TextArea conResposta;
    @FXML
    private Button conBtn;

    private ToggleGroup conGroup;

    @FXML
    private RadioButton remTime;
    @FXML
    private RadioButton remJogador;
    @FXML
    private RadioButton remTecnico;
    @FXML
    private RadioButton remPatrocinador;
    @FXML
    private RadioButton remCampeonato;
    @FXML
    private RadioButton remPartida;
    @FXML
    private TextField remPk1;
    @FXML
    private TextField remPk2;
    @FXML
    private TextField remPk3;
    @FXML
    private Label remLbl1;
    @FXML
    private Label remLbl2;
    @FXML
    private Label remLbl3;
    @FXML
    private Button remBtn;

    private  ToggleGroup remGroup;

    public void radioButtonChanged(){

        this.conPk1.setText("");
        this.conPk2.setText("");
        this.conPk3.setText("");

        if(this.conGroup.getSelectedToggle().equals(conTime)){
            this.conPk1.setVisible(true);
            this.conPk2.setVisible(false);
            this.conPk3.setVisible(false);
            this.conLbl1.setVisible(true);
            this.conLbl2.setVisible(false);
            this.conLbl3.setVisible(false);
        }
        else
        if(this.conGroup.getSelectedToggle().equals(conPartida)){
            this.conPk1.setVisible(true);
            this.conPk2.setVisible(true);
            this.conPk3.setVisible(true);
            this.conLbl1.setVisible(true);
            this.conLbl2.setVisible(true);
            this.conLbl3.setVisible(true);
        }
        else{
            this.conPk1.setVisible(true);
            this.conPk2.setVisible(false);
            this.conPk3.setVisible(false);
            this.conLbl1.setVisible(true);
            this.conLbl2.setVisible(false);
            this.conLbl3.setVisible(false);
        }
    }

    public void removeButtonChanged(){

        this.remPk1.setText("");
        this.remPk2.setText("");
        this.remPk3.setText("");

        if(this.remGroup.getSelectedToggle().equals(remTime)){
            this.remPk1.setVisible(true);
            this.remPk2.setVisible(false);
            this.remPk3.setVisible(false);
            this.remLbl1.setVisible(true);
            this.remLbl2.setVisible(false);
            this.remLbl3.setVisible(false);
        }
        else
        if(this.remGroup.getSelectedToggle().equals(remPartida)){
            this.remPk1.setVisible(true);
            this.remPk2.setVisible(true);
            this.remPk3.setVisible(true);
            this.remLbl1.setVisible(true);
            this.remLbl2.setVisible(true);
            this.remLbl3.setVisible(true);
        }
        else{
            this.remPk1.setVisible(true);
            this.remPk2.setVisible(false);
            this.remPk3.setVisible(false);
            this.remLbl1.setVisible(true);
            this.remLbl2.setVisible(false);
            this.remLbl3.setVisible(false);
        }
    }


    @FXML
    public void initialize(){

        SpinnerValueFactory<Integer> parValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        this.parId.setValueFactory(parValFactory);
        this.parFuncao.getItems().addAll("Jogador","Tecnico");

        SpinnerValueFactory<Integer> patValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        this.patId.setValueFactory(patValFactory);

        SpinnerValueFactory<Integer> timCapitaoValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> timTecnicoValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> timMembroValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> timPatValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        this.timIdCapitao.setValueFactory(timCapitaoValFactory);
        this.timIdTecnico.setValueFactory(timTecnicoValFactory);
        this.timIdMembro.setValueFactory(timMembroValFactory);
        this.timIdPat.setValueFactory(timPatValFactory);

        SpinnerValueFactory<Integer> camJogadorValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> camRodadaValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> camFaseValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> camNumeroValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> camIdRodadaJValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> camIdNumeroJValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        SpinnerValueFactory<Integer> camIdFaseJValFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,lim,1);
        this.camIdJogador.setValueFactory(camJogadorValFactory);
        this.camIdRodada.setValueFactory(camRodadaValFactory);
        this.camIdFase.setValueFactory(camFaseValFactory);
        this.camIdNumero.setValueFactory(camNumeroValFactory);
        this.camIdFaseJ.setValueFactory(camIdFaseJValFactory);
        this.camIdNumeroJ.setValueFactory(camIdNumeroJValFactory);
        this.camIdRodadaJ.setValueFactory(camIdRodadaJValFactory);

        conGroup = new ToggleGroup();
        this.conTime.setToggleGroup(conGroup);
        this.conJogador.setToggleGroup(conGroup);
        this.conTecnico.setToggleGroup(conGroup);
        this.conPatrocinador.setToggleGroup(conGroup);
        this.conCampeonato.setToggleGroup(conGroup);
        this.conPartida.setToggleGroup(conGroup);
        this.conPk1.setVisible(false);
        this.conPk2.setVisible(false);
        this.conPk3.setVisible(false);
        this.conLbl1.setVisible(false);
        this.conLbl2.setVisible(false);
        this.conLbl3.setVisible(false);
        this.conResposta.setEditable(false);

        remGroup = new ToggleGroup();
        this.remTime.setToggleGroup(remGroup);
        this.remJogador.setToggleGroup(remGroup);
        this.remTecnico.setToggleGroup(remGroup);
        this.remPatrocinador.setToggleGroup(remGroup);
        this.remCampeonato.setToggleGroup(remGroup);
        this.remPartida.setToggleGroup(remGroup);
        this.remPk1.setVisible(false);
        this.remPk2.setVisible(false);
        this.remPk3.setVisible(false);
        this.remLbl1.setVisible(false);
        this.remLbl2.setVisible(false);
        this.remLbl3.setVisible(false);


        insert = new Insere();
        cons = new Consulta();
        cons.conn = insert.connect();


        parBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //String date = String.valueOf(parData.getValue());
                //System.out.println("date: " + date);
                String func = (String) parFuncao.getValue();
                if(func == "Jogador")
                    insert.insereJogador((Integer)parId.getValue(), parNome.getText(), parNacionalidade.getText(), String.valueOf(parData.getValue()));
                else if(func == "Tecnico"){
                    insert.insereTecnico((Integer)parId.getValue(), parNome.getText(), parNacionalidade.getText(), String.valueOf(parData.getValue()));
                }
            }
        });

        patBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.inserePatrocinador((Integer)patId.getValue(), patNome.getText());
            }
        });

        timBtnNovo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.insereTime(timNome.getText(), timJogo.getText(), timDono.getText(), timPais.getText(), String.valueOf(timData.getValue()));
                insert.insereContrataJogador((Integer)timIdCapitao.getValue(), timNome.getText());
                insert.insereContrataTecnico((Integer)timIdTecnico.getValue(), timNome.getText());
            }
        });

        timBtnIncluir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.insereContrataJogador((Integer)timIdMembro.getValue(), timTime.getText());
            }
        });

        timBtnIncluirPat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.inserePatrocinaTime((Integer)timIdPat.getValue(), timTime.getText());
            }
        });

        camBtnNovo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.insereCampeonato(camNome.getText(), Float.parseFloat(camPremio.getText()));
            }
        });

        camBtnIncluirJogador.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.inserejoga((Integer)camIdFaseJ.getValue(), (Integer)camIdRodadaJ.getValue(), (Integer)camIdNumeroJ.getValue(), (Integer)camIdJogador.getValue());
            }
        });

        camBtnIncluirTime.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.insereParticipaCampeonato(camNomeTime.getText(), camCampJogador.getText(), Integer.parseInt(camAno.getText()), Integer.parseInt(camColocacao.getText()), camLocal.getText());
            }
        });

        camBtnIncluirPartida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insert.inserePartida((Integer)camIdFase.getValue(),(Integer)camIdNumero.getValue(),(Integer)camIdNumero.getValue(), camCampPartida.getText());
            }
        });

        conBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String r;
               if(conGroup.getSelectedToggle().equals(conTime)){
                   r = cons.consultaTime(conPk1.getText());
                   conResposta.setText(r);
               }

                if(conGroup.getSelectedToggle().equals(conJogador)){
                    r = cons.consultaJogador(Integer.parseInt(conPk1.getText()));
                    conResposta.setText(r);
                }

                if(conGroup.getSelectedToggle().equals(conTecnico)){
                    r = cons.consultaTecnico(Integer.parseInt(conPk1.getText()));
                    conResposta.setText(r);
                }

                if(conGroup.getSelectedToggle().equals(conPatrocinador)){
                    r = cons.consultaPatrocinador(Integer.parseInt(conPk1.getText()));
                    conResposta.setText(r);
                }

                if(conGroup.getSelectedToggle().equals(conCampeonato)){
                    r = cons.consultaCampeonato(conPk1.getText());
                    conResposta.setText(r);
                }

                if(conGroup.getSelectedToggle().equals(conPartida)){
                    r = cons.consultaPartida(Integer.parseInt(conPk1.getText()), Integer.parseInt(conPk2.getText()), Integer.parseInt(conPk3.getText()));
                    conResposta.setText(r);
                }
            }
        });

        remBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(remGroup.getSelectedToggle().equals(remTime)){
                    insert.deletaTime(remPk1.getText());
                }

                if(remGroup.getSelectedToggle().equals(remJogador)){
                    insert.deletaJogador(Integer.parseInt(remPk1.getText()));
                }

                if(remGroup.getSelectedToggle().equals(remTecnico)){
                    insert.deletaTecnico(Integer.parseInt(remPk1.getText()));
                }

                if(remGroup.getSelectedToggle().equals(remPatrocinador)){
                    insert.deletaPatrocinador(Integer.parseInt(remPk1.getText()));
                }

                if(remGroup.getSelectedToggle().equals(remCampeonato)){
                    insert.deletaCampeonato(remPk1.getText());
                }

                if(remGroup.getSelectedToggle().equals(remPartida)){
                    insert.deletaPartida(Integer.parseInt(remPk1.getText()), Integer.parseInt(remPk2.getText()), Integer.parseInt(remPk3.getText()));
                }
            }
        });
    }
}
