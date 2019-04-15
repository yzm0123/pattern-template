package com.gupaoedu.vip.pattern.template.course;

public class BigDataCourse extends NetworkCourse {

    private boolean isNeedHomeWorkFlag;

    public BigDataCourse(boolean isNeedHomeWorkFlag) {
        this.isNeedHomeWorkFlag = isNeedHomeWorkFlag;
    }

    @Override
    protected void checkHomeWork() {
        System.out.println("检查大数据算法...");
    }

    @Override
    protected boolean needHomeWork() {
        return this.isNeedHomeWorkFlag;
    }
}
