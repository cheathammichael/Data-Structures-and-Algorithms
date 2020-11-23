/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp4.graphical.heap.builder;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author novem
 */
public class MP5GraphicalHeapBuilder extends Application {

    
    HeapSort hp = new HeapSort();

    int childIndex = hp.heap.size() - 1;
    int parentIndex = -1;
    int count = 0;
    int maxCount = 0;
    
    public class HeapSort {

        public ArrayList<Integer> heap = new ArrayList();

        void add(int node) {
            heap.add(node);
            int childIndex = heap.size() - 1;
            int parentIndex = -1;
            if (childIndex % 2 != 0) {
                parentIndex = (childIndex - 1) / 2;
            } else {
                parentIndex = (childIndex - 2) / 2;
            }

            while (parentIndex >= 0
                    && heap.get(parentIndex) < heap.get(childIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);

                childIndex = parentIndex;

                if (childIndex % 2 != 0) {
                    parentIndex = (childIndex - 1) / 2;
                } else {
                    parentIndex = (childIndex - 2) / 2;
                }

            }
        }

        public String traverseHeap() {
            String result = "";
            int i = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            while (i < this.heap.size() && !arr.contains(this.heap.size() - 1)) {

                result += "P: " + this.heap.get(i) + " ";
                arr.add(i);
                if (((2 * i) + 1) < this.heap.size() && !(arr.contains(((2 * i) + 1)))) {
                    result += "L: " + this.heap.get((2 * i) + 1) + " ";
                    arr.add(((2 * i) + 1));

                }
                if (((2 * i) + 2) < this.heap.size() && !(arr.contains(((2 * i) + 2)))) {
                    result += "R: " + this.heap.get((2 * i) + 2) + " ";
                    arr.add((2 * i) + 2);
                }
                i++;
            }
            return result;
        }

        public Integer remove() {
            if (heap.size() == 0) {
                return null;
            }

            //save the root to return it
            Integer removedObject = heap.get(0);
            //move the last node to the root
            heap.set(0, heap.get(heap.size() - 1));
            //remove the last node
            heap.remove(heap.size() - 1);

            int currentIndex = 0;
            while (currentIndex < heap.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                // Find the maximum between two children
                if (leftChildIndex >= heap.size()) {
                    break; // The tree is a heap
                }
                //find the maximum of the two
                int maxIndex = leftChildIndex;
                if (rightChildIndex < heap.size()) {
                    if (heap.get(maxIndex)
                            < heap.get(rightChildIndex)) {
                        maxIndex = rightChildIndex;
                    }
                }

                // Swap if the current node is less than the maximum
                if (heap.get(currentIndex)
                        < heap.get(maxIndex)) {
                    Integer temp = heap.get(maxIndex);
                    heap.set(maxIndex, heap.get(currentIndex));
                    heap.set(currentIndex, temp);
                    currentIndex = maxIndex;
                } else {
                    break; // The tree is a heap
                }
            }

            return removedObject;
        }

        void removeSpecified(int index) {
            ArrayList<Integer> temp = new ArrayList<>();
            Alert alert = new Alert(AlertType.ERROR, "Heap does not contain specified number!", ButtonType.OK);
            if (!(heap.contains(index))) {
                alert.showAndWait();
            } else {

                temp.addAll(heap);
                heap.clear();
                temp.remove(temp.indexOf(index));
                for (int i = 0; i < temp.size(); i++) {
                    hp.add(temp.get(i));
                }
            }

        }

        public int getSize() {
            return heap.size();
        }

        public String getElement(int index) {
            return heap.get(index).toString();
        }

        void testPrintedSorted() {
            Integer o = null;
            while ((o = remove()) != null) {
                System.out.print(o + " ");
            }
            System.out.println("");
        }

    }

