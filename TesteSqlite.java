import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteSqlite extends JFrame {
    PreparedStatement pStmt;
    JButton bt1, bt2, bt3;
    JTextField tf1, tf2, tf3, tf4;
    Insere insert;
    Consulta cons;

    TesteSqlite(){
        super("Teste Insere Jogador");
        insert = new Insere();
        cons = new Consulta();
        //try {
            //pStmt = conn.prepareStatement("INSERT INTO JOGADOR VALUES (?, ?, ?, ?)");
            setLayout(new FlowLayout());
            add(new JLabel("ID: "));
            add(tf1 = new JTextField(3));
            add(new JLabel("nome: "));
            add(tf2 = new JTextField(10));
            add(new JLabel("nacionalidade: "));
            add(tf3 = new JTextField(10));
            add(new JLabel("data de nascimento (dd/mm/yyyy)"));
            add(tf4 = new JTextField(10));
            add(bt1 = new JButton("Insere"));
            add(bt2 = new JButton("Consulta"));
            add(bt3 = new JButton("Excluir"));
            pack();
            setVisible(true);
            cons.conn = insert.connect();
            bt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //try {
                        /*pStmt.setInt(1, Integer.parseInt(tf1.getText()));
                        pStmt.setString(2, tf2.getText());
                        pStmt.setString(3, tf3.getText());
                        pStmt.setString(4, tf4.getText());*/
                        insert.insereJogador(Integer.parseInt(tf1.getText()), tf2.getText(), tf3.getText(), tf4.getText());
                        tf1.setText("");
                        tf2.setText("");
                        tf3.setText("");
                        tf4.setText("");
                        //pStmt.executeUpdate();
                   // } catch (Exception ex) {
                        //System.out.println("erro");
                    //}
                }
            });

            bt2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.print(cons.consultaJogador(Integer.parseInt(tf1.getText())));
                }
            });

            bt3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    insert.deletaJogador(Integer.parseInt(tf1.getText()));
                }
            });


        //}catch(SQLException ex){
        //}
    }

    /*public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:esports.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("PRAGMA foreign_keys = ON");

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    System.out.println("teste");
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }*/

   /* static void insere(Connection conn) {
        try {
            pStmt = conn.prepareStatement("INSERT INTO JOGADOR VALUES (?, ?, ?, ?)");
            System.out.println("I'm searching for you everywhere");
            pStmt.setInt(1, 1);
            pStmt.setString(2, "Lucas");
            pStmt.setString(3, "italiano");
            pStmt.setString(4, "06/09/1994");
            pStmt.executeUpdate();
            pStmt.close();
        }catch(SQLException ex){
            System.out.println("erro insere: " + ex.getMessage());
        }
    }*/

        public static void main(String[] args) {
            Connection conn = null;
            //conn = connect();
            new TesteSqlite();
        }
}