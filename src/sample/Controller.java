package sample;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import com.hubspot.jinjava.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    public Button buttonIncreaseProgressBar;
    public ProgressBar progressBar1;
    public TextArea textArea1;
    public TextField textFileName;
    public File newFile;
    public TextArea textRawTemplate;
    public String template;

    public void buttonAddProgress() {

        progressBar1.setProgress(progressBar1.getProgress() + .1);
        if (progressBar1.getProgress() > 1) progressBar1.setProgress(0);
        Map<String, Object> context = new HashMap();

        context.put("name", "Jared");


        try {
            File newFile = new File(textFileName.getText());
// doesnt seem to like the exact filename??

            template = Resources.toString(Resources.getResource(textFileName.getText().trim().toString()), Charsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace(); template = "failed to load file";
        }

//String renderedTemplate = jinjava.render(template, context);
        Jinjava newtest;
        newtest = new Jinjava();
        Map<String, Object> thing = new HashMap<>();
       thing.put("name","Jared");
        String a = new String();
        a = newtest.render(template, thing);

        textArea1.appendText(newtest.render("::::{{ name }}",thing));
        textArea1.appendText(a);
        loadRawTextArea();

    }
    //@FXML
    public void buttonChooseFile(ActionEvent event){
        FileChooser filechooser = new FileChooser();
        filechooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
                ,new FileChooser.ExtensionFilter("HTML Files", "*.html")
                ,new FileChooser.ExtensionFilter("Jinja2 Files","*.jinja"));
        File file = filechooser.showOpenDialog(null);
            if(file.isFile()) {
                System.out.printf(file.getAbsolutePath());
                textFileName.setText(null);
                textFileName.appendText(file.getName().toString());
                loadRawTextArea();
            }
       }

    public void loadRawTextArea(){
        try {
            File newFile = new File(textFileName.getText());
// doesnt seem to like the exact filename??
            String a = Resources.toString(Resources.getResource(textFileName.getText().trim().toString()), Charsets.UTF_8);
            textRawTemplate.setText(a);
            textRawTemplate.appendText("********vars*******\n");
            Jinjava newtest;
            newtest = new Jinjava();
            newtest.getJinjavaDoc();
            textRawTemplate.appendText(newtest.getExpressionFactory().toString());

        } catch (Exception e) {
            e.printStackTrace(); template = "failed to load file";
        }

    }

    }


