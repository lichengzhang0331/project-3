public class OracleDataAdapter implements IDataAdapter {

    public int connect(String dbfile) {

        //...

        return CONNECTION_OPEN_OK;

    }



    public int disconnect() {

        // ...

        return CONNECTION_CLOSE_OK;



    }



    public CustomerModel loadCustomer(int id) {

        return null;

    }

    public int saveCustomer(CustomerModel model) {

        return 0;

    }





    public ProductModel loadProduct(int id) {

        return null;

    }

    public int saveProduct(ProductModel model) {

        return PRODUCT_SAVE_OK;

    }



    public PurchaseModel loadPurchase(int id) {

        return null;

    }

    public int savePurchase(PurchaseModel model) {

        return 0;

    }



    public UserModel loadUser(String username) {

        return null;

    }

    public int saveUser(UserModel user) {

        return 0;

    }



    public PurchaseHistoryModel loadPurchaseHistory(int customerID) {

        return null;

    }



    @Override

    public ProductListModel searchProduct(String name, double minPrice, double maxPrice) {

        return null;

    }







}