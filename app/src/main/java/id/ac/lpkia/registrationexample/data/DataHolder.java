package id.ac.lpkia.registrationexample.data;

import java.util.ArrayList;

public class DataHolder {
    public static ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();

    public static void initData() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama("Ahmad Luthfi Nasrulloh");
        mahasiswa.setEmail("luthfiahmad36@gmail.com");
        mahasiswa.setUsername("luthfi");
        mahasiswa.setPassword("12345");
        mahasiswa.setJenisKelamin("Laki - laki");
        mahasiswa.setProvinsi("Jawa Tengah");
        mahasiswas.add(mahasiswa);
    }

    public static void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswas.add(mahasiswa);
    }

    public static void updateMahasiswa(int index, Mahasiswa mahasiswa) {
        mahasiswas.set(index, mahasiswa);
    }

    public static Mahasiswa getByUsername(String username) {
        for (Mahasiswa m : mahasiswas) {
            if (m.getUsername().equals(username)) {
                return m;
            }
        }
        return null;
    }

    public static int getCountMahasiswa() {
        return mahasiswas.size();
    }

    public static String[] getData(int i) {
        String[] data = new String[6];
        data[0] = mahasiswas.get(i).getNama();
        data[1] = mahasiswas.get(i).getEmail();
        data[2] = mahasiswas.get(i).getPassword();
        data[3] = mahasiswas.get(i).getJenisKelamin();
        data[4] = mahasiswas.get(i).getProvinsi();
        data[5] = mahasiswas.get(i).getUsername();
        return data;
    }

    public static int getIndexMahasiswa(String value) {
        int i=0;
        for (Mahasiswa m : mahasiswas) {
            if (m.getUsername().equals(value)) {
                return i;
            }
            i += 1;
        }
        return Integer.parseInt(null);
    }
}
