/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deteksiAnomaliKNN;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ViewportLayout;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableModel;
import koneksiMySQL.connect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;
/**
 *
 * @author asus
 */
public class frameUtama extends javax.swing.JFrame {

    public frameUtama() {
        initComponents();

        btnSubmit.setMnemonic('S');
        btnReset.setMnemonic('R');
        btnProses.setMnemonic('P');
        jButton1.setMnemonic('O');
        btnReset1.setMnemonic('R');
        btnSubmit1.setMnemonic('S');
        jButton2.setMnemonic('O');
        jButton3.setMnemonic('B');
        jButton4.setMnemonic('P');

        jButton1.setEnabled(false);
        btnProses.setEnabled(false);
        btnReset1.setEnabled(false);
        jButton2.setEnabled(false);
        btnSubmit1.setEnabled(false);
        btnReset.setEnabled(false);
        icon();

        model6.addColumn("Nomor Induk Siswa");
        model6.addColumn("Rata-rata Raport");
        model6.addColumn("Hasil Tes Psikologi");

        model2.addColumn("Nomor Induk Siswa");
        model2.addColumn("Rata-rata Raport");
        model2.addColumn("Hasil Tes Psikologi");

        model.addColumn("Rata-rata Raport");
        model.addColumn("Hasil Tes Psikologi");

        model4.addColumn("Nomor Induk Siswa");
        model4.addColumn("Rata-rata Raport");
        model4.addColumn("Hasil Tes Psikologi");
        model4.addColumn("Kelas");
        model4.addColumn("Jarak");
        model4.addColumn("Deteksi Anomali");

        model5.addColumn("IPA");
        model5.addColumn("IPS");

        model3.addColumn("NIS");
        model3.addColumn("Rata-rata Raport");
        model3.addColumn("Tes Psikologi");

        model7.addColumn("NIS");
        model7.addColumn("Rata-rata Raport");
        model7.addColumn("Tes Psikologi");
        model7.addColumn("Kelas");

        jTable1.setModel(model);
        jTable1.setUI(new frameUtama.CustomTableUI());
        isiData();
        isiData2();
        isiDataTesting();
        isiDataTraining();

        jTable4.setModel(model4);
        jTable4.setUI(new frameUtama.CustomTableUI());
        jTable5.setModel(model5);
        jTable5.setUI(new frameUtama.CustomTableUI());
        jTable6.setModel(model6);
        jTable6.setUI(new frameUtama.CustomTableUI());
        jTable2.setModel(model2);
        jTable2.setUI(new frameUtama.CustomTableUI());
        tabelTesting.setModel(model3);
        tabelTesting.setUI(new frameUtama.CustomTableUI());
        tabelTraining.setModel(model7);
        tabelTraining.setUI(new frameUtama.CustomTableUI());
    }

    public void icon() {
        ImageIcon ico = new ImageIcon("src/logoAplikasi.png");
        setIconImage(ico.getImage());
    }

    public JTextField getNIS() {
        return nis;
    }

    public JTextField getNilaiBI() {
        return bi;
    }

    public JTextField getNilaiBING() {
        return bing;
    }

    public JTextField getNilaiMTK() {
        return mtk;
    }

    public JTextField getNilaiKIM() {
        return kim;
    }

    public JTextField getNilaiBIO() {
        return bio;
    }

    public JTextField getNilaiFIS() {
        return fis;
    }

    public JTextField getNilaiEKO() {
        return eko;
    }

    public JTextField getNilaiGEO() {
        return geo;
    }

    public JTextField getNilaiSEJ() {
        return sej;
    }

    public JTextField getNilaiTestPsikolog() {
        return testPsikolog;
    }
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel model2 = new DefaultTableModel();
    private DefaultTableModel model3 = new DefaultTableModel();
    private DefaultTableModel model4 = new DefaultTableModel();
    private DefaultTableModel model5 = new DefaultTableModel();
    private DefaultTableModel model6 = new DefaultTableModel();
    private DefaultTableModel model7 = new DefaultTableModel();
    public static int i;

