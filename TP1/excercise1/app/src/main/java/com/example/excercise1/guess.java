package com.example.excercise1;

import java.util.Random;

public class guess {
    final int min = 0;
    final int max = 100;
    final int random = new Random().nextInt((max - min) + 1) + min;
}
