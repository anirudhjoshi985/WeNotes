package com.anirudh.wenotes;

public class Course {


   private String courseName;
   private int pdfCount;
   private int imagesrc;


    public Course(String courseName, int pdfCount, int imagesrc) {
        this.courseName = courseName;
        this.pdfCount = pdfCount;
        this.imagesrc = imagesrc;
    }


    public String getCourseName() {
        return courseName;
    }

    public int getImagesrc() {
        return imagesrc;
    }

    public int getPdfCount() {
        return pdfCount;
    }
}