    public void isiData() {
        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT `NIS`, `rata2Raport`, `TestPsikologi` FROM data_testing");
            while (result.next()) {
                model6.addRow(new Object[]{
                    result.getString(1), result.getString(2), result.getString(3)
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Gagal Mengisi!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void isiData2() {
        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT `NIS`, `rata2Raport`, `TestPsikologi` FROM data_testing");
            while (result.next()) {
                model2.addRow(new Object[]{
                    result.getString(1), result.getString(2), result.getString(3)
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Gagal Mengisi!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void isiDataTesting() {
        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT `NIS`, `rata2Raport`, `TestPsikologi` FROM data_testing");
            while (result.next()) {
                model3.addRow(new Object[]{
                    result.getString(1), result.getString(2), result.getString(3)
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Gagal Mengisi!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void isiDataTraining() {
        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT `NIS`, `rata2Raport`, `TestPsikologi`, `kelas` FROM data_training");
            while (result.next()) {
                model7.addRow(new Object[]{
                    result.getString(1), result.getString(2), result.getString(3), result.getString(4)
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Gagal Mengisi!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void klikSubmit() {
        String nis = getNIS().getText();
        int NIS = Integer.parseInt(nis);
        String nilaiBI = getNilaiBI().getText();
        int BI = Integer.parseInt(nilaiBI);
        String nilaiBING = getNilaiBING().getText();
        int BING = Integer.parseInt(nilaiBING);
        String nilaiMTK = getNilaiMTK().getText();
        int MTK = Integer.parseInt(nilaiMTK);
        String nilaiKIM = getNilaiKIM().getText();
        int KIM = Integer.parseInt(nilaiKIM);
        String nilaiBIO = getNilaiBIO().getText();
        int BIO = Integer.parseInt(nilaiBIO);
        String nilaiFIS = getNilaiFIS().getText();
        int FIS = Integer.parseInt(nilaiFIS);
        String nilaiEKO = getNilaiEKO().getText();
        int EKO = Integer.parseInt(nilaiEKO);
        String nilaiGEO = getNilaiGEO().getText();
        int GEO = Integer.parseInt(nilaiGEO);
        String nilaiSEJ = getNilaiSEJ().getText();
        int SEJ = Integer.parseInt(nilaiSEJ);
        String nilaiTestPsikolog = getNilaiTestPsikolog().getText();
        int TEST = Integer.parseInt(nilaiTestPsikolog);
        float rata = (BIO + KIM + FIS + MTK + BI + BING + GEO + EKO + SEJ) / 9;

        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM data_training WHERE  NIS='" + NIS + "'");
            if (result.next()) {
                JOptionPane.showMessageDialog(null, "Data Sudah Ada", "Peringatan", 2);
            } else {
                statement.executeUpdate("INSERT INTO data_testing (NIS, rata2Raport, TestPsikologi) "
                        + "VALUES ('" + NIS + "','" + rata + "','" + TEST + "');");

                JOptionPane.showMessageDialog(null, "Input Data Berhasil", "Informasi Program",
                        JOptionPane.INFORMATION_MESSAGE);
                kosongkanTabel6();
                kosongkanTabel2();
                isiData();
                isiData2();
                btnSubmit.setEnabled(false);
                btnReset.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Koneksi Database Gagal!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void cariData2() {
        String input = cariNIS.getText();
        if (input.length() != 0) {
            try {
                Statement statement = connect.getConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT NIS, rata2Raport, TestPsikologi"
                        + " FROM data_testing WHERE  NIS='" + input + "'");
                int index = 1;
                while (result.next()) {
                    model.addRow(new Object[]{
                        result.getString(2), result.getString(3)
                    });

                    index++;
                }
                result.close();
                statement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Eror: " + e, "Gagal Mencari!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void kosongkanTabel1() {
        int baris = model.getRowCount();
        for (int i = 0; i < baris; i++) {
            model.removeRow(0);
        }
        jTable1.setModel(model);
    }

    public void kosongkanTabel4() {
        int baris = model4.getRowCount();
        for (int i = 0; i < baris; i++) {
            model4.removeRow(0);
        }
        jTable4.setModel(model4);
    }

    public void kosongkanTabel5() {
        int baris = model5.getRowCount();
        for (int i = 0; i < baris; i++) {
            model5.removeRow(0);
        }
        jTable5.setModel(model5);
    }

    public void kosongkanTabel6() {
        int baris = model6.getRowCount();
        for (int i = 0; i < baris; i++) {
            model6.removeRow(0);
        }
        jTable6.setModel(model6);
    }

    public void kosongkanTabel2() {
        int baris = model2.getRowCount();
        for (int i = 0; i < baris; i++) {
            model2.removeRow(0);
        }
        jTable2.setModel(model2);
    }

    public void kosongkanTabelTesting() {
        int baris = model3.getRowCount();
        for (int i = 0; i < baris; i++) {
            model3.removeRow(0);
        }
        tabelTesting.setModel(model3);
    }

    public void kosongkanTabelTraining() {
        int baris = model7.getRowCount();
        for (int i = 0; i < baris; i++) {
            model7.removeRow(0);
        }
        tabelTraining.setModel(model7);
    }
    public String Deteksi;
    public static float jm;

    public void knn() {
        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT `NIS`, `rata2Raport`, `TestPsikologi`, `kelas` FROM data_training");

            int index = 1, i;
            float eu, jml = 0, a, b;
            int n = Integer.parseInt(NAMA.getText());
            
            kosongkanTabel4();
            do {
                if (result.next()) {
                    for (i = 2; i <= 3; i++) {
                        a = result.getFloat(i);
                        System.out.println(index + "a " + a);
                        b = Float.parseFloat(model.getValueAt(0, i - 2).toString());
                        System.out.println(index + "b " + b);
                        eu = (float) Math.pow((a - b), 2);
                        jml = jml + eu;
                        System.out.println(index + "jm " + jml);
                    }
                    jm = (float) Math.sqrt(jml);
                    jml = 0;
                    if (jm >= 50) {
                        Deteksi = "Anomali";
                    } else {
                        Deteksi = "Bukan Anomali";
                    }
                    model4.addRow(new Object[]{
                        result.getInt(1), result.getFloat(2), result.getInt(3), result.getString(4), jm, Deteksi
                    });
                }
                if (jm == 0) {
                    System.out.println(index + "i " + index);
                    model4.removeRow(index - 1);
                    index--;
                }

                index++;
            } while (index <= n);
            
            result.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "KNN Gagal!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void tempor() {
        try {
            Statement statement = connect.getConnection().createStatement();
            int x = model4.getRowCount();
            for (int n = 0; n < x; n++) {
                statement.executeUpdate("INSERT INTO temporari (NIS, rata2Raport, psikologi, kelas, jarak, deteksi) VALUES "
                        + "(" + Integer.parseInt(jTable4.getValueAt(n, 0).toString()) + "," + Float.parseFloat(jTable4.getValueAt(n, 1).toString())
                        + "," + Integer.parseInt(jTable4.getValueAt(n, 2).toString()) + ",'" + jTable4.getValueAt(n, 3).toString()
                        + "'," + Float.parseFloat(jTable4.getValueAt(n, 4).toString()) + ",'" + jTable4.getValueAt(n, 5).toString() + "')");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Database Tempor Gagal!", JOptionPane.WARNING_MESSAGE);
        }
    }
    public String ano;
    public String kl;

    public void getkelas() {
        int k = Integer.parseInt(jTextField2.getText());
        int baris = model5.getRowCount();
        for (int i = 0; i < baris; i++) {
            model5.removeRow(0);
        }
        jTable5.setModel(model5);

        float rt = Float.parseFloat(jTable1.getValueAt(0, 0).toString());
        float ps = Float.parseFloat(jTable1.getValueAt(0, 1).toString());
        float r2 = (float) Math.pow(rt, 2);
        float p2 = (float) Math.pow(ps, 2);
        float jr = (float) Math.sqrt(r2 + p2);
        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM temporari ORDER BY temporari.jarak ASC");
            kosongkanTabel4();

            while (result.next()) {
                if (result.getFloat(5) >= 50) {
                    ano = "Anomali";
                } else {
                    ano = "Bukan Anomali";
                }
                model4.addRow(new Object[]{
                    result.getString(1), result.getFloat(2), result.getInt(3), result.getString(4), result.getFloat(5), ano
                });
            }

            int ipa = 0, ips = 0;
            for (int i = 0; i < k; i++) {
                if (model4.getValueAt(i, 3).toString().equals("IPA")) {
                    ipa++;
                }
                if (model4.getValueAt(i, 3).toString().equals("IPS")) {
                    ips++;
                }
            }

            model5.addRow(new Object[]{
                ipa, ips
            });
            if (ipa > ips) {
                kl = "IPA";
                tx_hasilKlasifikasi.setText("Karena jumlah kelas IPA > jumlah kelas IPS dengan k = " + k + ", maka siswa tersebut masuk pada kelas IPA.");
            } else {
                kl = "IPS";
                tx_hasilKlasifikasi.setText("Karena jumlah kelas IPS > jumlah kelas IPA dengan k = " + k + ", maka siswa tersebut masuk pada kelas IPS.");
            }

            result.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Gagal Sorting!", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void inputTesting() {
        String nistest = NISTesting.getText();
        Integer NIS = Integer.parseInt(nistest);
        String rata2 = rataTesting.getText();
        Float RATA2 = Float.parseFloat(rata2);
        String psikologi = psikologiTesting.getText();
        Integer PSIKOLOGI = Integer.parseInt(psikologi);

        try {
            Statement statement = connect.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO data_testing(NIS, rata2Raport, TestPsikologi)"
                    + " VALUES ('" + NIS + "','" + RATA2 + "','" + PSIKOLOGI + "');");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Telah Ditambahkan");
            kosongkanTabelTesting();
            isiDataTesting();
            kosongkanTabel6();
            kosongkanTabel2();
            isiData();
            isiData2();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Koneksi Database Gagal!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void inputTraining() {
        String nistest = NISTraining.getText();
        Integer NIS = Integer.parseInt(nistest);
        String rata2 = rataTraining.getText();
        Float RATA2 = Float.parseFloat(rata2);
        String psikologi = psikologiTraining.getText();
        Integer PSIKOLOGI = Integer.parseInt(psikologi);
        String kelas = kelasTraining.getText();


        try {
            Statement statement = connect.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO data_training(NIS, rata2Raport, TestPsikologi, kelas)"
                    + " VALUES ('" + NIS + "','" + RATA2 + "','" + PSIKOLOGI + "','" + kelas + "');");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Telah Ditambahkan");
            kosongkanTabelTraining();
            isiDataTraining();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Koneksi Database Gagal!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void updateTesting() {
        String nisCari = cariNIS1.getText();
        String nistest = NISTesting.getText();
        Integer NIS = Integer.parseInt(nistest);
        String rata2 = rataTesting.getText();
        Float RATA2 = Float.parseFloat(rata2);
        String psikologi = psikologiTesting.getText();
        Integer PSIKOLOGI = Integer.parseInt(psikologi);


        try {
            Statement statement = connect.getConnection().createStatement();
            statement.executeUpdate("UPDATE data_testing SET `NIS`='" + nistest + "' WHERE `NIS` = '" + nisCari + "'");
            statement.executeUpdate("UPDATE data_testing SET `rata2Raport`='" + rata2 + "' WHERE `NIS` = '" + nisCari + "'");
            statement.executeUpdate("UPDATE data_testing SET `TestPsikologi`='" + psikologi + "' WHERE `NIS` = '" + nisCari + "'");

            JOptionPane.showMessageDialog(null, "Data Telah Diupdate");
            statement.close();
            kosongkanTabelTesting();
            isiDataTesting();
            kosongkanTabel6();
            kosongkanTabel2();
            isiData();
            isiData2();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Koneksi Database Gagal!", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void updateTraining() {
        String nisCari = cariNIS2.getText();
        String nistest = NISTraining.getText();
        Integer NIS = Integer.parseInt(nistest);
        String rata2 = rataTraining.getText();
        Float RATA2 = Float.parseFloat(rata2);
        String psikologi = psikologiTraining.getText();
        Integer PSIKOLOGI = Integer.parseInt(psikologi);
        String kelas = kelasTraining.getText();



        try {
            Statement statement = connect.getConnection().createStatement();
            statement.executeUpdate("UPDATE data_training SET `NIS`='" + nistest + "' WHERE `NIS` = '" + nisCari + "'");
            statement.executeUpdate("UPDATE data_training SET `rata2Raport`='" + rata2 + "' WHERE `NIS` = '" + nisCari + "'");
            statement.executeUpdate("UPDATE data_training SET `TestPsikologi`='" + psikologi + "' WHERE `NIS` = '" + nisCari + "'");
            statement.executeUpdate("UPDATE data_training SET `kelas`='" + kelas + "' WHERE `NIS` = '" + nisCari + "'");

            JOptionPane.showMessageDialog(null, "Data Telah Diupdate");
            statement.close();
            kosongkanTabelTraining();
            isiDataTraining();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: " + e, "Koneksi Database Gagal!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteTesting() {
        String nis = NISTesting.getText();
        if (nis.length() != 0) {

            try {
                Statement statement = connect.getConnection().createStatement();

                int n = JOptionPane.showConfirmDialog(null, "Apa Anda yakin menghapus data ini?", "Konfirmasi Delete",
                        JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    statement.executeUpdate("DELETE FROM data_testing WHERE (NIS) like '" + nis + "'");
                }
                statement.close();
                NISTesting.setText("");
                rataTesting.setText("");
                psikologiTesting.setText("");
                JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
                kosongkanTabelTesting();
                isiDataTesting();
                kosongkanTabel6();
                kosongkanTabel2();
                isiData();
                isiData2();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Eror: " + e, "Koneksi Database Gagal!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Klik baris pada tabel, sebelum melakukan hapus data.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteTraining() {
        String nis = NISTraining.getText();
        if (nis.length() != 0) {

            try {
                Statement statement = connect.getConnection().createStatement();

                int n = JOptionPane.showConfirmDialog(null, "Apa Anda yakin menghapus data ini?", "Konfirmasi Delete",
                        JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    statement.executeUpdate("DELETE FROM data_training WHERE (NIS) like '" + nis + "'");
                }
                statement.close();
                NISTraining.setText("");
                rataTraining.setText("");
                psikologiTraining.setText("");
                kelasTraining.setText("");
                JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
                kosongkanTabelTraining();
                isiDataTraining();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Eror: " + e, "Koneksi Database Gagal!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Klik baris pada tabel, sebelum melakukan hapus data.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
     public void resetDataTesting() {

            nis.setText("");
            bi.setText("");
            bing.setText("");
            mtk.setText("");
            fis.setText("");
            bio.setText("");
            kim.setText("");
            eko.setText("");
            geo.setText("");
            sej.setText("");
            testPsikolog.setText("");
          
     }

   public class CustomTableUI extends BasicTableUI {
 
    private final Color EVEN_ROW_COLOR = new Color(241, 245, 250);
    private PropertyChangeListener fAncestorPropertyChangeListener =
            createAncestorPropertyChangeListener();
 
    public void installUI(JComponent c) {
        super.installUI(c);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(false);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
 
        table.addPropertyChangeListener("ancestor", fAncestorPropertyChangeListener);
    }
 
    private PropertyChangeListener createAncestorPropertyChangeListener() {
        return new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                // indicate that the parent of the JTable has changed.
                parentDidChange();
            }
        };
    }
 
    private void parentDidChange() {
        if (table.getParent() instanceof JViewport && table.getParent().getParent() instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
            scrollPane.getViewport().setLayout(new frameUtama.CustomTableUI.BugFixedViewportLayout());
        }
    }

    public void paint(Graphics g, JComponent c) {
        int rowAtPoint = table.rowAtPoint(g.getClipBounds().getLocation());
        int topY = rowAtPoint < 0 ? g.getClipBounds().y : table.getCellRect(rowAtPoint, 0, true).y;
        int currentRow = rowAtPoint < 0 ? 0 : rowAtPoint;
        while (topY < g.getClipBounds().y + g.getClipBounds().height) {
            int bottomY = topY + table.getRowHeight();
            g.setColor(getRowColor(currentRow));
            g.fillRect(g.getClipBounds().x, topY, g.getClipBounds().width, bottomY);
            topY = bottomY;
            currentRow++;
        }
 
        super.paint(g, c);
    }
 
    private Color getRowColor(int row) {
        return row % 2 == 0 ? EVEN_ROW_COLOR : table.getBackground();
    }
 
    // Memodifikasi Viewport untuk JTable
    private class BugFixedViewportLayout extends ViewportLayout {

        public void layoutContainer(Container parent) {
            JViewport vp = (JViewport) parent;
            Component view = vp.getView();
 
            if (view == null) {
                return;
            }
 
            Point viewPosition = vp.getViewPosition();
            Dimension viewPrefSize = view.getPreferredSize();
            Dimension vpSize = vp.getSize();
            Dimension viewSize = new Dimension(viewPrefSize);
 
            if ((viewPosition.x == 0) && (vpSize.width > viewPrefSize.width)) {
                viewSize.width = vpSize.width;
            }
 
            if ((viewPosition.y == 0) && (vpSize.height > viewPrefSize.height)) {
                viewSize.height = vpSize.height;
            }
 
            if (!viewSize.equals(viewPrefSize)) {
                vp.setViewSize(viewSize);
            }
        }
    }

         
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        nis = new javax.swing.JTextField();
        bi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bio = new javax.swing.JTextField();
        sej = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bing = new javax.swing.JTextField();
        fis = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        testPsikolog = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        mtk = new javax.swing.JTextField();
        eko = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        geo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        kim = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        cariNIS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnProses = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnReset1 = new javax.swing.JButton();
        NAMA = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tx_hasilKlasifikasi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnSubmit1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTraining = new javax.swing.JTable();
        NISTesting = new javax.swing.JTextField();
        rataTesting = new javax.swing.JTextField();
        psikologiTesting = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelTesting = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        NISTraining = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        rataTraining = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        psikologiTraining = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        kelasTraining = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        cariNIS1 = new javax.swing.JTextField();
        cariNIS2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Deteksi Anomali Menggunakan Metode KNN by Kelompok - 4");

        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(36, 36, 166));

        jLabel22.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel22.setForeground(java.awt.Color.yellow);
        jLabel22.setText("Sistem Deteksi Anomali Nilai Siswa");
        jPanel5.add(jLabel22);

        jLabel27.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel27.setForeground(java.awt.Color.white);
        jLabel27.setText("Menggunakan Metode KNN");
        jPanel5.add(jLabel27);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 950, 140);

        jSeparator1.setBackground(java.awt.Color.red);
        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 140, 950, 4);

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setText("NIS");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 190, 90, 21);
        jPanel1.add(nis);
        nis.setBounds(10, 220, 120, 30);
        jPanel1.add(bi);
        bi.setBounds(10, 290, 80, 30);

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel6.setText("BI");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 260, 90, 21);

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel13.setText("BIO");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(100, 260, 90, 21);
        jPanel1.add(bio);
        bio.setBounds(100, 290, 90, 30);
        jPanel1.add(sej);
        sej.setBounds(200, 290, 90, 30);

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel17.setText("SEJ");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(200, 260, 90, 21);

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel10.setText("BING");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 330, 90, 21);
        jPanel1.add(bing);
        bing.setBounds(10, 360, 80, 30);
        jPanel1.add(fis);
        fis.setBounds(100, 360, 90, 30);

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel14.setText("FIS");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(100, 330, 90, 21);

        jLabel18.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel18.setText("Test Psikologi");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(200, 330, 110, 21);
        jPanel1.add(testPsikolog);
        testPsikolog.setBounds(200, 360, 90, 30);

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel9.setText("MTK");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 400, 90, 21);
        jPanel1.add(mtk);
        mtk.setBounds(10, 430, 80, 30);
        jPanel1.add(eko);
        eko.setBounds(100, 430, 90, 30);

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel15.setText("EKO");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(100, 400, 90, 21);

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel11.setText("GEO");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 470, 90, 21);
        jPanel1.add(geo);
        geo.setBounds(100, 500, 90, 30);

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel12.setText("KIM");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 470, 90, 21);
        jPanel1.add(kim);
        kim.setBounds(10, 500, 80, 30);

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit);
        btnSubmit.setBounds(200, 420, 130, 50);

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset);
        btnReset.setBounds(200, 480, 130, 50);

        jTable6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jPanel1.add(jScrollPane6);
        jScrollPane6.setBounds(360, 220, 570, 310);

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel8.setText("Data Testing");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(360, 171, 150, 40);

        jTabbedPane1.addTab("Input Data  ", jPanel1);

        jPanel2.setLayout(null);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(10, 200, 100, 30);

        cariNIS.setEnabled(false);
        cariNIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariNISMouseClicked(evt);
            }
        });
        cariNIS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariNISKeyPressed(evt);
            }
        });
        jPanel2.add(cariNIS);
        cariNIS.setBounds(10, 280, 100, 30);

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel5.setText("Jarak Terdekat (k)");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 170, 180, 21);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel3.setText("No. Induk");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 250, 61, 21);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(120, 260, 110, 50);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(10, 360, 330, 60);

        btnProses.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProses.setText("Process");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });
        jPanel2.add(btnProses);
        btnProses.setBounds(10, 430, 330, 90);

        jPanel6.setBackground(new java.awt.Color(36, 36, 166));

        jLabel28.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel28.setForeground(java.awt.Color.yellow);
        jLabel28.setText("Sistem Deteksi Anomali Nilai Siswa");
        jPanel6.add(jLabel28);

        jLabel30.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel30.setForeground(java.awt.Color.white);
        jLabel30.setText("Menggunakan Metode KNN");
        jPanel6.add(jLabel30);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(0, 0, 950, 140);

        jSeparator2.setBackground(java.awt.Color.red);
        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 140, 950, 4);

        btnReset1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset1);
        btnReset1.setBounds(240, 260, 120, 50);

        NAMA.setForeground(new java.awt.Color(255, 255, 255));
        NAMA.setText("jLabel76");
        jPanel2.add(NAMA);
        NAMA.setBounds(260, 290, 40, 14);

        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(380, 210, 550, 310);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel1.setText("Data Testing");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(380, 160, 170, 40);

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel2.setText("Fitur");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 330, 60, 21);

        jTabbedPane1.addTab("Proses Data Uji", jPanel2);

        jPanel3.setLayout(null);

        tx_hasilKlasifikasi.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jPanel3.add(tx_hasilKlasifikasi);
        tx_hasilKlasifikasi.setBounds(10, 510, 870, 30);

        jTable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable4);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 920, 150);

        jTable5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(10, 400, 240, 50);

        jLabel25.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel25.setText("Hasil Sorting Penghitungan Jarak Euclidian");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(10, 160, 400, 30);

        jLabel26.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel26.setText("Jumlah Kelas K Tetangga Terdekat ");
        jPanel3.add(jLabel26);
        jLabel26.setBounds(10, 370, 250, 21);

        jPanel7.setBackground(new java.awt.Color(36, 36, 166));

        jLabel33.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel33.setForeground(java.awt.Color.yellow);
        jLabel33.setText("Sistem Deteksi Anomali Nilai Siswa");
        jPanel7.add(jLabel33);

        jLabel34.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel34.setForeground(java.awt.Color.white);
        jLabel34.setText("Menggunakan Metode KNN");
        jPanel7.add(jLabel34);

        jPanel3.add(jPanel7);
        jPanel7.setBounds(0, 0, 950, 140);

        jSeparator3.setBackground(java.awt.Color.red);
        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jSeparator3);
        jSeparator3.setBounds(0, 140, 950, 4);

        btnSubmit1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmit1.setText("Save");
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSubmit1);
        btnSubmit1.setBounds(10, 460, 240, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("ScatterPlot Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(270, 400, 153, 110);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Bar Chart");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(430, 400, 160, 110);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Pie Chart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(600, 400, 160, 110);

        jTabbedPane1.addTab("Hasil KNN", jPanel3);

        jPanel4.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(36, 36, 166));

        jLabel35.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel35.setForeground(java.awt.Color.yellow);
        jLabel35.setText("Sistem Deteksi Anomali Nilai Siswa");
        jPanel8.add(jLabel35);

        jLabel36.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel36.setForeground(java.awt.Color.white);
        jLabel36.setText("Menggunakan Metode KNN");
        jPanel8.add(jLabel36);

        jPanel4.add(jPanel8);
        jPanel8.setBounds(0, 0, 950, 140);

        jSeparator4.setBackground(java.awt.Color.red);
        jSeparator4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jSeparator4);
        jSeparator4.setBounds(0, 140, 950, 4);

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel4.setText("Tabel Data Training");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(470, 150, 190, 40);

        tabelTraining.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelTraining.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTraining.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTrainingMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelTraining);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(470, 190, 452, 120);
        jPanel4.add(NISTesting);
        NISTesting.setBounds(20, 350, 90, 30);
        jPanel4.add(rataTesting);
        rataTesting.setBounds(20, 420, 90, 30);
        jPanel4.add(psikologiTesting);
        psikologiTesting.setBounds(20, 490, 90, 30);

        jLabel16.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel16.setText("Tes Psikologi");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(20, 460, 130, 30);

        jLabel19.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel19.setText("NIS");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(20, 320, 40, 30);

        jLabel20.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel20.setText("Rata2 Raport");
        jPanel4.add(jLabel20);
        jLabel20.setBounds(20, 390, 120, 30);

        tabelTesting.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelTesting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTesting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTestingMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelTesting);

