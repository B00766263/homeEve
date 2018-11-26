package co.oxana;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

       // final GridLayout layout = new GridLayout(2,2);//master layout
        final VerticalLayout layout = new VerticalLayout();
        HorizontalLayout panels = new HorizontalLayout();
        GridLayout inputPanel = new GridLayout(1,2);//master layout
        layout.setWidth("800"); 
        VerticalLayout details = new VerticalLayout();
        VerticalLayout cell1 = new VerticalLayout();
        HorizontalLayout cell2 = new HorizontalLayout();//button
        //VerticalLayout cell3 = new VerticalLayout();
        //HorizontalLayout cell4 = new HorizontalLayout();
        
        //label at top content
        Label label = new Label("Staff details");

        //details contents

        final TextField staffNum = new TextField();
        staffNum.setCaption("Your staff number:");
        
        final TextField phone = new TextField();
        phone.setCaption("Type your name here:");

        final TextField name = new TextField();
        name.setCaption("Phone number:");


        //cell4 content
        Button add = new Button("add");
        add.addClickListener(e -> {
            layout.addComponent(new Label(staffNum.getValue() 
                                            + " " + name.getValue() + " " + phone.getValue()));

        });

        Button reset = new Button("Reset");
        reset.addClickListener(e -> {
           details.removeAllComponents();
        });
        //build layers

        cell1.addComponents(staffNum, name, phone);
        cell2.addComponents(add, reset);
        inputPanel.addComponents(cell1, cell2);
        panels.addComponents(inputPanel,details);
        //panels.setComponentAlignment(inputPanel, Alignment.MIDDLE_LEFT);
        //panels.setComponentAlignment(details, Alignment.MIDDLE_RIGHT);
        layout.addComponents(label, panels);
        layout.setSpacing(true);
        //cell4.addComponent(add, reset);

        //layout.addComponents(label, panels); 
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

