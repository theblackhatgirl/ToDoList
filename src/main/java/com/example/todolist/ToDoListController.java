package com.example.todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.List;

public class ToDoListController {

    private ToDoListService service = new ToDoListService();


    @FXML
    private TextField input;

    @FXML
    private ListView<String> itemsList;

    @FXML
    protected void onButtonAddClick() {
        String item = input.getText();

        if (item != null && !item.equals("")) {
            service.addItem(item);

            showItems();

            input.setText(null);
        }
    }

    private void showItems(){
        List<Item> items = service.getItems();

        List<String> descriptions = items.stream().map((i)->i.getDescription()).toList();

        ObservableList<String> observableList = FXCollections.observableArrayList(descriptions);

        itemsList.setItems(observableList);
    }

    @FXML
    public void initialize(){
        showItems();
    }
}