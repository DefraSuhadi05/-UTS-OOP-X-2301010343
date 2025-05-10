import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Rosdalima Wulandefriani Suhadi
 * NIM 2301010343
 * TGL 10 Mei 2025
 */
public class Buku {
    private String kodeBuku;  
    private String judul;     
    private String penulis;   
    
    public Buku() {
        this.kodeBuku = "";
        this.judul = "";
        this.penulis = "";
    }
    public Buku(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
    }
    public String getKodeBuku() {
        return kodeBuku;
    }
    public String getJudul() {
        return judul;
    }
    public String getPenulis() {
        return penulis;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
    public void tampilkanInfo() {
        System.out.println("Kode Buku  : " + kodeBuku);
        System.out.println("Judul      : " + judul);
        System.out.println("Penulis    : " + penulis);
        System.out.println("-----------------------------");
    }
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<Buku> bukuList = new ArrayList<>();
            int pilihan;

        do {
             // Menu aplikasi
        System.out.println("=== MENU Aplikasi Manajemen Buku Perpustakaan ===");
        System.out.println("1. Tambah Data Buku");
        System.out.println("2. Tampilkan Data Buku");
        System.out.println("3. Ubah Data Buku");
        System.out.println("4. Hapus Data Buku");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
            input.nextLine(); 

        if (pilihan == 1) {
            // Menambah data buku
        System.out.print("Masukkan Kode Buku: ");
        String kodeBuku = input.nextLine();
        System.out.print("Masukkan Judul Buku: ");
        String judul = input.nextLine();
        System.out.print("Masukkan Penulis Buku: ");
        String penulis = input.nextLine();

                    bukuList.add(new Buku(kodeBuku, judul, penulis));
        System.out.println("Data buku berhasil ditambahkan.\n");
                } 
        else if (pilihan == 2) {
             // Menampilkan data buku
        if (bukuList.isEmpty()) {
        System.out.println("Belum ada data buku.\n");
        } else {
        System.out.println("=== DAFTAR BUKU ===");
        System.out.printf("%-5s %-15s %-30s %-20s\n", "No", "Kode Buku", "Judul", "Penulis");
                        for (int i = 0; i < bukuList.size(); i++) {
        System.out.printf("%-5d %-15s %-30s %-20s\n", (i + 1),
                   bukuList.get(i).getKodeBuku(),
                   bukuList.get(i).getJudul(),
                   bukuList.get(i).getPenulis());
                        }
                        System.out.println();
                    }
                } 
        else if (pilihan == 3) {
                    // Mengubah data buku
        System.out.print("Masukkan Kode Buku yang ingin diubah: ");
        String kodeCari = input.nextLine();
                    boolean ditemukan = false;

        for (Buku buku : bukuList) {
        if (buku.getKodeBuku().equals(kodeCari)) {
        System.out.print("Masukkan Judul Baru: ");
        String judulBaru = input.nextLine();
        System.out.print("Masukkan Penulis Baru: ");
        String penulisBaru = input.nextLine();

            buku.setJudul(judulBaru);
            buku.setPenulis(penulisBaru);
            System.out.println("Data buku berhasil diubah.\n");
            ditemukan = true;
                        break;
         }
            }
        if (!ditemukan) {
        System.out.println("Data buku tidak ditemukan.\n");
            }
        } 
        else if (pilihan == 4) {
            // Menghapus data buku
        System.out.print("Masukkan Kode Buku yang ingin dihapus: ");
        String kodeHapus = input.nextLine();
        boolean ditemukan = false;
        
        for (int i = 0; i < bukuList.size(); i++) {
        if (bukuList.get(i).getKodeBuku().equals(kodeHapus)) {
            bukuList.remove(i);
            System.out.println("Data buku berhasil dihapus.\n");
            ditemukan = true;
                        break;
            }
        }
        if (!ditemukan) {
        System.out.println("Data buku tidak ditemukan.\n");
              }
                } 
        else if (pilihan == 5) {
        System.out.println("Terima kasih!");
                } 
        else {
        System.out.println("Pilihan tidak valid.\n");
                }
       } while (pilihan != 5);
    }
  }
}