    @Override
    public void start(Stage primaryStage) {

        
                    
        StackPane over = new StackPane();
        over.setPrefSize(600, 300);
        GridPane pane = new GridPane();
        pane.setPrefSize(600, 300);

        TextArea ta = new TextArea();
        
        StackPane stack1 = new StackPane();
        Label la1 = new Label();
        Ellipse e1 = new Ellipse(20, 20);
        stack1.setVisible(false);
        e1.setFill(Color.TRANSPARENT);
        e1.setStroke(Color.RED);
        Text t1 = new Text("");
        stack1.getChildren().addAll(e1, t1, la1);
        GridPane.setColumnIndex(stack1, 9);
        GridPane.setRowIndex(stack1, 0);

        StackPane stack2 = new StackPane();
        Label la2 = new Label();
        Ellipse e2 = new Ellipse(20, 20);
        stack2.setVisible(false);
        e2.setFill(Color.TRANSPARENT);
        e2.setStroke(Color.RED);
        Text t2 = new Text("");
        stack2.getChildren().addAll(e2, t2, la2);
        GridPane.setColumnIndex(stack2, 5);
        GridPane.setRowIndex(stack2, 2);

        StackPane stack3 = new StackPane();
        Label la3 = new Label();
        Ellipse e3 = new Ellipse(20, 20);
        stack3.setVisible(false);
        e3.setFill(Color.TRANSPARENT);
        e3.setStroke(Color.RED);
        Text t3 = new Text("");
        stack3.getChildren().addAll(e3, t3, la3);
        GridPane.setColumnIndex(stack3, 13);
        GridPane.setRowIndex(stack3, 2);

        StackPane stack4 = new StackPane();
        Label la4 = new Label();
        Ellipse e4 = new Ellipse(20, 20);
        stack4.setVisible(false);
        e4.setFill(Color.TRANSPARENT);
        e4.setStroke(Color.RED);
        Text t4 = new Text("");
        stack4.getChildren().addAll(e4, t4, la4);
        GridPane.setColumnIndex(stack4, 2);
        GridPane.setRowIndex(stack4, 5);

        StackPane stack5 = new StackPane();
        Label la5 = new Label();
        Ellipse e5 = new Ellipse(20, 20);
        stack5.setVisible(false);
        e5.setFill(Color.TRANSPARENT);
        e5.setStroke(Color.RED);
        Text t5 = new Text("");
        stack5.getChildren().addAll(e5, t5, la5);
        GridPane.setColumnIndex(stack5, 7);
        GridPane.setRowIndex(stack5, 5);

        StackPane stack6 = new StackPane();
        Label la6 = new Label();
        Ellipse e6 = new Ellipse(20, 20);
        stack6.setVisible(false);
        e6.setFill(Color.TRANSPARENT);
        e6.setStroke(Color.RED);
        Text t6 = new Text("");
        stack6.getChildren().addAll(e6, t6, la6);
        GridPane.setColumnIndex(stack6, 11);
        GridPane.setRowIndex(stack6, 5);

        StackPane stack7 = new StackPane();
        Label la7 = new Label();
        Ellipse e7 = new Ellipse(20, 20);
        stack7.setVisible(false);
        e7.setFill(Color.TRANSPARENT);
        e7.setStroke(Color.RED);
        Text t7 = new Text("");
        stack7.getChildren().addAll(e7, t7, la7);
        GridPane.setColumnIndex(stack7, 16);
        GridPane.setRowIndex(stack7, 5);

        final int numCols = 20;
        final int numRows = 6;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            pane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            pane.getRowConstraints().add(rowConst);
        }

        // e1.centerXProperty().bind(pane.widthProperty().divide(2));
        // e1.centerYProperty().bind(pane.heightProperty().divide(2));
        pane.getChildren().addAll(stack1, stack2, stack3, stack4, stack5, stack6, stack7);
        Pane pane1 = new Pane();
        Line line1 = new Line(390, 46, 225, 105);
        Line line2 = new Line(390, 46, 550, 105);
        Line line3 = new Line(225, 146, 102, 255 );
        Line line4 = new Line(225, 146, 307, 255);
        Line line5 = new Line(550, 146, 475, 255);
        Line line6 = new Line(550, 146, 670, 255);
        
