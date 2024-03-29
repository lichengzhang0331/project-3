import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class CashierUI {

    public JFrame view;



    public JButton btnManagePurchase = new JButton("Manage Purchase");

    public JButton btnManageCustomer = new JButton("Manage Customer");

    public JButton btnLogout = new JButton("Logout");



    public CashierUI() {

        this.view = new JFrame();



        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        view.setTitle("Store Management System - Cashier View");

        view.setSize(400, 300);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));



        JLabel title = new JLabel("Store Management System");



        title.setFont (title.getFont ().deriveFont (24.0f));

        view.getContentPane().add(title);



        JPanel panelButtons = new JPanel(new FlowLayout());

        panelButtons.add(btnManagePurchase);

        panelButtons.add(btnManageCustomer);

        panelButtons.add(btnLogout);



        view.getContentPane().add(panelButtons);





        btnManagePurchase.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                ManagePurchaseUI ap = new ManagePurchaseUI();

                ap.run();

            }

        });



        btnManageCustomer.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                ManageCustomerUI ap = new ManageCustomerUI();

                ap.run();

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