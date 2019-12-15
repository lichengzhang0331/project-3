import com.google.gson.Gson;



import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;



public class ManageUserUI {

    public JFrame view;



    public JButton btnLoad = new JButton("Load User");

    public JButton btnSave = new JButton("Save User");



    public JTextField txtUsertype = new JTextField(20);

    public JTextField txtUserName = new JTextField(20);

    public JTextField txtPassword = new JTextField(20);

    public JTextField txtFullname= new JTextField(20);

    public JTextField txtCustomerID= new JTextField(20);



    CustomerModel customer;



    public ManageUserUI() {

        this.view = new JFrame();



        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        view.setTitle("Manage User");

        view.setSize(600, 600);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));



        JPanel panelButtons = new JPanel(new FlowLayout());

        panelButtons.add(btnLoad);

        panelButtons.add(btnSave);

        view.getContentPane().add(panelButtons);



        JPanel line1 = new JPanel(new FlowLayout());

        line1.add(new JLabel("Username "));

        line1.add(txtUserName);

        view.getContentPane().add(line1);



        JPanel line2 = new JPanel(new FlowLayout());

        line2.add(new JLabel("Password "));

        line2.add(txtPassword);

        view.getContentPane().add(line2);



        JPanel line3 = new JPanel(new FlowLayout());

        line3.add(new JLabel("Fullname "));

        line3.add(txtFullname);

        view.getContentPane().add(line3);



        JPanel line4 = new JPanel(new FlowLayout());

        line4.add(new JLabel("Usertype "));

        line4.add(txtUsertype);

        view.getContentPane().add(line4);



        JPanel line5 = new JPanel(new FlowLayout());

        line5.add(new JLabel("CustomerID "));

        line5.add(txtCustomerID);

        view.getContentPane().add(line5);



        btnLoad.addActionListener(new ManageUserUI.LoadButtonListerner());



        btnSave.addActionListener(new ManageUserUI.SaveButtonListener());

    }



    public void run() {

        view.setVisible(true);

    }



    class LoadButtonListerner implements ActionListener {



        @Override

        public void actionPerformed(ActionEvent actionEvent) {

            UserModel user = new UserModel();

            Gson gson = new Gson();

            String id = txtUserName.getText();





            if (id.length() == 0) {

                JOptionPane.showMessageDialog(null, "Username cannot be null!");

                return;

            }



            // do client/server



            try {

                Socket link = new Socket("localhost", 1000);

                Scanner input = new Scanner(link.getInputStream());

                PrintWriter output = new PrintWriter(link.getOutputStream(), true);



                MessageModel msg = new MessageModel();

                msg.code = MessageModel.GET_USER;

                msg.data = id;

                output.println(gson.toJson(msg)); // send to Server



                msg = gson.fromJson(input.nextLine(), MessageModel.class);



                if (msg.code == MessageModel.OPERATION_FAILED) {

                    JOptionPane.showMessageDialog(null, "User NOT exists!");

                }

                else {

                    user = gson.fromJson(msg.data, UserModel.class);

                    txtPassword.setText(user.mPassword);

                    txtFullname.setText((user.mFullname));

                    txtUsertype.setText(String.valueOf((user.mUserType)));

                    txtCustomerID.setText(String.valueOf((user.mCustomerID)));

                }



            } catch (Exception e) {

                e.printStackTrace();

            }



        }

    }



    class SaveButtonListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent actionEvent) {

            UserModel user = new UserModel();

            CustomerModel customer = new CustomerModel();

            Gson gson = new Gson();

            String id = txtUserName.getText();



            user.mUsername = id;

            if (id.length() == 0) {

                JOptionPane.showMessageDialog(null, "Username cannot be null!");

                return;

            }





            String name = txtFullname.getText();

            if (name.length() == 0) {

                JOptionPane.showMessageDialog(null, "User fullname cannot be empty!");

                return;

            }



            user.mFullname = name;

            customer.mName = name;



            String Password = txtPassword.getText();

            try {

                user.mPassword = Password;

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Password is invalid!");

                return;

            }



            String usertype = txtUsertype.getText();

            try {

                user.mUserType = Integer.parseInt(usertype);

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Usertype is invalid!");

                return;

            }





            if (Integer.parseInt(usertype) == 0) {

                String CustomerID = txtCustomerID.getText();

                try {

                    customer.mCustomerID = Integer.parseInt(CustomerID);

                    user.mCustomerID = Integer.parseInt(CustomerID);

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "CustomerID is invalid!");

                    return;

                }

            }





            // all user infor is ready! Send to Server!





            try {

                Socket link = new Socket("localhost", 1000);

                Scanner input = new Scanner(link.getInputStream());

                PrintWriter output = new PrintWriter(link.getOutputStream(), true);



                MessageModel msg = new MessageModel();

                msg.code = MessageModel.PUT_USER;

                msg.data = gson.toJson(user);

                output.println(gson.toJson(msg)); // send to Server



                msg = gson.fromJson(input.nextLine(), MessageModel.class); // receive from Server



                if (msg.code == MessageModel.OPERATION_FAILED) {

                    JOptionPane.showMessageDialog(null, "User is NOT saved successfully!");

                }

                else {

                    JOptionPane.showMessageDialog(null, "User is SAVED successfully!");

                }





            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}