        line1.setVisible(false);
        line2.setVisible(false);
        line3.setVisible(false);
        line4.setVisible(false);
        line5.setVisible(false);
        line6.setVisible(false);
        pane1.getChildren().addAll(line1, line2, line3, line4, line5, line6);
        line1.setStroke(Color.BLACK);
        over.getChildren().addAll( pane, pane1);
        FlowPane fp = new FlowPane();
        primaryStage.setTitle("Graphical Heap Builder");
        //TextArea ta = new TextArea();
        TextField tf = new TextField();
        Button add = new Button("Add");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                try {
                    hp.add(Integer.parseInt(tf.getText()));
                    tf.setText("");
                    //      ta.setText(hp.traverseHeap());
                    tf.requestFocus();
                    switch (hp.getSize()) {
                        case 1:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            
                            break;
                        case 2:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            line1.setVisible(true);
                            break;
                        case 3:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            break;
                        case 4:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            break;
                        case 5:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            stack5.setVisible(true);
                            t5.setText(hp.getElement(4));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            break;
                        case 6:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            stack5.setVisible(true);
                            t5.setText(hp.getElement(4));
                            stack6.setVisible(true);
                            t6.setText(hp.getElement(5));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            break;
                        case 7:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            stack5.setVisible(true);
                            t5.setText(hp.getElement(4));
                            stack6.setVisible(true);
                            t6.setText(hp.getElement(5));
                            stack7.setVisible(true);
                            t7.setText(hp.getElement(6));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            line6.setVisible(true);
                            break;

                        default:
                            break;
                    }

                } catch (Exception ex) {
                    Alert alert = new Alert(AlertType.ERROR, "Please use proper input!", ButtonType.OK);
                    alert.showAndWait();
                    tf.setText("");
                }
            }
        });
        Button remove = new Button("Remove Value");
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    hp.removeSpecified(Integer.parseInt(tf.getText()));
                    tf.setText("");
                    
                    tf.requestFocus();
                    stack1.setVisible(false);
                    stack2.setVisible(false);
                    stack3.setVisible(false);
                    stack4.setVisible(false);
                    stack5.setVisible(false);
                    stack6.setVisible(false);
                    stack7.setVisible(false);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    line1.setVisible(false);
                    line2.setVisible(false);
                    line3.setVisible(false);
                    line4.setVisible(false);
                    line5.setVisible(false);
                    line6.setVisible(false);
        
                    switch (hp.getSize()) {
                        case 1:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            break;
                        case 2:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            line1.setVisible(true);
                            break;
                        case 3:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            break;
                        case 4:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            break;
                        case 5:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            stack5.setVisible(true);
                            t5.setText(hp.getElement(4));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            break;
                        case 6:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            stack5.setVisible(true);
                            t5.setText(hp.getElement(4));
                            stack6.setVisible(true);
                            t6.setText(hp.getElement(5));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            break;
                        case 7:
                            stack1.setVisible(true);
                            t1.setText(hp.getElement(0));
                            stack2.setVisible(true);
                            t2.setText(hp.getElement(1));
                            stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            stack4.setVisible(true);
                            t4.setText(hp.getElement(3));
                            stack5.setVisible(true);
                            t5.setText(hp.getElement(4));
                            stack6.setVisible(true);
                            t6.setText(hp.getElement(5));
                            stack7.setVisible(true);
                            t7.setText(hp.getElement(6));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            line6.setVisible(true);
                            break;

                        default:
                            break;
                    
                    }

                } catch (Exception ex) {
                    Alert alert = new Alert(AlertType.ERROR, "Please use proper input!", ButtonType.OK);
                    alert.showAndWait();
                    tf.setText("");

                }
            }
        });
        Button stepAdd = new Button("Step Add");
        stepAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ArrayList<Integer> bank = new ArrayList<>();
                
                try {
                    if (t2.getText().compareTo("")!=0)
                            if (Integer.parseInt(t2.getText()) > Integer.parseInt(t1.getText())&&hp.heap.size() > 3)
                            {
                            String temp = t1.getText();
                            t1.setText(t2.getText());
                            t2.setText(temp);
                            }
                        if (t3.getText().compareTo("")!=0)
                            if (Integer.parseInt(t3.getText()) > Integer.parseInt(t1.getText())&&hp.heap.size() > 3)
                            {
                            String temp = t1.getText();
                            t1.setText(t3.getText());
                            t3.setText(temp);
                            }
                    int addend;
                    if (tf.getText().compareTo("")!=0)
                    {
                        addend = Integer.parseInt(tf.getText());
                        hp.heap.add(addend);
                       
                    }
                    bank.clear();
                        for (int i = 0; i < hp.heap.size(); i++)
                        {
                            bank.add(hp.heap.get(i));
                        }
                    switch (bank.size()) {
                        case 1:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            break;

                        case 2:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            line1.setVisible(true);
                            break;
                        case 3:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            break;
                        case 4:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            break;
                        case 5:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            if (!stack5.isVisible())
                                stack5.setVisible(true);
                            t5.setText(bank.get(4).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            break;
                        case 6:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            if (!stack5.isVisible())
                                stack5.setVisible(true);
                            t5.setText(bank.get(4).toString());
                            if (!stack6.isVisible())
                                stack6.setVisible(true);
                            t6.setText(bank.get(5).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            break;
                        case 7:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            if (!stack5.isVisible())
                                stack5.setVisible(true);
                            t5.setText(bank.get(4).toString());
                            if (!stack6.isVisible())
                                stack6.setVisible(true);
                            t6.setText(bank.get(5).toString());
                            if (!stack7.isVisible())
                                stack7.setVisible(true);
                            t7.setText(bank.get(6).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            line6.setVisible(true);
                            break;

                        default:
                            break;
                    }
                       
                    childIndex = hp.heap.size() - 1;
                    parentIndex = -1;
                    
                    if (childIndex % 2 != 0) {
                        parentIndex = (childIndex - 1) / 2;
                    } else {
                        parentIndex = (childIndex - 2) / 2;
                    }
                    if (parentIndex >= 0
                            && hp.heap.get(parentIndex) < hp.heap.get(childIndex)) {
                        int temp = hp.heap.get(parentIndex);
                        hp.heap.set(parentIndex, hp.heap.get(childIndex));
                        hp.heap.set(childIndex, temp);

                        childIndex = parentIndex;

                        if (childIndex % 2 != 0) {
                            parentIndex = (childIndex - 1) / 2;
                        } else {
                            parentIndex = (childIndex - 2) / 2;
                        }
                                           
                    }
                    
                    tf.setText("");
                    tf.requestFocus();
                    

                } catch (Exception ex) {
                    Alert alert = new Alert(AlertType.ERROR, "Please use proper input!", ButtonType.OK);
                    alert.showAndWait();
                    tf.setText("");
                }
                          
              
            }
        });
        Button stepRemove = new Button("Step Remove Root");
        stepRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ArrayList<Integer> bank = new ArrayList<>();
                int addend;
                try {
                    if (!(t1.getText().compareTo("")==0))
                    {
                        addend = Integer.parseInt(t1.getText());
                        t1.setText("");
                        hp.removeSpecified(addend);
                    }
                        
                    else {
                    tf.setText("");
                    
                    bank.clear();
                        for (int i = 0; i < hp.heap.size(); i++)
                        {
                            bank.add(hp.heap.get(i));
                        }
                    stack1.setVisible(false);
                    stack2.setVisible(false);
                    stack3.setVisible(false);
                    stack4.setVisible(false);
                    stack5.setVisible(false);
                    stack6.setVisible(false);
                    stack7.setVisible(false);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText(""); 
                    line1.setVisible(false);
                    line2.setVisible(false);
                    line3.setVisible(false);
                    line4.setVisible(false);
                    line5.setVisible(false);
                    line6.setVisible(false);
        
                    switch (bank.size()) {
                        case 1:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            break;

                        case 2:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            line1.setVisible(true);
                            break;
                        case 3:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(hp.getElement(2));
                            line1.setVisible(true);
                            line2.setVisible(true);
                            break;
                        case 4:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            break;
                        case 5:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            if (!stack5.isVisible())
                                stack5.setVisible(true);
                            t5.setText(bank.get(4).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            break;
                        case 6:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            if (!stack5.isVisible())
                                stack5.setVisible(true);
                            t5.setText(bank.get(4).toString());
                            if (!stack6.isVisible())
                                stack6.setVisible(true);
                            t6.setText(bank.get(5).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            break;
                        case 7:
                            if (!stack1.isVisible())
                                stack1.setVisible(true);
                            t1.setText(bank.get(0).toString());
                            if (!stack2.isVisible())
                                stack2.setVisible(true);
                            t2.setText(bank.get(1).toString());
                            if (!stack3.isVisible())
                                stack3.setVisible(true);
                            t3.setText(bank.get(2).toString());
                            if (!stack4.isVisible())
                                stack4.setVisible(true);
                            t4.setText(bank.get(3).toString());
                            if (!stack5.isVisible())
                                stack5.setVisible(true);
                            t5.setText(bank.get(4).toString());
                            if (!stack6.isVisible())
                                stack6.setVisible(true);
                            t6.setText(bank.get(5).toString());
                            if (!stack7.isVisible())
                                stack7.setVisible(true);
                            t7.setText(bank.get(6).toString());
                            line1.setVisible(true);
                            line2.setVisible(true);
                            line3.setVisible(true);
                            line4.setVisible(true);
                            line5.setVisible(true);
                            line6.setVisible(true);
                            break;

                        default:
                            break;
                    }
                    }
                    
                    
                    tf.setText("");
                    tf.requestFocus();
                    

                } catch (Exception ex) {
                    Alert alert = new Alert(AlertType.ERROR, "Please use proper input!", ButtonType.OK);
                    alert.showAndWait();
                    tf.setText("");
                }
                          
              
            }
        });
        Button clear = new Button("Clear");
        
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    hp.heap.clear();
                    stack1.setVisible(false);
                    stack2.setVisible(false);
                    stack3.setVisible(false);
                    stack4.setVisible(false);
                    stack5.setVisible(false);
                    stack6.setVisible(false);
                    stack7.setVisible(false);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    line1.setVisible(false);
                    line2.setVisible(false);
                    line3.setVisible(false);
                    line4.setVisible(false);
                    line5.setVisible(false);
                    line6.setVisible(false);
                    
                    tf.setText("");
                    tf.requestFocus();             

                } catch (Exception ex) {
                    Alert alert = new Alert(AlertType.ERROR, "What happened?!", ButtonType.OK);
                    alert.showAndWait();
                    tf.setText("");
                }
                          
              
            }
        });
        fp.setHgap(4);
        fp.setVgap(4);
        fp.getChildren().addAll(
                over, tf, add, remove, stepAdd, stepRemove, clear);

        Scene scene = new Scene(fp, 775, 325);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void addButton() {

    }
}
