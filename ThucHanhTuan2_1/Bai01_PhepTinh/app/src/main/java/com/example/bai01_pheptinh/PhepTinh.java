package com.example.bai01_pheptinh;

public class PhepTinh {
    private int soA;
    private int soB;

    public PhepTinh(int soA, int soB) {
        this.soA = soA;
        this.soB = soB;
    }

    public int tinhTong() {
        return soA+soB;
    }

    public int tinhHieu() {
        return soA-soB;
    }

    public int tinhTich() {
        return soA*soB;
    }

    public float tinhThuong() {
        return (float) soA/soB;
    }

    public int tinhUocChungLonNhat() {
        while (soA != soB) {
            if (soA > soB) {
                soA = soA - soB;
            } else {
                soB = soB - soA;
            }
        }
        return soB;
    }
}
