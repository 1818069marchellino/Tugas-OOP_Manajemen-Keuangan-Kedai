/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gaji_Kedai;

/**
 *
 * @author march
 */
public class Karyawan extends Pegawai {
    int GjTotal;
    public Karyawan(){
        this.nama = nama;
        this.alamat = alamat;
    }
    @Override
    int hitGaji() {
        GjTotal = GjPokok;
        return GjTotal;
    }
}
