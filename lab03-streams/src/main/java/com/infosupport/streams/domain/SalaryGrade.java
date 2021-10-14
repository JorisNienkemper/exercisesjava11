package com.infosupport.streams.domain;

public class SalaryGrade {

    private final int grade;
    private final double highCutoff;
    private final double lowCutoff;

    public SalaryGrade(int grade, double highCutoff, double lowCutoff) {
        this.grade = grade;
        this.highCutoff = highCutoff;
        this.lowCutoff = lowCutoff;
    }

    public int getGrade() {
        return grade;
    }

    public double getHighCutoff() {
        return highCutoff;
    }

    public double getLowCutoff() {
        return lowCutoff;
    }

    @Override
    public String toString() {
        return "SalaryGrades [grade=" + grade + ", highCutoff=" + highCutoff + ", lowCutoff=" + lowCutoff + "]";
    }
}

class SalaryGradeData {
    private final int grade;
    private final double highCutoff;
    private final double lowCutoff;

    public SalaryGradeData(int grade, double lowCutoff, double highCutoff) {
        this.grade = grade;
        this.highCutoff = highCutoff;
        this.lowCutoff = lowCutoff;
    }


    public SalaryGrade createSalaryGrade(){
        return new SalaryGrade(grade,highCutoff,lowCutoff);
    }
}
