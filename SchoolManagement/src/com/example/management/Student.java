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

    public double calculateAverage() {
        return (mathGrade + englishGrade + scienceGrade) / 3;
    }
    public  double CalculateTotal(){
        return(mathGrade + englishGrade + scienceGrade);
    }





    public String getName() {
        return name;
    }

}
