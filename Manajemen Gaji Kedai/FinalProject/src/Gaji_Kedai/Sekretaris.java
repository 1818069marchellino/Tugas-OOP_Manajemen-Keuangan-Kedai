/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gaji_Kedai;

/**
 *
 * @author march
 */
public class Sekretaris extends Pegawai {
    int GjTotal,jmlHadir,T_hadir;
    public Sekretaris(){
        this.nama = "Tesa";
        this.alamat = "jl.Semeru";
        this.jmlHadir = 0;
        this.T_hadir = 25000;
    }
    @Override
    int hitGaji() {
        GjTotal = GjPokok + (jmlHadir*T_hadir);
        return GjTotal;
    };
}
