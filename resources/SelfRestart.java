//package com.infoshare.drinkywinky.properties;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.management.ManagementFactory;
//
//public class SelfRestart {
//    public static void main() throws IOException, InterruptedException {
//        StringBuilder cmd = new StringBuilder();
//        cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
//        for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
//            cmd.append(jvmArg + " ");
//        }
//        cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
//        cmd.append(SelfRestart.class.getName()).append(" ");
//        String[] args = new String[0];
//        for (String arg : args) {
//            cmd.append(arg).append(" ");
//        }
//        Thread.currentThread().sleep(10000);
//        Runtime.getRuntime().exec(cmd.toString());
//        System.exit(0);
//    }
//    }
