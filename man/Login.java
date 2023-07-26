package uni.man;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Arrays;

public class Login extends  JFrame implements ActionListener {
    JButton login,cancel;
    JTextField user;
    JTextField pass;
    Login(){
        getContentPane().setBackground(Color.BLUE);
        setLayout(null);
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,20);
        add(username);
        user= new JTextField();
        user.setBounds(150,20,150,20);
        add(user);
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,20);
        add(password);
        pass= new JPasswordField();
        pass.setBounds(150,70,150,20);
        add(pass);
        login =new JButton("LOGIN");
        login.setBounds(40,140,120,30);
        add(login);
        cancel =new JButton("CANCEL");
        cancel.setBounds(180,140,120,30);
        add(cancel);
        login.addActionListener(this);
        cancel.addActionListener(this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        JLabel image = new JLabel(i1);
        image.setBounds(350,20,200,200);
        add(image);
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    public static void main(String args[]){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel){
            setVisible(false);
        }
        if (e.getSource()==login){
            String username = user.getText();
            String password = pass.getText();
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            if (username.equals("admin") && password.equals("12345")){
                new Project();
            } else if (username.equals("student") && password.equals("67890")) {
                new Project1();
            }
        }
    }
}
