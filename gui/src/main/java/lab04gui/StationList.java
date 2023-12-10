package lab04gui;

import lab04client.measurementStation.MeasurementStation;
import lab04client.measurementStation.MeasurementStationsParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StationList extends JFrame implements ActionListener {
    private JTextArea textArea1 = new JTextArea();
    JPanel buttonsPanel = new JPanel(new GridLayout(0, 1));
    private JScrollPane scrollPane = new JScrollPane(buttonsPanel);


    StationList(){
        setVisible(true);
        setTitle("Air quality");
        setTextArea1();
        add(scrollPane, BorderLayout.CENTER);
        setSize(800, 500);
        this.setLocationRelativeTo((Component)null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void setTextArea1(){
        StringBuilder string = new StringBuilder("Here are the measurement stations = \n");
        for(MeasurementStation o : MeasurementStationsParser.getMeasurementStationsList()){
            string.append("Station name = ").append(o.stationName).append(", adress street = ").append(o.adressStreet).append(", id = ").append(o.id).append(", city = ").append(o.city.name).append(".\n");
            buttonsPanel.add(createButton(o.stationName,o.id));
        }
//        System.out.println(string);
        textArea1.setText(string.toString());
    }
    private JButton createButton(String element, int id) {
        // Create a JButton for a given element
        JButton button = new JButton("See data for station " + element);
        button.setPreferredSize(new Dimension(200, 50));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click (you can add custom logic here)
                new AirQualityIndex(id);
            }
        });

        return button;
    }

    public static void main(String[] args) {
        new StationList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
