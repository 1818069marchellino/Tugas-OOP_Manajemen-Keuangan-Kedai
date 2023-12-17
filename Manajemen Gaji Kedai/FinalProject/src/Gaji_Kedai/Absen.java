/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gaji_Kedai;

/**
 *
 * @author march
 */
public class Absen extends Pegawai{
    int GjTotal, hadir, perhari;
    public Absen()
    {
        this.nama = nama;
        this.alamat = alamat;
        this.GjTotal = GjTotal;
        this.hadir = 0;
        this.perhari = 140000;
    }
    @Override
    int hitGaji() {
        GjTotal = hadir + perhari;
        return GjTotal;
    }   
}
