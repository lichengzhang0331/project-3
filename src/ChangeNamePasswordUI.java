import com.google.gson.Gson;



import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;



public class ChangeNamePasswordUI {

    public JFrame view;



    public JButton btnChange= new JButton("Change");

    public JButton btnCancel= new JButton("Cancel");



    public JTextField txtFullname = new JTextField(20);

    public JTextField txtPassword = new JTextField(20);





    public ChangeNamePasswordUI(){

        this.view = new JFrame();



        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        view.setTitle("Change fullname and password");

        view.setSize(600, 400);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));



        JPanel panelButtons = new JPanel(new FlowLayout());

        panelButtons.add(btnChange);

        panelButtons.add(btnCancel);

        view.getContentPane().add(panelButtons);



        JPanel line1 = new JPanel(new FlowLayout());

        line1.add(new JLabel("Fullname"));

        line1.add(txtFullname);

        view.getContentPane().add(line1);



        JPanel line2 = new JPanel(new FlowLayout());

        line2.add(new JLabel("Password "));

        line2.add(txtPassword);

        view.getContentPane().add(line2);



        btnChange.addActionListener(new ChangeButtonListerner());



        btnCancel.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                view.dispose();

            }

        });

    }

    public void run() {

        view.setVisible(true);

    }



    class ChangeButtonListerner implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {

            UserModel user = new UserModel();



            String password = txtPassword.getText();

            if (password.length() == 0) {

                JOptionPane.showMessageDialog(null, "Password cannot be empty!");

                return;

            }

            user.mPassword = password;



            String fullname = txtFullname.getText();

            if (fullname.length() == 0) {

                JOptionPane.showMessageDialog(null, "Fullname cannot be empty!");

                return;

            }

            user.mFullname = fullname;



            int res = StoreManager.getInstance().getDataAdapter().saveUser(user);



            if (res == IDataAdapter.USER_SAVE_FAILED)

                JOptionPane.showMessageDialog(null, "User is NOT saved successfully!");

            else

                JOptionPane.showMessageDialog(null, "User is SAVED successfully!");

        }

    }



}