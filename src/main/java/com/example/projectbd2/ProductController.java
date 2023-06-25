package com.example.projectbd2;

import com.example.projectbd2.HelloApplication;
import com.example.projectbd2.Pagination;
import com.example.projectbd2.Product.Product;
import com.example.projectbd2.Product.ProductProperty;
import com.example.projectbd2.Product.ProductRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    private Button ButtonNext, ButtonPrev;
    @FXML
    private TableColumn<ProductProperty, String> ColumnProductID, ColumnNamaProduct, ColumnJumlahProduct,ColumnSupplierFK,ColumnWarehouseFK;
    @FXML
    private TableView<ProductProperty> TableProduct;

    private int page = 1;

    private int rowsPerPage = 12;

    private ObservableList<ProductProperty> product = FXCollections.observableArrayList();

    private ProductRepository productRepository = new ProductRepository();

    public ProductController() throws SQLException {
    }
    @FXML
    void onNextButtonClick(ActionEvent event) throws SQLException {
        page++;
        updateTable();
    }

    @FXML
    void onPrevButtonClick(ActionEvent event) throws SQLException {
        page--;
        updateTable();
    }

    @FXML
    void onBackButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getMenu());
    }

    @FXML
    void onAddButtonClick(){
        HelloApplication app = HelloApplication.getapplicationInstance();
        app.setPrimaryStage(app.getProductInsert());
    }

    @FXML
    void onEditButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getProductUpdate());
    }

    @FXML
    void onDeleteButtonClick(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        app.setPrimaryStage(app.getProductDelete());
    }

    private void updateButton() throws SQLException {
        if(page <= 1){
            ButtonPrev.setDisable(true);
        } else {
            ButtonPrev.setDisable(false);
        }
        if (page >= Math.ceil((productRepository.GetProductCount()  / Double.valueOf(rowsPerPage)))){
            ButtonNext.setDisable(true);
        } else {
            ButtonNext.setDisable(false);
        }
    }

    public void updateTable() throws SQLException {
        product = FXCollections.observableArrayList();
        ArrayList<Product> result;
        try {
            result = productRepository.GetProduct(new Pagination(page, rowsPerPage));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.forEach((t) -> {
            ProductProperty tp = new ProductProperty();
            tp.setProductID(Integer.toString(t.getProductID()));
            tp.setNamaProduct(t.getNamaProduct());
            tp.setStockProduct(Integer.toString(t.getStockProduct()));
            tp.setSupplierID(Integer.toString(t.getSupplierFK()));
            tp.setWarehouseID(Integer.toString(t.getWarehouseID()));

            product.add(tp);
        });
        TableProduct.setItems(product);
        updateButton();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnProductID.setCellValueFactory(f -> f.getValue().productIDProperty());
        ColumnNamaProduct.setCellValueFactory(f -> f.getValue().namaProductProperty());
        ColumnJumlahProduct.setCellValueFactory(f -> f.getValue().stockProductProperty());
        ColumnSupplierFK.setCellValueFactory(f -> f.getValue().supplierIDProperty());
        ColumnWarehouseFK.setCellValueFactory(f -> f.getValue().warehouseIDProperty());
        try {
            updateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
