package com.cxf.test;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        String str = "MULTIPOLYGON (((2528974.673 38611618.128, 2528850.896 38611522.454, 2528838.669 38611514.664, 2528826.049 38611507.526, 2528813.071 38611501.062, 2528799.772 38611495.287, 2528786.188 38611490.219, 2528772.357 38611485.871, 2528758.316 38611482.256, 2528725.998 38611474.833, 2528702.02 38611489.854, 2528663.057 38611639.036, 2528677.131 38611725.107,  2528740.378 38611693.581, 2528923.256 38611639.152)),((2529024.871 38611663.977, 2529019.304 38611672.803, 2528945.853 38611702.837, 2528695.806 38611788.425, 2528695.665 38611895.098, 2528772.136 38611895.025, 2529046.808 38611879.69, 2529047.273 38611685.736)))";
//        String str = "POLYGON ((39709.70 101168.34, 39687.99 100970.00, 39868.25 100947.49, 39869.82 100964.16, 39886.42 101140.49))";
        StringBuilder stringBuilder = new StringBuilder(str);

//        //检查是否为“POLYGON (( ”后一个空格是否存在
//        String strSpace = stringBuilder.substring(10, 11);
//        if (!" ".equals(strSpace)) {
//            stringBuilder.insert(10, " ");
//        }
//
//        //xy坐标调转
//        String[] split = stringBuilder.substring(11, stringBuilder.length() - 2).split(",");
//        String str1 = "POLYGON (( ";
//        for (String elm : split) {
//            if (elm.startsWith(" ")){
//                elm = elm.substring(1,elm.length());
//            }
//            String[] s = elm.split(" ");
//            str1 += s[1] + " " + s[0] + ", ";
//        }
//        stringBuilder = new StringBuilder(str1);
//        stringBuilder = stringBuilder.delete(stringBuilder.lastIndexOf(","),stringBuilder.length()).append("))");
//        System.out.println(stringBuilder.toString());
//
//        //检查是否闭合
//        String str1stPoint = stringBuilder.substring(11, stringBuilder.indexOf(","));
//        String strLastPoint = stringBuilder.substring(stringBuilder.lastIndexOf(",") + 2, stringBuilder.length() - 2);
//        if (!str1stPoint.equals(strLastPoint)) {
//            stringBuilder.insert(stringBuilder.length() - 2, ", " + str1stPoint);
//        }
//        System.out.println(stringBuilder.toString());

        //检查是否为“MULTIPOLYGON ((( ”后一个空格是否存在
        String strSpace = stringBuilder.substring(16, 17);
        if (!" ".equals(strSpace)) {
            stringBuilder.insert(16, " ");
        }

        String[] split = stringBuilder.toString().split("\\)\\),\\(\\(");
        List<String> lstResult = new ArrayList<String>();
        for (String string : split) {
            String multipolygon = string.replace("MULTIPOLYGON ((( ", "").replace(")))", "");

            //xy调转
            String str1 = "";
            String[] split1 = multipolygon.split(",");
            for (String elm : split1) {
                if (elm.startsWith(" ")) {
                    elm = elm.substring(1, elm.length());
                }
                String[] s = elm.split(" ");
                str1 += s[1] + " " + s[0] + ", ";
            }
            multipolygon = new StringBuilder(str1).delete(str1.lastIndexOf(","),str1.length()).toString();

            String str1stPoint = multipolygon.substring(0, multipolygon.indexOf(","));
            String strLastPoint = multipolygon.substring(multipolygon.lastIndexOf(",") + 2);
            if (!str1stPoint.equals(strLastPoint)) {
                multipolygon += ", " + str1stPoint;
            }
            System.out.println(multipolygon);
            lstResult.add(multipolygon);
        }
        String strMultipolygon = "MULTIPOLYGON ((( ";
        for (String str2 : lstResult) {
            strMultipolygon += str2 + ")),((";
        }
        StringBuilder builder = new StringBuilder(strMultipolygon);
        builder = builder.delete(builder.lastIndexOf(","), builder.length()).append(")");
        System.out.println(builder.toString());
    }
}
