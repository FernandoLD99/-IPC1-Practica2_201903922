/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ipc;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author angel
 */
public final class BarChart extends ApplicationFrame {

    public JFreeChart barChart;

    public BarChart(String title, String chartTitle, DefaultCategoryDataset dataset) {
        super(title);
        this.barChart = ChartFactory.createBarChart(
            chartTitle,
            "x-axis",
            "y-axis",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);

    }

    public void crearImagen(String imagen) {
        int width = 640;
        /* Width of the image */
        int height = 480;
        /* Height of the image */
        File BarChart = new File(imagen);
        try {
            ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }
}

