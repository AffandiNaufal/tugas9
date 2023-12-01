package mahasiswa;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class mahasiswa extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox Tanggal;
    private JComboBox Bulan;
    private JComboBox Tahun;
    private JButton button1;
    private JTextArea Nama;
    private JTextArea TanggalLahir;
    private JTextArea Alamat;
    private JTextArea Usia;

    public mahasiswa() {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textField1.getText();
                int tlTanggal = Integer.parseInt((String) Tanggal.getSelectedItem());
                int tlBulan = Bulan.getSelectedIndex() + 1;
                int tlTahun = Integer.parseInt((String) Tahun.getSelectedItem());
                String alamat = textField2.getText();

                Nama.setText("Nama              :" + " " + nama);
                TanggalLahir.setText("Tanggal Lahir           :" + " " + tlTanggal + " " + Bulan.getSelectedItem() + " " + tlTahun);
                Alamat.setText("Alamat              :" + " " + alamat);


                LocalDate birthdate = LocalDate.of(tlTahun, tlBulan, tlTanggal);
                LocalDate currentDate = LocalDate.now();
                Period period = Period.between(birthdate, currentDate);

                int years = period.getYears();
                int months = period.getMonths();
                int days = period.getDays();

                Usia.setText("Usia          :" + " " + years + " tahun, " + months + " bulan, " + days + " hari");
            }
        });

    }

    public static void main(String[] args) {
        mahasiswa Mahasiswa = new mahasiswa();
        Mahasiswa.setVisible(true);
}

}
