/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3.dsa.cheatham.javafx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author novem
 */
public class mp3_DSA_21_5 extends Application {

    String[] temp = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class",
        "continue", "default", "double", "do", "else",
        "enum", "extends", "final", "finally", "float",
        "for", "if", "implements", "import", "instanceof",
        "int", "interface", "long", "native", "new", "null",
        "package", "private", "protected", "public", "return",
        "short", "static", "strictftp", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient",
        "try", "void", "volatile", "while"};
    TreeSet<String> keywords = new TreeSet<>(Arrays.asList(temp));

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane fp = new FlowPane();
        primaryStage.setTitle("Print to HTML");
        TextArea ta = new TextArea();
        Button print = new Button("Print to HTML");
        print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> keywordsAlpha = new LinkedList<>(keywords);
                String str = ta.getText();
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = fc.showSaveDialog(fc);
                if (returnVal
                        == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    System.out.println(file.getAbsoluteFile());
                    String path = file.getAbsolutePath();
                    if (!file.getName().contains(".")) {

                        path = path + ".html";
                        file = new File(path);
                        System.out.println(file.getAbsoluteFile());
                    }
                    try (PrintWriter ps = new PrintWriter(file)) {
                        ps.println("<!DOCTYPE html>\n" + "<html>\n" + 
                                "<title>HTML Tutorial</title>\n" + "<head>\n" + 
                                "<style>\n" + "#keyword {\n" + "color: navy;\n" + 
                                "font-weight: 900;}\n" + "#comment {\n" + 
                                "color: green;\n" + "font-weight: 900;}\n" + 
                                "#literal {\n" + "color: blue;\n" + 
                                "font-weight: 900;}\n" + "</style>\n" + "</head>\n" + 
                                "<body>\n" + "<pre>\n");
                        for (int i = 0; i < keywordsAlpha.size(); i++) {
                            str = str.replaceAll(keywordsAlpha.get(i) + " ", 
                                  ("<span id=\"keyword\">" + keywordsAlpha.get(i) + 
                                   "</span>" + " "));
                        }
                        ps.println(str + " ");
                        ps.println("</pre>\n" + "\n" + "</body>\n" + "</html>");
                        ps.close();
                        try {
                            StringBuilder inputBuffer;
                            try (
                                BufferedReader br = new BufferedReader(new FileReader(file))) {
                                inputBuffer = new StringBuilder();
                                String line;
                                while ((line = br.readLine()) != null) {
                                    if (line.contains("//")) {
                                        if (line.contains("<span id=\"keyword\">"))
                                        {
                                            line = line.replaceAll("<span id=\"keyword\">", "");
                                            line = line.replaceAll("</span>", "");
                                        }                      
                                        line = "<span id=\"comment\">" + line + "</span>";
                                    }
                                    inputBuffer.append(line);
                                    inputBuffer.append('\n');
                                }
                                for (int i = 230; i < inputBuffer.length(); i++) {
                                    if (inputBuffer.charAt(i) == '='
                                            && inputBuffer.substring(i - 8, i).compareTo("<span id") != 0
                                            && inputBuffer.charAt(i - 1) != '='
                                            && inputBuffer.charAt(i + 1) != '=') {
                                        inputBuffer.insert(i + 1, "<span id=\"literal\">");
                                        for (int j = i + 19; j < inputBuffer.length(); j++) {

                                            if (inputBuffer.charAt(j) == ';'
                                                    || inputBuffer.charAt(j) == ',') {
                                                inputBuffer.insert(j, "</span>");
                                                i = j + 7;
                                                break;
                                            }
                                        }
                                    }

                                }
                            }
                            try (
                                    FileOutputStream fileOut = new FileOutputStream(file)) {
                                fileOut.write(inputBuffer.toString().getBytes());
                            }
                        } catch (IOException f) {
                            System.out.println("Problem reading file.");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(mp3_DSA_21_5.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        fp.setHgap(4);
        fp.getChildren().addAll(ta, print);

        Scene scene = new Scene(fp, 468, 260);
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

}
