import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class ManagerUI {

    public UserModel user = null;

    public JFrame view;



    public JButton btnManageProduct = new JButton("Manage Products");

    public JButton btnSummary = new JButton("Summary of sales");



    public ManagerUI(final UserModel user) {

        this.view = new JFrame();

        this.user = user;



        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        view.setTitle("Store Management System - Manager View");

        view.setSize(1000, 600);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));



        JLabel title = new JLabel("Store Management System");



        title.setFont (title.getFont ().deriveFont (24.0f));

        view.getContentPane().add(title);



        JPanel panelButtons = new JPanel(new FlowLayout());

        panelButtons.add(btnManageProduct);

        panelButtons.add(btnSummary);





        view.getContentPane().add(panelButtons);





        btnManageProduct.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                ManageProductUI ui = new ManageProductUI();

                ui.run();

            }

        });



        btnSummary.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                SaleSummaryUI ui = new SaleSummaryUI(user);

                ui.view.setVisible(true);

            }

        });







    }

}