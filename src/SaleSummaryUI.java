import javax.swing.*;

import javax.swing.table.DefaultTableModel;



public class SaleSummaryUI {

    public JFrame view;

    public JTable purchaseTable;

    public UserModel user = null;



    public SaleSummaryUI(UserModel user) {

        this.user = user;

        this.view = new JFrame();



        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        view.setTitle("Purchase History");

        view.setSize(600, 400);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));





        PurchaseHistoryModel list = StoreManager.getInstance().getDataAdapter().loadPurchaseHistory(user.mCustomerID);

        DefaultTableModel tableData = new DefaultTableModel();



        tableData.addColumn("PurchaseID");

        tableData.addColumn("ProductID");

        tableData.addColumn("Product Name");

        tableData.addColumn("Total");



        for (PurchaseModel purchase : list.purchases) {

            Object[] row = new Object[tableData.getColumnCount()];

            row[0] = purchase.mPurchaseID;

            row[1] = purchase.mProductID;

            ProductModel product = StoreManager.getInstance().getDataAdapter().loadProduct(purchase.mProductID);

            row[2] = product.mName;

            row[3] = purchase.mTotal;

            tableData.addRow(row);

        }





        purchaseTable = new JTable(tableData);



        JScrollPane scrollableList = new JScrollPane(purchaseTable);



        view.getContentPane().add(scrollableList);

    }



}