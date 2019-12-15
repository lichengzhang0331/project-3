import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class AdminUI {

    public JFrame view;

    public JButton btnAddUser = new JButton("Manage User");

    public JButton btnChange = new JButton("Change Password / name");

    public JButton btnLogout = new JButton("Logout");

    public UserModel user = null;



    public AdminUI() {

        this.view = new JFrame();

        this.user = user;



        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        view.setTitle("Store Admin System - Administrator View");

        view.setSize(1000, 600);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));



        JLabel title = new JLabel("Store Administrator System");

        title.setFont (title.getFont ().deriveFont (24.0f));

        view.getContentPane().add(title);



        JPanel panelButtons = new JPanel(new FlowLayout());

        panelButtons.add(btnAddUser);

        panelButtons.add(btnChange);

        panelButtons.add(btnLogout);

        view.getContentPane().add(panelButtons);





        btnAddUser.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                ManageUserUI ui = new ManageUserUI();

                ui.run();

            }

        });



        btnChange.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                ChangeNamePasswordUI ui = new ChangeNamePasswordUI();

                ui.run();

            }

        });



        btnLogout.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                view.dispose();

                LoginUI ui = new LoginUI();

                ui.view.setVisible(true);

            }

        });





    }

}