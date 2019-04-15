package com.gupaoedu.vip.pattern.template.course;

public abstract class NetworkCourse {

    protected final void createCourse(){
        //1、发布预习资料
        this.postPreSource();

        //2、制作PPT课件
        this.createPPT();

        //3、在线直播
        this.onlive();

        //4、提交课件
        this.postNote();

        //5、提交源码
        this.postSource();


        //6、检查作业
        if(needHomeWork()){
            this.checkHomeWork();
        }

    }

    protected abstract void checkHomeWork();

    //钩子方法，对步骤进行微调
    protected boolean needHomeWork(){
        return false;
    }

    final void postSource() {
        System.out.println("5、提交源码...");
    }

    final void postNote() {
        System.out.println("4、提交课堂笔记和课件...");
    }

    final void onlive() {
        System.out.println("3、在线授课...");
    }

    final void createPPT() {
        System.out.println("2、制作PPT课件...");
    }

    final void postPreSource() {
        System.out.println("1、发布预习资料...");
    }
}
