package com.example.management;

public class Student {
    private String name;
    private  double mathGrade;
    private  double englishGrade;
    private  double scienceGrade;

    public Student(String name, double mathGrade, double englishGrade, double scienceGrade) {
        this.name = name;
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.scienceGrade = scienceGrade;



    }




    public  double calculateAverage() {
        double average = (mathGrade + englishGrade + scienceGrade) / 3.0;
        return Math.round(average * 100.0) / 100.0;
    }
    public  double CalculateTotal(){
        return(mathGrade + englishGrade + scienceGrade);
    }

    public double getScienceGrade() {
        return scienceGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public String getName() {
        return name;
    }



}
