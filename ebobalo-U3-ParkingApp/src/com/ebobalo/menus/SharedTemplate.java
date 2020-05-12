package com.ebobalo.menus;

public class SharedTemplate {

    private static String _topFirstLine = "________________________________";
    private static String _topSecondLine = "--------------------------------";

    public static void topView(){
        System.out.println();
        System.out.println("Best Value Parking Garage");
        System.out.println(_topFirstLine);
        System.out.println(_topSecondLine);
    }
}
