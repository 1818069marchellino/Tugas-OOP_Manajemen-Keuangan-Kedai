/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gaji_Kedai;

/**
 *
 * @author march
 */
public abstract class Pegawai {
    String nama,alamat;
    int GjPokok;
    Pegawai(){
        this.GjPokok = 3220000;
    }
    abstract int hitGaji();
}
