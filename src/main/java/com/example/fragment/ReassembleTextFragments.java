package com.example.fragment;

import com.example.fragment.algorithm.TextReassemblerImpl;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReassembleTextFragments {

    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
            String fragmentProblem;
            while ((fragmentProblem = in.readLine()) != null) {
                System.out.println(new TextReassemblerImpl().reassemble(fragmentProblem));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
