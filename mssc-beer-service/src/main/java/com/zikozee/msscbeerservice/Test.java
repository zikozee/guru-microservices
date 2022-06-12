package com.zikozee.msscbeerservice;

import org.apache.tomcat.jni.Local;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 19 May 2022
 */

public class Test {
    public static void main(String[] args) {
//        System.out.println(new BigDecimal("0").compareTo(BigDecimal.ZERO) != 0);
//
//        String reviewDate = "2022-05-21";
//        LocalDate localDate  = bodDateToLocalDate(reviewDate, "yyyy-MM-dd").plusMonths(1);
//        System.out.println(localDate);
////        String data  = bodDateToLocalDate(reviewDate, "dd-MMM-yyyy").plusMonths(1).toString();
//        String format = localDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyy"));
//        System.out.println(format);
//
//        System.out.println(BigDecimal.valueOf(94.8).divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP));

//        System.out.println(BigDecimal.valueOf(0.948).setScale(2));

        System.out.println("==============================================");
//        BigDecimal instalment = getInstalment(12, 95.0, BigDecimal.valueOf(10000.00)).setScale(2, RoundingMode.UP);
////        BigDecimal dd = BigDecimal.valueOf(BigDecimal.valueOf(0.948).doubleValue() * (double)100/12);
//        BigDecimal dd = BigDecimal.valueOf(BigDecimal.valueOf(0.948).doubleValue() * (double)100/12).setScale(2, RoundingMode.UP);
//        System.out.println(dd);
//        System.out.println(instalment);

//        System.out.println(BigDecimal.valueOf(0.948));
        System.out.println("========>>>>>>>MY THOUGHTS \uD83E\uDD14. \n========>>>>>>>MY CODE </>.\n========>>>>>>>Innovates\uD83D\uDCA1the World \uD83C\uDF0E");
        System.out.println("==============================================");

        System.out.println(bodDay("2022-03-17"));
        String dd = UUID.randomUUID().toString();
        System.out.println(dd);
        String ss =String.valueOf(new Date().toInstant().toEpochMilli());
        System.out.println(ss);
        System.out.println(UUID.randomUUID() + "-" + ss);
    }

    public static LocalDate bodDateToLocalDate(String bodDate, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.US);
        return LocalDate.parse(bodDate, formatter);
    }



    public static BigDecimal getInstalment(int tenure, double rate, BigDecimal loanAmount) {

        double monthlyRate = rate / 12 /100;
        double denominator = 1 - Math.pow(1 + monthlyRate, (tenure * -1));
        return new BigDecimal(monthlyRate).multiply(loanAmount).divide(new BigDecimal(denominator), 2, RoundingMode.UP);
    }

    public static String bodDay(String bodDate){
        LocalDate localDate = bodDateToLocalDate(bodDate, "yyyy-MM-dd");
        return String.valueOf(localDate.getDayOfMonth());
    }
}