        jPanel4.add(jScrollPane7);
        jScrollPane7.setBounds(10, 190, 400, 120);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(330, 350, 80, 170);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);
        jButton6.setBounds(130, 350, 80, 170);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);
        jButton7.setBounds(230, 350, 80, 170);

        jLabel21.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel21.setText("NIS");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(470, 320, 40, 30);
        jPanel4.add(NISTraining);
        NISTraining.setBounds(470, 350, 90, 30);

        jLabel23.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel23.setText("Rata2 Raport");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(590, 320, 120, 30);
        jPanel4.add(rataTraining);
        rataTraining.setBounds(590, 350, 90, 30);

        jLabel24.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel24.setText("Tes Psikologi");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(710, 320, 130, 30);
        jPanel4.add(psikologiTraining);
        psikologiTraining.setBounds(710, 350, 90, 30);

        jLabel29.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel29.setText("Kelas");
        jPanel4.add(jLabel29);
        jLabel29.setBounds(830, 320, 40, 30);
        jPanel4.add(kelasTraining);
        kelasTraining.setBounds(830, 350, 90, 30);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);
        jButton8.setBounds(470, 400, 140, 120);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Edit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9);
        jButton9.setBounds(630, 400, 140, 120);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10);
        jButton10.setBounds(790, 400, 130, 120);

        jLabel31.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel31.setText("Tabel Data Testing");
        jPanel4.add(jLabel31);
        jLabel31.setBounds(10, 150, 190, 40);
        jPanel4.add(cariNIS1);
        cariNIS1.setBounds(240, 400, 6, 20);
        jPanel4.add(cariNIS2);
        cariNIS2.setBounds(670, 470, 59, 20);

        jTabbedPane1.addTab("Manipulasi Data", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(953, 621));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        // TODO add your handling code here:
        kosongkanTabel1();
        kosongkanTabel4();
        kosongkanTabel5();
        cariNIS.setText("");

        btnProses.setEnabled(false);
        jButton2.setEnabled(false);
        btnSubmit1.setEnabled(false);
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        String input = cariNIS.getText();

        if (i != 1) {
            try {
                Statement statement = connect.getConnection().createStatement();
                statement.executeUpdate("TRUNCATE TABLE temporari");

            } catch (Exception e) {
            }
            if (jTextField2.getText().matches("[a-z]*")) {
                JOptionPane.showMessageDialog(null, "Kolom [Jarak Terdekat] tidak boleh diisi dengan huruf", "Peringatan", 2);
            } else {
                knn();
                tempor();
                getkelas();

                JOptionPane.showMessageDialog(null, "Proses Selesai", "Informasi Program",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            btnReset1.setEnabled(true);
            jButton2.setEnabled(true);
            btnSubmit1.setEnabled(true);



        }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String input = cariNIS.getText();
        try {
            Statement statement = connect.getConnection().createStatement();
            ResultSet result2 = statement.executeQuery("SELECT COUNT(*) as jml FROM data_training");
            if (result2.next()) {
                NAMA.setText(result2.getString("jml"));
                System.out.println(result2.getString("jml"));
            }
        } catch (Exception e) {
        }

        if (cariNIS.getText().matches("[a-z]*")) {
            JOptionPane.showMessageDialog(null, "Kolom [No. Induk] harus diisi dengan angka", "Peringatan", 2);
        } else {
            int baris = model.getRowCount();
            for (int i = 0; i < baris; i++) {
                model.removeRow(0);
            }
            jTable1.setModel(model);
            cariData2();
        }
        btnProses.setEnabled(true);
        btnReset1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cariNISKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariNISKeyPressed
        // TODO add your handling code here:
        jButton1.setEnabled(true);
    }//GEN-LAST:event_cariNISKeyPressed

    private void cariNISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariNISMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cariNISMouseClicked

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        cariNIS.setEnabled(true);
    }//GEN-LAST:event_jTextField2KeyPressed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetDataTesting();
        btnSubmit.setEnabled(true);
        btnReset.setEnabled(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        klikSubmit();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        // TODO add your handling code here:

        String input = cariNIS.getText();
        try {
            Statement statement = connect.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM `data_testing` WHERE NIS='" + input + "'");
            statement.executeUpdate("INSERT INTO data_training VALUES "
                    + "(" + Integer.parseInt(input) + "," + Float.parseFloat(jTable1.getValueAt(0, 0).toString())
                    + "," + Integer.parseInt(jTable1.getValueAt(0, 1).toString()) + ",'" + kl + "')");
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan", "Informasi Program",
                    JOptionPane.INFORMATION_MESSAGE);
            kosongkanTabel6();
            kosongkanTabel2();
            isiData();
            isiData2();
            kosongkanTabelTraining();
            kosongkanTabelTesting();
            isiDataTraining();
            isiDataTesting();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int i = 0;
            XYSeriesCollection seri = new XYSeriesCollection();
            XYSeries series1 = new XYSeries("Kelas IPA");
            XYSeries series2 = new XYSeries("Kelas IPS");
            XYSeries series3 = new XYSeries("Data Testing");
            Statement statement = connect.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT `rata2Raport`, `TestPsikologi`, `kelas`  FROM data_training");
            while (result.next()) {
                if (result.getString(3).equals("IPA")) {
                    series1.add(result.getFloat(1), result.getFloat(2));
                }
                if (result.getString(3).equals("IPS")) {
                    series2.add(result.getFloat(1), result.getFloat(2));
                }
            }
            series3.add(Integer.parseInt(jTable1.getValueAt(0, 0).toString()), Integer.parseInt(jTable1.getValueAt(0, 1).toString()));
            seri.addSeries(series1);
            seri.addSeries(series2);
            seri.addSeries(series3);
            JFreeChart chart = ChartFactory.createScatterPlot("Visualisasi Jarak Data Uji dan Data Training", "Rata-rata Raport", "Tes Psikologi", seri, PlotOrientation.VERTICAL, true, true, false);

            Shape ellips = new Ellipse2D.Double(0, 0, 4, 4);
            Shape rect = new Rectangle2D.Double(0, 0, 4, 4);
            Shape cross = ShapeUtilities.createDiagonalCross(4, 1);

            XYPlot xyPlot = (XYPlot) chart.getPlot();

            XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();

            // set line dan shape untuk series 1
            renderer2.setSeriesLinesVisible(0, false);
            renderer2.setSeriesShapesVisible(0, true);

            // set line dan shape untuk series 2
            renderer2.setSeriesLinesVisible(1, false);
            renderer2.setSeriesShapesVisible(1, true);

            // set line dan shape untuk series 3 / series centroid 1
            renderer2.setSeriesLinesVisible(3, false);
            renderer2.setSeriesShapesVisible(3, true);

            // set line dan shape untuk series 4 / series centroid 2
            renderer2.setSeriesLinesVisible(3, false);
            renderer2.setSeriesShapesVisible(3, true);

            xyPlot.setRenderer(renderer2); // draw plotting all series

            // set only shape of series with index i
            renderer2.setSeriesShape(0, rect); // series 1
            renderer2.setSeriesShape(1, ellips); // series 2
            renderer2.setSeriesShape(2, cross); // series 3

            renderer2.setSeriesPaint(2, Color.GREEN);
            renderer2.setSeriesPaint(0, Color.BLUE); // series 1
            renderer2.setSeriesPaint(1, Color.RED); // series 2 NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();

            NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
            domain.setRange(0, 100.00);
            domain.setTickUnit(new NumberTickUnit(20.0));
            domain.setVerticalTickLabels(false);
            NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
            range.setRange(0, 300.0);
            range.setTickUnit(new NumberTickUnit(20.0));
            range.setVerticalTickLabels(false);
            ChartFrame frame = new ChartFrame("Ilustrasi ScatterPlot Diagram", chart);
            frame.setVisible(true);
            frame.setSize(650, 650);
            chart.setBackgroundPaint(Color.YELLOW);
            chart.getTitle().setPaint(Color.BLUE);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.WHITE);
            //this.add(new ChartPanel(chart, 500, 500, 500, 500, 500, 500,false, true, true, true, true, true));
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            String query = "select kelas, jarak from temporari ORDER BY jarak";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(connect.koneksi, query);
            JFreeChart chart = ChartFactory.createBarChart3D("Visualisasi Jarak Data dan Kelas", "Kelas", "Jarak Euclidian", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Ilustrasi Bar Diagram", chart);
            frame.setVisible(true);
            frame.setSize(400, 650);
            chart.setBackgroundPaint(Color.YELLOW);
            chart.getTitle().setPaint(Color.BLUE);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.WHITE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            String query = "SELECT `deteksi`, COUNT( `jarak` ) FROM `temporari`"
                    + "WHERE deteksi IN ('Anomali', 'Bukan Anomali') GROUP BY deteksi";
            JDBCPieDataset pieDataset = new JDBCPieDataset(connect.koneksi, query);

            pieDataset.executeQuery(query);
            JFreeChart chart = ChartFactory.createPieChart3D("Visualisasi Perbandingan Anomali", pieDataset, true, true, false);
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Ilustrasi Pie Diagram", chart);
            frame.setVisible(true);
            frame.setSize(400, 650);
            chart.setBackgroundPaint(Color.YELLOW);
            chart.getTitle().setPaint(Color.BLUE);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.WHITE);

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void tabelTestingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTestingMouseClicked
        // TODO add your handling code here:
        try {
            int row = tabelTesting.getSelectedRow();
            String tabelKlik = (tabelTesting.getModel().getValueAt(row, 0).toString());
            String sql = "select * from data_testing where NIS='" + tabelKlik + "'";
            PreparedStatement pst = connect.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String add0 = rs.getString("NIS");
                cariNIS1.setText(add0);
                String add1 = rs.getString("NIS");
                NISTesting.setText(add1);
                String add2 = rs.getString("rata2Raport");
                rataTesting.setText(add2);
                String add3 = rs.getString("TestPsikologi");
                psikologiTesting.setText(add3);
            }

        } catch (SQLException ex) {
            Logger.getLogger(frameUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelTestingMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String nis = NISTesting.getText();
        String rata2 = rataTesting.getText();
        String psikologi = psikologiTesting.getText();
        if (nis.length() != 0 && rata2.length() != 0 && psikologi.length() != 0) {
            inputTesting();
        } else {
            JOptionPane.showMessageDialog(null, "Data belum lengkap, silahkan lengkapi terlebih dulu sebelum menambah data.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        deleteTesting();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabelTrainingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTrainingMouseClicked
        // TODO add your handling code here:
        try {
            int row = tabelTraining.getSelectedRow();
            String tabelKlik = (tabelTraining.getModel().getValueAt(row, 0).toString());
            String sql = "select * from data_training where NIS='" + tabelKlik + "'";
            PreparedStatement pst = connect.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String add0 = rs.getString("NIS");
                cariNIS2.setText(add0);
                String add1 = rs.getString("NIS");
                NISTraining.setText(add1);
                String add2 = rs.getString("rata2Raport");
                rataTraining.setText(add2);
                String add3 = rs.getString("TestPsikologi");
                psikologiTraining.setText(add3);
                String add4 = rs.getString("kelas");
                kelasTraining.setText(add4);
            }

        } catch (SQLException ex) {
            Logger.getLogger(frameUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelTrainingMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String nisTraining = NISTraining.getText();
        String rata2 = rataTraining.getText();
        String psikologi = psikologiTraining.getText();
        String kelas = kelasTraining.getText();
        if (nisTraining.length() != 0 && rata2.length() != 0 && psikologi.length() != 0 && kelas.length() != 0) {
            inputTraining();
        } else {
            JOptionPane.showMessageDialog(null, "Data belum lengkap, silahkan lengkapi terlebih dulu sebelum menambah data.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        deleteTraining();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (NISTesting.getText().length() != 0) {
            int n = JOptionPane.showConfirmDialog(null, "Apa Anda yakin ingin mengubah data?", "Konfirmasi Edit Data",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                updateTesting();
            } else {
                JOptionPane.showMessageDialog(null, "Klik baris pada tabel, sebelum melakukan edit data.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (NISTraining.getText().length() != 0) {
            int n = JOptionPane.showConfirmDialog(null, "Apa Anda yakin ingin mengubah data?", "Konfirmasi Edit Data",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                updateTraining();
            } else {
                JOptionPane.showMessageDialog(null, "Klik baris pada tabel, sebelum melakukan edit data.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameUtama().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NAMA;
    private javax.swing.JTextField NISTesting;
    private javax.swing.JTextField NISTraining;
    private javax.swing.JTextField bi;
    private javax.swing.JTextField bing;
    private javax.swing.JTextField bio;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JTextField cariNIS;
    private javax.swing.JTextField cariNIS1;
    private javax.swing.JTextField cariNIS2;
    private javax.swing.JTextField eko;
    private javax.swing.JTextField fis;
    private javax.swing.JTextField geo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField kelasTraining;
    private javax.swing.JTextField kim;
    private javax.swing.JTextField mtk;
    private javax.swing.JTextField nis;
    private javax.swing.JTextField psikologiTesting;
    private javax.swing.JTextField psikologiTraining;
    private javax.swing.JTextField rataTesting;
    private javax.swing.JTextField rataTraining;
    private javax.swing.JTextField sej;
    private javax.swing.JTable tabelTesting;
    private javax.swing.JTable tabelTraining;
    private javax.swing.JTextField testPsikolog;
    private javax.swing.JLabel tx_hasilKlasifikasi;
    // End of variables declaration//GEN-END:variables
}
